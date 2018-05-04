package com.ssh.web.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.domain.Customer;
import com.ssh.domain.LinkMan;
import com.ssh.service.ICustomerService;
import com.ssh.service.ILinkmanService;
/**
 * 联系人的动作类
 * @author 郭子灵
 *
 */

@Controller("LinkmanAction")
@Scope("prototype")
@ParentPackage("struts-default")
@Namespace("/linkman")
@Results({
	@Result(name="addUI",type="dispatcher",location="/jsp/linkman/add.jsp"),
	@Result(name="editUILinkman",type="dispatcher",location="/jsp/linkman/edit.jsp"),
	@Result(name="findAllLinkman",type="dispatcher",location="/jsp/linkman/list.jsp"),
	@Result(name="listLinkman",type="redirectAction",location="findAllLinkman")
})
public class LinkmanAction extends ActionSupport implements ModelDriven<LinkMan> {

	private LinkMan linkMan = new LinkMan();
	private List<Customer> customers;
	@Resource(name="customerService")
	private ICustomerService customerService;
	@Resource(name="linkmanService")
	private ILinkmanService linkmanService;
	private List<LinkMan> linkMans;
	
	@Override
	public LinkMan getModel() {
		return linkMan;
	}
	
	/**
	 * 修改联系人
	 * @return
	 */
	@Action("editLinkman")
	public String editLinkman() {
		linkmanService.updateLinkman(linkMan);
		return "listLinkman";
	}
	
	/**
	 * 获取修改联系人页面
	 * @return
	 */
	@Action("editUILinkman")
	public String editUILinkman() {
		//1.查询所属客户	
		customers = customerService.findAllCustomer();
		
		//2.根据Id查询联系人
		LinkMan lkm = linkmanService.findById(linkMan.getLkmId());
		
		//3.把查询出来的对象压入栈顶
		ActionContext.getContext().getValueStack().push(lkm);
		
		return "editUILinkman";
	}
	
	/**
	 * 根据Id删除联系人
	 * @return
	 */
	@Action("removeLinkman")
	public String removeLinkman() {
		linkmanService.removeLinkman(linkMan.getLkmId());
		return "listLinkman";
	}
	
	/**
	 * 查询联系人列表
	 * @return
	 */
	@Action("findAllLinkman")
	public String findAllLinkman() {
		//1.定义离线对象
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(LinkMan.class);
		
		//2.拼装查询条件
		if (StringUtils.isNotBlank(linkMan.getLkmName())) {
			detachedCriteria.add(Restrictions.like("lkmName", "%"+linkMan.getLkmName()+"%"));
		}
		if (linkMan.getCustomer()!=null&&linkMan.getCustomer().getCustId()!=null) {
			detachedCriteria.add(Restrictions.eq("customer.custId", linkMan.getCustomer().getCustId()));
		}
		
		//3.根据离线对象查询客户
		linkMans = linkmanService.findAllLinkman(detachedCriteria);
		
		//4.查询所属客户	
		customers = customerService.findAllCustomer();

		return "findAllLinkman";
	}
	
	/**
	 * 新增联系人
	 * @return
	 */
	@Action("addLinkman")
	public String addLinkman() {
		linkmanService.saveLinkman(linkMan);
		return "listLinkman";
	}

	/**
	 * 获取添加联系人页面
	 * @return
	 */
	@Action("addUILinkMan")
	public String addUILinkMan() {
		//1.查询所属客户
		customers = customerService.findAllCustomer();
		
		return "addUI";
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<LinkMan> getLinkMans() {
		return linkMans;
	}

	public void setLinkMans(List<LinkMan> linkMans) {
		this.linkMans = linkMans;
	}
	
}
