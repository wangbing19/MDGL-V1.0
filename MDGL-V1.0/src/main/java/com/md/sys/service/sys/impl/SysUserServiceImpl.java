package com.md.sys.service.sys.impl;

import java.util.List;
import java.util.UUID;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.md.common.annotation.sys.RequiresLog;
import com.md.common.exception.ServiceException;
import com.md.common.utils.ShiroUtils;
import com.md.common.vo.Node;
import com.md.common.vo.PageObject;
import com.md.sys.dao.sys.SysUserDao;
import com.md.sys.dao.sys.SysUserRoleDao;
import com.md.sys.entity.sys.SysUser;
import com.md.sys.service.sys.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@RequiresLog("直接分页查询用户列表")
	@Override
	public PageObject<SysUser> findPageObjects(String username, Integer pageCurrent) {
		// 1.验证参数有效性
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码值不正确");
		// 2.基于条件查询总记录数并进行验证
		int rowCount = sysUserDao.getRowCount(username);
		if (rowCount == 0)
			throw new ServiceException("没有找到对应记录");
		// 3.基于条件查询当前页记录
		int pageSize = 15;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysUser> records = sysUserDao.findPageObjects(username, startIndex, pageSize);

		// 4.对查询结果进行封装并返回
		PageObject<SysUser> pageObject = new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageCount((rowCount - 1) / pageSize + 1);
		return pageObject;
	}

	@Override
	@RequiresLog("用过用户名查询用户列表")
	public PageObject<SysUser> searchPageObjects(String username, Integer pageCurrent) {
		// 1.验证参数有效性
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码值不正确");
		// 2.基于条件查询总记录数并进行验证
		int rowCount = sysUserDao.getRowCount(username);
		if (rowCount == 0)
			throw new ServiceException("没有找到对应记录");
		// 3.基于条件查询当前页记录
		int pageSize = 15;
		int startIndex = (pageCurrent - 1) * pageSize;
		List<SysUser> records = sysUserDao.searchPageObjects(username, startIndex, pageSize);

		// 4.对查询结果进行封装并返回
		PageObject<SysUser> pageObject = new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageCount((rowCount - 1) / pageSize + 1);
		return pageObject;
	}

	@RequiresLog("查询用户列表")
	@Override
	public List<SysUser> findUserByUserName() {
		List<SysUser> users = sysUserDao.findUserByUserName();
		return users;
	}

	@RequiresLog("更改账户状态")
	@Override
	public int doValidById(Integer id, Integer valid) {
		if (id == null || id < 1)
			throw new IllegalArgumentException("id值无效");
		if (valid != 0 && valid != 1)
			throw new IllegalArgumentException("状态值不正确");
		SysUser user = ShiroUtils.getUser();
		String username = user.getUsername();
		int rows = sysUserDao.doValidById(id, valid, username);
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@Override
	public List<Node> findZTreeNodes() {
		List<Node> findZTreeNodes = sysUserDao.findZTreeNodes();

		return findZTreeNodes;
	}

	@RequiresLog("添加用户")
	@Override
	public int doSaveObject(SysUser entity) {
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
		if (StringUtils.isEmpty(entity.getPassword()))
			throw new IllegalArgumentException("密码不能为空");
		if (entity.getRole() == null)
			throw new IllegalArgumentException("必须指定其角色");
		
		String salt = UUID.randomUUID().toString();
		entity.setSalt(salt);
		SimpleHash hash = new SimpleHash("MD5", entity.getPassword(), salt, 1);
		entity.setPassword(hash.toHex());
		// 保存用户自身信息
		SysUser user = ShiroUtils.getUser();
		entity.setCreatedUser(user.getUsername());
		entity.setModifiedUser(user.getUsername());
		// 保存用户自身信息
		int doSaveObject = sysUserDao.doinsertObject(entity);

		return doSaveObject;
	}

	@RequiresLog("通过用户id查询指定用户信息")
	@Override
	public SysUser doFindObjectById(Integer id) {
		if (id == null)
			throw new IllegalArgumentException("参数值无效");
		// 2.查询用户以及对应的部门信息
		SysUser result = sysUserDao.doFindObjectById(id);
		return result;
	}

	@RequiresLog("用户数据更新")
	@Override
	public int doUpdateObject(SysUser entity) {
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getUsername()))
			throw new IllegalArgumentException("用户名不能为空");
		if (entity.getRole() == null)
			throw new IllegalArgumentException("必须指定其角色");
		
		// 保存用户自身信息
		SysUser user = ShiroUtils.getUser();
		entity.setModifiedUser(user.getUsername());
		
		// 保存用户自身信息
		int doSaveObject = sysUserDao.doUpdateObject(entity);

		return doSaveObject;
	}

}
