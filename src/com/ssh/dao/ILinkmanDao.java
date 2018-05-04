package com.ssh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.ssh.domain.LinkMan;

/**
 * 联系人的持久层
 * @author 郭子灵
 *
 */
public interface ILinkmanDao {

	/**
	 * 新增联系人
	 * @param linkMan
	 */
	void save(LinkMan linkMan);

	/**
	 * 更加条件查询联系人
	 * @param detachedCriteria
	 * @return
	 */
	List<LinkMan> find(DetachedCriteria detachedCriteria);

	/**
	 * 根据Id删除联系人
	 * @param lkmId
	 */
	void removeLinkman(Long lkmId);

	/**
	 * 根据Id查询联系人
	 * @param lkmId
	 */
	LinkMan findById(Long lkmId);

	/**
	 * 修改联系人
	 * @param linkMan
	 */
	void updateLinkman(LinkMan linkMan);

}
