package com.ssh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssh.domain.Customer;

/**
 * 客户的持久层接口
 * @author 郭子灵
 *
 */
public interface ICustomerDao {

	/**
	 * 查询总记录条数
	 * @param detachedCriteria	查询的条件
	 * @return
	 */
	int findTotalRecords(DetachedCriteria detachedCriteria);
	
	/**
	 * 查询客户列表
	 * @param detachedCriteria	查询的条件
	 * @param firstResult		查询的开始记录索引
	 * @param maxResults		每次查询记录的条数
	 * @return
	 */
	List<Customer> findAll(DetachedCriteria detachedCriteria,int firstResult,int maxResults);

	/**
	 * 保存客户信息
	 * @param customer
	 */
	void save(Customer customer);

	/**
	 * 根据Id删除客户
	 * @param custId
	 */
	void delete(Long custId);

	/**
	 * 根据Id查询客户
	 * @param custId
	 * @return
	 */
	Customer findById(Long custId);

	/**
	 * 编辑客户
	 * @param customer
	 */
	void update(Customer customer);

	/**
	 * 使用投影查询用户列表
	 * @return
	 */
	List<Customer> findAll();

}
