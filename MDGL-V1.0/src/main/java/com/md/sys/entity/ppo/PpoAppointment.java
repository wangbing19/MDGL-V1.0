package com.md.sys.entity.ppo;

import java.util.Date;

public class PpoAppointment {
	/**训练师ID*/
	private Integer id;
	/**门店账号姓名*/
	private String user_name;
	/**训练师姓名*/
	private String trainername;
	/**训练师性别*/
	private String gender;
	/**训练师电话*/
	private String tel;
	/**训练师职位*/
	private String post;
	/**训练师描述*/
	private String description;
	/**训练师简历*/
	private String resume;
	/**训练师表信息创建时间*/
	private Date gmt_create;
	/**训练师表信息修改时间*/
	private Date gmt_modified;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrainername() {
		return trainername;
	}
	public void setTrainername(String trainername) {
		this.trainername = trainername;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
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
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "PpoAppointment [id=" + id + ", user_name=" + user_name + ", trainername=" + trainername + ", gender="
				+ gender + ", tel=" + tel + ", post=" + post + ", description=" + description + ", resume=" + resume
				+ ", gmt_create=" + gmt_create + ", gmt_modified=" + gmt_modified + "]";
	}
	
	
	
	
	
	
	
	
	
	
}
