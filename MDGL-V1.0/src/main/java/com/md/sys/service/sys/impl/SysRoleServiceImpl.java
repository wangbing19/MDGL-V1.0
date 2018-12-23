package com.md.sys.service.sys.impl;

import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.md.common.exception.ServiceException;
import com.md.common.utils.ShiroUtils;
import com.md.common.vo.CheckBox;
import com.md.common.vo.PageObject;
import com.md.sys.dao.sys.SysRoleDao;
import com.md.sys.dao.sys.SysRoleMenuDao;
import com.md.sys.dao.sys.SysUserRoleDao;
import com.md.sys.entity.sys.SysRole;
import com.md.sys.entity.sys.SysUser;
import com.md.sys.service.sys.SysRoleService;
import com.md.sys.vo.sys.SysRoleMenuResult;

@Service
public class SysRoleServiceImpl implements SysRoleService {

	@Autowired
	private SysRoleDao sysRoleDao;

	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public List<CheckBox> findObjects() {
		return sysRoleDao.findObjects();
	}

	@Override
	public SysRoleMenuResult findObjectById(Integer id) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("id值无效");
		SysRoleMenuResult result = sysRoleDao.findObjectById(id);
		if (result == null)
			throw new ServiceException("记录可能已经不存在");
		return result;
	}

	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("名字不能为空");
		if (menuIds == null || menuIds.length == 0)
			throw new ServiceException("必须为角色赋予权限");
		SysUser user = ShiroUtils.getUser();
		entity.setModifiedUser(user.getUsername());
		int rows = sysRoleDao.updateObject(entity);
		sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
		sysRoleMenuDao.insertObject(entity.getId(), menuIds);
		return rows;
	}

	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("名字不能为空");
		if (menuIds == null || menuIds.length == 0)
			throw new ServiceException("必须为角色赋予权限");
		SysUser user = ShiroUtils.getUser();
		entity.setCreatedUser(user.getUsername());
		entity.setModifiedUser(user.getUsername());
		int rows = sysRoleDao.insertObject(entity);
		sysRoleMenuDao.insertObject(entity.getId(), menuIds);
		return rows;
	}

	@RequiresPermissions("sys:role:delete")
	@Override
	public int deleteObject(Integer id) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("id值不合法");
		int rows = sysRoleDao.deleteObject(id);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		sysRoleMenuDao.deleteObjectsByRoleId(id);
		return rows;
	}

	@Override
	public PageObject<SysRole> findPageObjects(String username, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码值不正确");
		int rowCount = sysRoleDao.getRowCount(username);
		if (rowCount == 0)
			throw new ServiceException("记录不存在");
		int pageSize = 20;// 页面大小
		int startIndex = (pageCurrent - 1) * pageSize;// 起始位置
		List<SysRole> records = sysRoleDao.findPageObjects(username, startIndex, pageSize);
		PageObject<SysRole> pageObject = new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		int pageCount = (rowCount - 1) / pageSize + 1;
		pageObject.setPageCount(pageCount);
		return pageObject;
	}

}
