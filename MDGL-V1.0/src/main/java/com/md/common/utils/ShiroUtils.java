package com.md.common.utils;

import org.apache.shiro.SecurityUtils;

import com.md.sys.entity.sys.SysUser;



public class ShiroUtils {

	 public static SysUser getUser(){
		 return (SysUser)SecurityUtils
		.getSubject().getPrincipal();
	 }
}
