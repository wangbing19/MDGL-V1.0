package com.md.sys.entity.exp;

import java.io.Serializable;

public class Diagnose implements Serializable{
	private static final long serialVersionUID = 1363119858621767811L;
	private Integer id;
	private String diagnose_name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDiagnose_name() {
		return diagnose_name;
	}
	public void setDiagnose_name(String diagnose_name) {
		this.diagnose_name = diagnose_name;
	}
	
}
