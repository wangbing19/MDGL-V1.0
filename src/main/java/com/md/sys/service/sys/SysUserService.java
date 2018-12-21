package com.md.sys.service.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.md.common.vo.Node;
import com.md.common.vo.PageObject;
import com.md.sys.entity.sys.SysUser;
import com.md.sys.vo.sys.SysUserDeptResult;

public interface SysUserService {

	/**
	 * 基于条件分页查询用户信息
	 * 
	 * @param username
	 * @param pageCurrent
	 * @return
	 */
	PageObject<SysUser> findPageObjects(String username, Integer pageCurrent);
	PageObject<SysUser> searchPageObjects(String username, Integer pageCurrent);

	List<SysUser> findUserByUserName();

	int doValidById(Integer id, Integer valid);

	List<Node> findZTreeNodes();

	int doSaveObject(SysUser sysUser);

	SysUser doFindObjectById(Integer id);
	
	int doUpdateObject(SysUser sysUser);
}
