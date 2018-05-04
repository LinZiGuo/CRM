package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ssh.dao.ICustomerDao;
import com.ssh.domain.Customer;

/**
 * 客户的持久层实现类
 * @author 郭子灵
 *
 */
@Repository("customerDao")
public class CustomerDaoImpl implements ICustomerDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;

	@Override
	public void save(Customer customer) {
		hibernateTemplate.save(customer);
	}

	@Override
	
	public void delete(Long custId) {
		hibernateTemplate.delete(findById(custId));
	}
	
	/**
	 * 根据Id查询客户
	 * @param custId
	 * @return
	 */
	public Customer findById(Long custId) {
		return hibernateTemplate.get(Customer.class, custId);
	}

	/**
	 * 编辑客户
	 */
	@Override
	public void update(Customer customer) {
		hibernateTemplate.update(customer);
	}

	@Override
	public List<Customer> findAll() {
		return (List<Customer>) hibernateTemplate.find("select new Customer(custId,custName) from Customer");
	}

	@Override
	public int findTotalRecords(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.count("custId"));	//把select * 变成了 select count(*)
		List<Long> list = (List<Long>) hibernateTemplate.findByCriteria(detachedCriteria);
		return list.isEmpty()?0:list.get(0).intValue();
	}

	@Override
	public List<Customer> findAll(DetachedCriteria detachedCriteria, int firstResult, int maxResults) {
		//把之前的设置给清除掉
		detachedCriteria.setProjection(null);
		List<Customer> list = (List<Customer>) hibernateTemplate.findByCriteria(detachedCriteria, firstResult, maxResults);
		return list;
	}

}
