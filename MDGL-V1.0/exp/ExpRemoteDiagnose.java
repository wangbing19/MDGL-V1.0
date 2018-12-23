package com.md.sys.entity.exp;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应远程诊断门店表
 * @author tarena
 *
 */
public class ExpRemoteDiagnose implements Serializable{
	private static final long serialVersionUID = -7080193952671180198L;
	/**远程门店诊断表序号*/
	private Integer id;
	
	/**门店地址*/
	private String deptSite;
	/**门店名称*/
	private String deptName;
	/**客户姓名*/
	private String customerName;
	/**客户电话*/
	private String customerTel;
	/**专家表序号*/
	private Integer expertId;
	/**专家回复状态0表示未回复,1表示已回复*/
	private int valid ;
	/**第几次远程诊断*/
	private Integer timeNumber;
	/**发送人姓名*/
	private String sendName;
	/**发送人电话*/
	private String sendTel;
	/**创建时间*/
	private Date gmtCreate;
	/**修改时间*/
	private Date gmtModified;
	/**登录用户账号*/
	private String registerUser;
	/**门店账号对应的父级账号id*/
	private Integer registerParentid;
	/**修改时用户的账号*/
	private String modifiedUser;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptSite() {
		return deptSite;
	}
	public void setDeptSite(String deptSite) {
		this.deptSite = deptSite;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerTel() {
		return customerTel;
	}
	public void setCustomerTel(String customerTel) {
		this.customerTel = customerTel;
	}
	public Integer getExpertId() {
		return expertId;
	}
	public void setExpertId(Integer expertId) {
		this.expertId = expertId;
	}
	public int getValid() {
		return valid;
	}
	public void setValid(int valid) {
		this.valid = valid;
	}
	public Integer getTimeNumber() {
		return timeNumber;
	}
	public void setTimeNumber(Integer timeNumber) {
		this.timeNumber = timeNumber;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public String getSendTel() {
		return sendTel;
	}
	public void setSendTel(String sendTel) {
		this.sendTel = sendTel;
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
	public String getRegisterUser() {
		return registerUser;
	}
	public void setRegisterUser(String registerUser) {
		this.registerUser = registerUser;
	}
	public Integer getRegisterParentid() {
		return registerParentid;
	}
	public void setRegisterParentid(Integer registerParentid) {
		this.registerParentid = registerParentid;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	@Override
	public String toString() {
		return "ExpRemoteDiagnose [id=" + id + ", deptSite=" + deptSite + ", deptName=" + deptName + ", customerName="
				+ customerName + ", customerTel=" + customerTel + ", expertId=" + expertId + ", valid=" + valid
				+ ", timeNumber=" + timeNumber + ", sendName=" + sendName + ", sendTel=" + sendTel + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + ", registerUser=" + registerUser + ", registerParentid="
				+ registerParentid + ", modifiedUser=" + modifiedUser + "]";
	}
	
}
