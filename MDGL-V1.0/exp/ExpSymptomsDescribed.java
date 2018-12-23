package com.md.sys.entity.exp;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应症状描述表
 * @author tarena
 *
 */
public class ExpSymptomsDescribed implements Serializable{
	
	private static final long serialVersionUID = -4053828837640381361L;
	/**症状描述表序号*/
	private Integer id;
	/**远程诊断表序号*/
	private Integer remoteDiagnoseId;
	/**症状描述*/
	private String symptomsDescribed;
	/**症状备注*/
	private String symptomsRemark;
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
	public String getSymptomsDescribed() {
		return symptomsDescribed;
	}
	public void setSymptomsDescribed(String symptomsDescribed) {
		this.symptomsDescribed = symptomsDescribed;
	}
	public String getSymptomsRemark() {
		return symptomsRemark;
	}
	public void setSymptomsRemark(String symptomsRemark) {
		this.symptomsRemark = symptomsRemark;
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
		return "ExpSymptomsDescribed [id=" + id + ", remoteDiagnoseId=" + remoteDiagnoseId + ", symptomsDescribed="
				+ symptomsDescribed + ", symptomsRemark=" + symptomsRemark + ", gmtCreate=" + gmtCreate
				+ ", gmtModified=" + gmtModified + "]";
	}
	
}
