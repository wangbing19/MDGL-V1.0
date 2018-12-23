package com.md.sys.entity.exp;

import java.io.Serializable;
import java.util.Date;
/**
 * 对应专家回复表
 */
public class ExpertReply implements Serializable{

	private static final long serialVersionUID = -955326213393976859L;

	/**专家回复表序号*/
	private Integer id;
	/**远程诊断表序号*/
	private Integer remoteDiagnoseId;
	/**专家回复*/
	private String expertReply;
	/**专家备注*/
	private String expertRemark;
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
	public Integer getRemoteDiagnoseId() {
		return remoteDiagnoseId;
	}
	public void setRemoteDiagnoseId(Integer remoteDiagnoseId) {
		this.remoteDiagnoseId = remoteDiagnoseId;
	}
	public String getExpertReply() {
		return expertReply;
	}
	public void setExpertReply(String expertReply) {
		this.expertReply = expertReply;
	}
	public String getExpertRemark() {
		return expertRemark;
	}
	public void setExpertRemark(String expertRemark) {
		this.expertRemark = expertRemark;
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
		return "ExpertReply [id=" + id + ", remoteDiagnoseId=" + remoteDiagnoseId + ", expertReply=" + expertReply
				+ ", expertRemark=" + expertRemark + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
	
}
