package com.md.sys.entity.exp;

import java.io.Serializable;
import java.util.Date;

/**
 * 对应专家表
 * @author tarena
 *
 */
public class Expert implements Serializable{
	
	private static final long serialVersionUID = 3430436839241899930L;
	
	/**专家表序号*/
	private Integer id;
	/**专家姓名*/
	private String expertName;
	/**专家电话*/
	private String expertTel;
	/**专家信息*/
	private String expertMessage;
	/**预约时间*/
	private String appointmentTime;
	//private Integer parentId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getExpertName() {
		return expertName;
	}
	public void setExpertName(String expertName) {
		this.expertName = expertName;
	}
	public String getExpertTel() {
		return expertTel;
	}
	public void setExpertTel(String expertTel) {
		this.expertTel = expertTel;
	}
	public String getExpertMessage() {
		return expertMessage;
	}
	public void setExpertMessage(String expertMessage) {
		this.expertMessage = expertMessage;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	
	/*public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}*/
	@Override
	public String toString() {
		return "Expert [id=" + id + ", expertName=" + expertName + ", expertTel=" + expertTel + ", expertMessage="
				+ expertMessage + ", appointmentTime=" + appointmentTime + "]";
	}
	
}
