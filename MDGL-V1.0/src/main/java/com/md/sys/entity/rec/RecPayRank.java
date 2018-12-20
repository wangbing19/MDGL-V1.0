package com.md.sys.entity.rec;

import java.io.Serializable;
import java.util.Date;

public class RecPayRank implements Serializable {

	/**序列化序号*/
	private static final long serialVersionUID = 6712747786150868125L;
	/**序号*/
	private int id;
	/**姓名*/
	private String name;
	/**客户编号*/
	private int customerId;
	/**电话号码*/
	private String phone;
	/**充值类型*/
	private String rechargeType;
	/**总金额*/
	private double money;
	/**充值金额*/
	private double rechargeAmount;
	/**赠送金额*/
	private double presentedAmount;
	/**上次充值时间*/
	private Date lastPayTime;
	/**创建时间*/
	private Date gmtCreate;
	/**修改时间*/
	private Date gmtModified;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRechargeType() {
		return rechargeType;
	}
	public void setRechargeType(String rechargeType) {
		this.rechargeType = rechargeType;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getRechargeAmount() {
		return rechargeAmount;
	}
	public void setRechargeAmount(double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}
	public double getPresentedAmount() {
		return presentedAmount;
	}
	public void setPresentedAmount(double presentedAmount) {
		this.presentedAmount = presentedAmount;
	}
	public Date getLastPayTime() {
		return lastPayTime;
	}
	public void setLastPayTime(Date lastPayTime) {
		this.lastPayTime = lastPayTime;
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
	
	
	
}
