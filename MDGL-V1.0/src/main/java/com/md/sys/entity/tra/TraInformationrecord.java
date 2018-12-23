package com.md.sys.entity.tra;

import java.io.Serializable;
import java.util.Date;

/**
 * 训练管理表,实体类,封装数据
 * @author 常卜
 *
 */

public class TraInformationrecord implements Serializable {
	
	private static final long serialVersionUID = 8067154337413395205L;
	/** 训练管理表id*/
	private Integer id;
	/** 用户名搜索*/
	private String username;
	/**左眼视力*/
	private Double lVision;
	/**右眼视力*/
	private Double rVision;
	/**训练评分*/
	private Integer grade;
	/**训练评价*/
	private String evaluate;
	/**训练内容*/
	private String content;
	/**导师*/
	private String tutor;
	/**训练结束时间*/
	private Date endTime;
	/**表创建时间*/
	private Date gmtCreate;
	/**表修改时间*/
	private Date gmtModified;
	/**客户id*/
	private int customerId;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String toString() {
		return "TraInformationrecord [id=" + id + ", username=" + username + ", lVision=" + lVision + ", rVision="
				+ rVision + ", grade=" + grade + ", evaluate=" + evaluate + ", content=" + content + ", tutor=" + tutor
				+ ", endTime=" + endTime + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + ", customerId="
				+ customerId + "]";
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getlVision() {
		return lVision;
	}
	public void setlVision(Double lVision) {
		this.lVision = lVision;
	}
	public Double getrVision() {
		return rVision;
	}
	public void setrVision(Double rVision) {
		this.rVision = rVision;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTutor() {
		return tutor;
	}
	public void setTutor(String tutor) {
		this.tutor = tutor;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
