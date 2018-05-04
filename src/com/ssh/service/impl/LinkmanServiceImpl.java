package com.ssh.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssh.dao.ILinkmanDao;
import com.ssh.domain.LinkMan;
import com.ssh.service.ILinkmanService;

/**
 * 联系人的业务层实现类
 * @author 郭子灵
 *
 */
@Service("linkmanService")
@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
public class LinkmanServiceImpl implements ILinkmanService {

	@Resource(name="linkmanDao")
	private ILinkmanDao linkmanDao;
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void saveLinkman(LinkMan linkMan) {
		linkmanDao.save(linkMan);
	}

	@Override
	public List<LinkMan> findAllLinkman(DetachedCriteria detachedCriteria) {
		return linkmanDao.find(detachedCriteria);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void removeLinkman(Long lkmId) {
		linkmanDao.removeLinkman(lkmId);
	}

	@Override
	public LinkMan findById(Long lkmId) {
		return linkmanDao.findById(lkmId);
	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
	public void updateLinkman(LinkMan linkMan) {
		linkmanDao.updateLinkman(linkMan);
	}

}
