package com.md.sys.vo.cus;

import java.io.Serializable;
import java.util.Date;

public class CusDiagnoseResult implements Serializable {

	/**序列化序号*/
	private static final long serialVersionUID = -4468586127579349701L;
	
	/**序号*/
	private int id;
	/**客户姓名*/
	private String customerName;
	/**客户电话*/
	private String customerTel;
	/**右眼球面镜（近视）*/
	private double rDs;
	/**右眼柱面镜（散光）*/
	private double rDc;
	/**左眼球面镜（近视）*/
	private double lDs;
	/**左眼柱面镜（散光）*/
	private double lDc;
	/**诊断师*/
	private String diagnostics;
	/**修改时间*/
	private Date gmtModified;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public double getrDs() {
		return rDs;
	}
	public void setrDs(double rDs) {
		this.rDs = rDs;
	}
	public double getrDc() {
		return rDc;
	}
	public void setrDc(double rDc) {
		this.rDc = rDc;
	}
	public double getlDs() {
		return lDs;
	}
	public void setlDs(double lDs) {
		this.lDs = lDs;
	}
	public double getlDc() {
		return lDc;
	}
	public void setlDc(double lDc) {
		this.lDc = lDc;
	}
	public String getDiagnostics() {
		return diagnostics;
	}
	public void setDiagnostics(String diagnostics) {
		this.diagnostics = diagnostics;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	
	
	
}
