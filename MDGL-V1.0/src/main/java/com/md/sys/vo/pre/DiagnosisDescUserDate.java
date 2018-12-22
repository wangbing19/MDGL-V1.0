package com.md.sys.vo.pre;

import java.io.Serializable;
import java.util.Date;

public class DiagnosisDescUserDate implements Serializable{
	private static final long serialVersionUID = 1L;
	/**用户症状描述关系表主键id*/
	private Integer id;
	/**用户id*/
	private Integer userId;
	/**症状id*/
	private Integer diagnosisId;
	/**症状描述*/
	private String diagnosisDesc;
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getDiagnosisId() {
		return diagnosisId;
	}
	public void setDiagnosisId(Integer diagnosisId) {
		this.diagnosisId = diagnosisId;
	}
	public String getDiagnosisDesc() {
		return diagnosisDesc;
	}
	public void setDiagnosisDesc(String diagnosisDesc) {
		this.diagnosisDesc = diagnosisDesc;
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
		return "DianosisDescUserDate [id=" + id + ", userId=" + userId + ", diagnosisId=" + diagnosisId
				+ ", diagnosisDesc=" + diagnosisDesc + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified
				+ "]";
	}
	
	
}
