package com.ssh.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssh.domain.BaseDict;
import com.ssh.domain.Customer;
import com.ssh.web.commons.Page;

/**
 * 客户的业务层接口
 * @author 郭子灵
 *
 */
public interface ICustomerService {

	/**
	 * 查询客户列表
	 * @param detachedCriteria	查询的条件
	 * @param num				当前页
	 * @return page				封装好的分页信息
	 */
	Page findAllCustomer(DetachedCriteria detachedCriteria,Integer num);
	
	/**
	 * 保存客户信息
	 * @param customer
	 */
	void saveCustomer(Customer customer);

	/**
	 * 查询所有客户来源
	 * @return
	 */
	List<BaseDict> findAllCustomerSource();

	/**
	 * 查询所有客户级别
	 * @return
	 */
	List<BaseDict> findAllCustomerLevel();

	/**
	 * 根据Id删除客户
	 * @param custId
	 */
	void removeCustomer(Long custId);

	/**
	 * 根据Id查询客户
	 * @param custId
	 */
	Customer findCustomerById(Long custId);

	/**
	 * 编辑客户
	 * @param customer
	 */
	void update(Customer customer);

	/**
	 * 使用投影查询客户列表
	 * @return
	 */
	List<Customer> findAllCustomer();
}
