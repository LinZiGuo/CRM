package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ssh.dao.ILinkmanDao;
import com.ssh.domain.LinkMan;

@Repository("linkmanDao")
public class LinkmanDaoImpl implements ILinkmanDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(LinkMan linkMan) {
		hibernateTemplate.save(linkMan);
	}

	@Override
	public List<LinkMan> find(DetachedCriteria detachedCriteria) {
		return (List<LinkMan>) hibernateTemplate.findByCriteria(detachedCriteria);
	}

	@Override
	public void removeLinkman(Long lkmId) {
		hibernateTemplate.delete(findById(lkmId));
	}

	public LinkMan findById(Long lkmId) {
		return hibernateTemplate.get(LinkMan.class, lkmId);
	}

	@Override
	public void updateLinkman(LinkMan linkMan) {
		hibernateTemplate.update(linkMan);
	}

}
