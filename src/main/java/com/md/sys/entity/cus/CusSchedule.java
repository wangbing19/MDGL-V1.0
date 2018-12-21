package com.md.sys.entity.cus;

import java.io.Serializable;
/**
 * 课程表记录
 */
import java.util.Date;

public class CusSchedule implements Serializable{

	/**序列化序号*/
	private static final long serialVersionUID = -7131845660017015342L;
	/**id*/
	private int id;
	/**课程名称*/
	private String courseTitle;
	/**课程价格*/
	private int priceOfCourse;
	/**课程训练数*/
	private int courseTraining;
	/**课程数*/
	private int numberOfCourse;
	/**总价格*/
	private int totalPrice;
	/**总训练数*/
	private int sum;
	/**训练项目*/
	private String trainingSession;
	/**服务时间*/
	private String servicingTime;
	/**消费时间*/
	private Date consumptionTime;
	/**建表时间*/
	private Date gmtCreate;
	/**修改时间*/
	private Date gmtModified;
	/**客户id*/
	private int customerId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public int getPriceOfCourse() {
		return priceOfCourse;
	}
	public void setPriceOfCourse(int priceOfCourse) {
		this.priceOfCourse = priceOfCourse;
	}
	public int getCourseTraining() {
		return courseTraining;
	}
	public void setCourseTraining(int courseTraining) {
		this.courseTraining = courseTraining;
	}
	public int getNumberOfCourse() {
		return numberOfCourse;
	}
	public void setNumberOfCourse(int numberOfCourse) {
		this.numberOfCourse = numberOfCourse;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getTrainingSession() {
		return trainingSession;
	}
	public void setTrainingSession(String trainingSession) {
		this.trainingSession = trainingSession;
	}
	public String getServicingTime() {
		return servicingTime;
	}
	public void setServicingTime(String servicingTime) {
		this.servicingTime = servicingTime;
	}
	public Date getConsumptionTime() {
		return consumptionTime;
	}
	public void setConsumptionTime(Date consumptionTime) {
		this.consumptionTime = consumptionTime;
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
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	
	
}
