package com.md.sys.entity.ppo;

import java.util.Date;

public class PpoAppointmentTime {
	/**预约时间ID*/
	private Integer id;
	/**设置预约开始时间*/
	private Date startTime;
	/**设置预约结束时间*/
	private Date endTime;
	/**预约表信息创建时间*/
	private Date gmt_create;
	/**预约表信息修改时间*/
	private Date gmt_modified;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getGmt_create() {
		return gmt_create;
	}
	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}
	public Date getGmt_modified() {
		return gmt_modified;
	}
	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	
}
