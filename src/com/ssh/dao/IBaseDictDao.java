package com.ssh.dao;

import java.util.List;

import com.ssh.domain.BaseDict;

/**
 * 字典表持久层接口
 * @author 郭子灵
 *
 */
public interface IBaseDictDao {

	/**
	 * 根据字典类型查询字典表数据
	 * @param string
	 * @return
	 */
	List<BaseDict> findBaseDictByTypeCode(String typeCode);

}
