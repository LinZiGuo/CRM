package com.ssh.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 字典表实体类
 * @author 郭子灵
 *
 */
@Entity
@Table(name="base_dict")
public class BaseDict implements Serializable {

	@Id
	@Column(name="dict_id")
	private String dictId;
	
	@Column(name="dict_type_code")
	private String dictTypeCode;
	
	@Column(name="dict_type_name")
	private String dictTypeName;
	
	@Column(name="dict_item_code")
	private String dictItemCode;
	
	@Column(name="dict_item_name")
	private String dictItemName;
	
	@Column(name="dict_sort")
	private Integer dictSort;
	
	@Column(name="dict_enable")
	private String dictEnable;
	
	@Column(name="dict_memo")
	private String dictMemo;
	
	public String getDictId() {
		return dictId;
	}
	public void setDictId(String dictId) {
		this.dictId = dictId;
	}
	public String getDictTypeCode() {
		return dictTypeCode;
	}
	public void setDictTypeCode(String dictTypeCode) {
		this.dictTypeCode = dictTypeCode;
	}
	public String getDictTypeName() {
		return dictTypeName;
	}
	public void setDictTypeName(String dictTypeName) {
		this.dictTypeName = dictTypeName;
	}
	public String getDictItemCode() {
		return dictItemCode;
	}
	public void setDictItemCode(String dictItemCode) {
		this.dictItemCode = dictItemCode;
	}
	public String getDictItemName() {
		return dictItemName;
	}
	public void setDictItemName(String dictItemName) {
		this.dictItemName = dictItemName;
	}
	public Integer getDictSort() {
		return dictSort;
	}
	public void setDictSort(Integer dictSort) {
		this.dictSort = dictSort;
	}
	public String getDictEnable() {
		return dictEnable;
	}
	public void setDictEnable(String dictEnable) {
		this.dictEnable = dictEnable;
	}
	public String getDictMemo() {
		return dictMemo;
	}
	public void setDictMemo(String dictMemo) {
		this.dictMemo = dictMemo;
	}
	@Override
	public String toString() {
		return "BaseDict [dictId=" + dictId + ", dictTypeCode=" + dictTypeCode + ", dictTypeName=" + dictTypeName
				+ ", dictItemCode=" + dictItemCode + ", dictItemName=" + dictItemName + ", dictSort=" + dictSort
				+ ", dictEnable=" + dictEnable + ", dictMemo=" + dictMemo + "]";
	}
	
	
}
