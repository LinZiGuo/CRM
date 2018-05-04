package com.ssh.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.apache.commons.lang3.StringUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.BaseDict;
/**
 * 客户的动作类
 * @author 郭子灵
 *
 */
import com.ssh.domain.Customer;
import com.ssh.service.ICustomerService;
import com.ssh.web.commons.Page;
@Controller("customerAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/customer")
@Results({
	@Result(name="addUI",type="dispatcher",location="/jsp/customer/add.jsp"),
	@Result(name="editUICustomer",type="dispatcher",location="/jsp/customer/edit.jsp"),
	@Result(name="findAllCustomer",type="dispatcher",location="/jsp/customer/list.jsp"),
	@Result(name="listCustomer",type="redirectAction",location="findAllCustomer")
})
public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	private Customer customer = new Customer();
	@Resource(name="customerService")
	private ICustomerService customerService;
	
	private List<BaseDict> custSources;
	private List<BaseDict> custLevels;
	
	private Page page;
	private Integer num;
	@Override
	public Customer getModel() {
		return customer;
	}
	
	/**
	 * 编辑客户
	 * @return
	 */
	@Action("editCustomer")
	public String editCustomer() {
		customerService.update(customer);
		return "listCustomer";
	}
	
	/**
	 * 获取修改客户页面
	 * @return
	 */
	@Action("editUICustomer")
	public String editUICustomer() {
			//1.查询所有客	来源	
			custSources = customerService.findAllCustomerSource();
			
			//2.查询所有客户级别
			custLevels = customerService.findAllCustomerLevel();
			
			//3.根据Id查询要编辑的客户
			//第一种：自己定义一个变量，接受查询结果
			Customer c = customerService.findCustomerById(customer.getCustId());
			//第二种：直接使用模型接收
//			customer = customerService.findCustomerById(customer.getCustId());
			
			//4.把查询出来的对象压入栈顶
			ActionContext.getContext().getValueStack().push(c);
			
		return "editUICustomer";
	}
	
	/**
	 * 根据Id删除客户
	 * @return
	 */
	@Action("removeCustomer")
	public String removeCustomer() {
		customerService.removeCustomer(customer.getCustId());
		return "listCustomer";
	}
	
	/**
	 * 获取添加客户页面
	 * @return
	 */
	@Action("addUICustomer")
	public String addUICustomer() {
		//1.查询所有客户来源
		custSources = customerService.findAllCustomerSource();
		
		//2.查询所有客户级别
		custLevels = customerService.findAllCustomerLevel();
		
		return "addUI";
	}
	
	/**
	 * 新增客户
	 * @return
	 */
	@Action("addCustomer")
	public String addCustomer() {
		customerService.saveCustomer(customer);
		return "listCustomer";
	}
	
	/**
	 * 查询客户列表
	 * @return
	 */
	@Action("findAllCustomer")
	public String findAllCustomer() {
		//1.定义离线对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
		//2.拼装查询条件
		if (StringUtils.isNotBlank(customer.getCustName())) {
			detachedCriteria.add(Restrictions.like("custName", "%"+customer.getCustName()+"%"));
		}
		if (StringUtils.isNotBlank(customer.getCustIndustry())) {
			detachedCriteria.add(Restrictions.like("custIndustry", "%"+customer.getCustIndustry()+"%"));
		}
		if (customer.getCustLevel()!=null&&StringUtils.isNotBlank(customer.getCustLevel().getDictId())) {
			detachedCriteria.add(Restrictions.eq("custLevel.dictId", customer.getCustLevel().getDictId()));
		}
		if (customer.getCustSource()!=null&&StringUtils.isNotBlank(customer.getCustSource().getDictId())) {
			detachedCriteria.add(Restrictions.eq("custSource.dictId", customer.getCustSource().getDictId()));
		}
		
		//3.根据离线对象查询客户
		page = customerService.findAllCustomer(detachedCriteria,num);
		
		//4.查询所有客户来源	
		custSources = customerService.findAllCustomerSource();
		
		//5.查询所有客户级别
		custLevels = customerService.findAllCustomerLevel();
		
		return "findAllCustomer";
	}

	public List<BaseDict> getCustSources() {
		return custSources;
	}

	public void setCustSources(List<BaseDict> custSources) {
		this.custSources = custSources;
	}

	public List<BaseDict> getCustLevels() {
		return custLevels;
	}

	public void setCustLevels(List<BaseDict> custLevels) {
		this.custLevels = custLevels;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
	
}
