package com.ssh.test;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssh.domain.Customer;
import com.ssh.service.ICustomerService;

/**
 * 测试客户的业务层方法
 * @author 郭子灵
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:config/applicationContext.xml"})
public class CumtomerServiceTest {

	@Autowired
	private ICustomerService cs;
	
//	@Test
//	public void testFindAll() {
//		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
//		List<Customer> list = cs.findAllCustomer(detachedCriteria);
//		for (Object object : list) {
//			System.out.println(object);
//		}
//	}
//	
//	@Test
//	public void testSave() {
//		Customer customer = new Customer();
//		customer.setCustName("CRM CUSTOMER");
//		cs.saveCustomer(customer);
//	}
}
