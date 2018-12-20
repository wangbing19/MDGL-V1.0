package com.md.sys.service.sys.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.md.common.exception.ServiceException;
import com.md.common.utils.ShiroUtils;
import com.md.common.vo.PageObject;
import com.md.sys.dao.sys.SysUserDao;
import com.md.sys.dao.sys.SysUserRoleDao;
import com.md.sys.entity.sys.SysUser;
import com.md.sys.service.sys.SysUserService;
import com.md.sys.vo.sys.SysUserDeptResult;


@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;
	
	
	
	
	@Override
	public PageObject<SysUserDeptResult> 
	             findPageObjects(
	              String username,Integer pageCurrent) {
		//1.验证参数有效性
		if(pageCurrent==null||pageCurrent<1)
		throw new IllegalArgumentException("页码值不正确");
		//2.基于条件查询总记录数并进行验证
		int rowCount=sysUserDao.getRowCount(username);
		if(rowCount==0)
		throw new ServiceException("没有找到对应记录");
		//3.基于条件查询当前页记录
		int pageSize=20;
		int startIndex=(pageCurrent-1)*pageSize;
		List<SysUserDeptResult> records=
		sysUserDao.findPageObjects(username,
				startIndex, pageSize);
		
		//4.对查询结果进行封装并返回
		PageObject<SysUserDeptResult> pageObject=
		new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageCount((rowCount-1)/pageSize+1);
		return pageObject;
	}

}



