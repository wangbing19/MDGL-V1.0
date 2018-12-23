package com.md.sys.entity.res;

import java.io.Serializable;
import java.util.Date;
/**项目配置实体类,封装实体数据*/
public class ResProjectConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4749982679524274712L;
	private Integer id;
	/**症状名称*/
	private String projectName;
	/**症状描述*/
	private String projectChoose;
	/**是否生效*/
	private Integer projectState;
	/**表创建时间*/
	private Date gmtCreate;
	/**表修改时间*/
	private Date gmtModified;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectChoose() {
		return projectChoose;
	}
	public void setProjectChoose(String projectChoose) {
		this.projectChoose = projectChoose;
	}
	public Integer getProjectState() {
		return projectState;
	}
	public void setProjectState(Integer projectState) {
		this.projectState = projectState;
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
		return "ResProjectConfig [id=" + id + ", projectName=" + projectName + ", projectChoose=" + projectChoose
				+ ", projectState=" + projectState + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
}
