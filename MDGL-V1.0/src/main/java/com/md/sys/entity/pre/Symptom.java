package com.md.sys.entity.pre;

import java.util.Date;

public class Symptom {
	/**症状id*/
	private Integer id;
	/**症状名称*/
	private String symptomName;
	/**父级症状id*/
	private Integer parentId;
	/**是否显示症状描述 1显示 0不显示*/
	private Integer disType;
	/**创建时间*/
	private Date gmtCreate;
	/**修改时间*/
	private Date gmtModified;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSymptomName() {
		return symptomName;
	}
	public void setSymptomName(String symptomName) {
		this.symptomName = symptomName;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getDisType() {
		return disType;
	}
	public void setDisType(Integer disType) {
		this.disType = disType;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	@Override
	public String toString() {
		return "Symptom [id=" + id + ", symptomName=" + symptomName + ", parentId=" + parentId + ", disType=" + disType
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}

	
	
}
