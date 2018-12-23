package com.md.sys.entity.res;

import java.util.Date;

/**症状类型实体类,封装实体数据*/
public class ResSymptomType {

	private Integer id;
	/**服务名称*/
	private String serviceName;
	/**选择状态*/
	private Integer chooseType;
	/**是否生效*/
	private Integer serviceState;
	/**表创建时间*/
	private Date gmtCreate;
	/**表修改时间*/
	private Date gmtModified;
	
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public Integer getChooseType() {
		return chooseType;
	}
	public void setChooseType(Integer chooseType) {
		this.chooseType = chooseType;
	}
	public Integer getServiceState() {
		return serviceState;
	}
	public void setServiceState(Integer serviceState) {
		this.serviceState = serviceState;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	@Override
	public String toString() {
		return "ResSymptomType [id=" + id + ", serviceName=" + serviceName + ", chooseType=" + chooseType
				+ ", serviceState=" + serviceState + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
