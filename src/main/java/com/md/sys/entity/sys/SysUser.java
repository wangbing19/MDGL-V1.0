package com.md.sys.entity.sys;

import java.io.Serializable;
import java.util.Date;

public class SysUser implements Serializable {
	private static final long serialVersionUID = 7824657411212352645L;
	private Integer id;
	private String username;
	private String password;
	private Integer role;
	private Integer parent_id;
	private String parent_username;
	private String salt;// 盐值
	private String address;
	private String email;
	private String mobile;
	private Integer valid = 1;
	private Integer customer_limit;
	private Integer customer_num;
	private Integer dept_limit;
	public Integer getCustomer_num() {
		return customer_num;
	}

	public void setCustomer_num(Integer customer_num) {
		this.customer_num = customer_num;
	}

	public Integer getDept_num() {
		return dept_num;
	}

	public void setDept_num(Integer dept_num) {
		this.dept_num = dept_num;
	}

	private Integer dept_num;
	private Date created_time;
	private Date modified_time;
	private String created_user;
	private String modified_user;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getParent_username() {
		return parent_username;
	}

	public void setParent_username(String parent_username) {
		this.parent_username = parent_username;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getCustomer_limit() {
		return customer_limit;
	}

	public void setCustomer_limit(Integer customer_limit) {
		this.customer_limit = customer_limit;
	}

	public Integer getDept_limit() {
		return dept_limit;
	}

	public void setDept_limit(Integer dept_limit) {
		this.dept_limit = dept_limit;
	}

	public Date getCreated_time() {
		return created_time;
	}

	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

	public Date getModified_time() {
		return modified_time;
	}

	public void setModified_time(Date modified_time) {
		this.modified_time = modified_time;
	}

	public String getCreated_user() {
		return created_user;
	}

	public void setCreated_user(String created_user) {
		this.created_user = created_user;
	}

	public String getModified_user() {
		return modified_user;
	}

	public void setModified_user(String modified_user) {
		this.modified_user = modified_user;
	}

	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", parent_id=" + parent_id + ", parent_username=" + parent_username + ", salt=" + salt + ", address="
				+ address + ", email=" + email + ", mobile=" + mobile + ", valid=" + valid + ", customer_limit="
				+ customer_limit + ", customer_num=" + customer_num + ", dept_limit=" + dept_limit + ", dept_num="
				+ dept_num + ", created_time=" + created_time + ", modified_time=" + modified_time + ", created_user="
				+ created_user + ", modified_user=" + modified_user + "]";
	}

	

}
