package com.md.sys.entity.pre;

import java.util.Date;

public class DiagnosisDesc {
	/**症状描述关系表主键id*/
	private Integer id;
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
		return "DiagnosisDesc [id=" + id + ", diagnosisId=" + diagnosisId + ", diagnosisDesc=" + diagnosisDesc
				+ ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
	
}
