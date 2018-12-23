package com.md.sys.entity.res;
/**提示语实体类,封装实体数据*/

import java.util.Date;

public class ResPromotionalLanguage {
	
	private Integer id;
	/**消息类型*/
	private String content;
	/**是否生效*/
	private Integer state;
	/**表创建时间*/
	private Date gmtCreate;
	/**表修改时间*/
	private Date gmtModified;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
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
	@Override
	public String toString() {
		return "ResPromotionalLanguage [id=" + id + ", content=" + content + ", state=" + state + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + "]";
	}
}
