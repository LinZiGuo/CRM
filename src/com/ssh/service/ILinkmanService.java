package com.ssh.service;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import com.ssh.domain.LinkMan;

public interface ILinkmanService {

	/**
	 * 新增联系人
	 * @param linkMan 
	 */
	void saveLinkman(LinkMan linkMan);

	/**
	 * 根据条件查询联系人
	 * @param detachedCriteria
	 * @return
	 */
	List<LinkMan> findAllLinkman(DetachedCriteria detachedCriteria);

	/**
	 * 根据Id删除联系人
	 * @param lkmId
	 */
	void removeLinkman(Long lkmId);

	/**
	 * 根据Id查询联系人
	 * @param lkmId
	 * @return
	 */
	LinkMan findById(Long lkmId);

	/**
	 * 修改联系人
	 * @param linkMan
	 */
	void updateLinkman(LinkMan linkMan);

}
