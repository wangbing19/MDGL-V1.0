package com.md.sys.vo.cus;

import java.io.Serializable;
import java.util.Date;

public class CusCustomerResult implements Serializable {

	/**序列化序号*/
	private static final long serialVersionUID = -5832150932166872173L;
	

	/**充值记录数*/
	private int rechargeCount;
	/**课程记录数*/
	private int scheduleCount;
	/**上次训练时间*/
	private Date lastTrain;
	
	/**用户对象*/
//	private CusCustomer cusCustomer;
	/**序号*/
	private int id;
	/**姓名*/
	private String name;
	/**性别*/
	private String gender;
	/**年龄*/
	private int age;
	/**生日*/
	private Date birthday;
	/**联系电话*/
	private String tel;
	/**状态*/
	private int state;
	/**监护人*/
	private String guardian;
	/**次监护人*/
	private String lastGuardian;
	/**次监护人电话*/
	private String lastGuardianTel;
	/**家庭住址*/
	private String home;
	/**学校地址*/
	private String school;
	/**总金额*/
	private double money;
	/**余额*/
	private double balance;
	/**总训练次数*/
	private int totalTrainingTime;
	/**已训练次数*/
	private int timesOfTraining;
	/**备注*/
	private String remark;
	/**咨询表id*/
	private int consultationId;
	/**诊断表id*/
	private int diagnoseId;
	/**门店id*/
	private int deptId;
	/**建表时间*/
	private Date gmtCreate;
	/**修改时间*/
	private Date gmtModified;
	/**创建用户*/
	private String createdUser;
	/**修改用户*/
	private String modifiedUser;
	
	
	public int getRechargeCount() {
		return rechargeCount;
	}
	public void setRechargeCount(int rechargeCount) {
		this.rechargeCount = rechargeCount;
	}
	public int getScheduleCount() {
		return scheduleCount;
	}
	public void setScheduleCount(int scheduleCount) {
		this.scheduleCount = scheduleCount;
	}
	public Date getLastTrain() {
		return lastTrain;
	}
	public void setLastTrain(Date lastTrain) {
		this.lastTrain = lastTrain;
	}
	
	
	
//	public CusCustomer getCusCustomer() {
//		return cusCustomer;
//	}
//	public void setCusCustomer(CusCustomer cusCustomer) {
//		this.cusCustomer = cusCustomer;
//	}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getGuardian() {
		return guardian;
	}
	public void setGuardian(String guardian) {
		this.guardian = guardian;
	}
	public String getLastGuardian() {
		return lastGuardian;
	}
	public void setLastGuardian(String lastGuardian) {
		this.lastGuardian = lastGuardian;
	}
	public String getLastGuardianTel() {
		return lastGuardianTel;
	}
	public void setLastGuardianTel(String lastGuardianTel) {
		this.lastGuardianTel = lastGuardianTel;
	}
	public String getHome() {
		return home;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getTotalTrainingTime() {
		return totalTrainingTime;
	}
	public void setTotalTrainingTime(int totalTrainingTime) {
		this.totalTrainingTime = totalTrainingTime;
	}
	public int getTimesOfTraining() {
		return timesOfTraining;
	}
	public void setTimesOfTraining(int timesOfTraining) {
		this.timesOfTraining = timesOfTraining;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getConsultationId() {
		return consultationId;
	}
	public void setConsultationId(int consultationId) {
		this.consultationId = consultationId;
	}
	public int getDiagnoseId() {
		return diagnoseId;
	}
	public void setDiagnoseId(int diagnoseId) {
		this.diagnoseId = diagnoseId;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
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
	public String getCreatedUser() {
		return createdUser;
	}
	public void setCreatedUser(String createdUser) {
		this.createdUser = createdUser;
	}
	public String getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(String modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

	
	
}
