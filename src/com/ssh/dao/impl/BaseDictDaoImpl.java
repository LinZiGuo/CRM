package com.ssh.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ssh.dao.IBaseDictDao;
import com.ssh.domain.BaseDict;

/**
 * 字典表的持久层实现类
 * @author 郭子灵
 *
 */
@Repository("baseDictDao")
public class BaseDictDaoImpl implements IBaseDictDao {

	@Resource(name="hibernateTemplate")
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 根据字典类型查询字典表数据
	 * @param string
	 * @return
	 */
	@Override
	public List<BaseDict> findBaseDictByTypeCode(String typeCode) {
		return (List<BaseDict>) hibernateTemplate.find("from BaseDict where dictTypeCode = ?", typeCode);
	}

}
