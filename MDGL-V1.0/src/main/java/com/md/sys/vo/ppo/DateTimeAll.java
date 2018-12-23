package com.md.sys.vo.ppo;

import java.util.Date;

public class DateTimeAll {
	private Date starttime;
	private Date endtime;
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	@Override
	public String toString() {
		return "DateTimeAll [starttime=" + starttime + ", endtime=" + endtime + "]";
	}
	
}
