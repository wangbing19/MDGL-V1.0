package com.md.sys.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 借助此DAO对象操作sys_user_roles表(用户角色关系表)
 */
public interface SysUserRoleDao {
	/**
	 * 基于用户id查询用户所属角色
	 * @param id
	 * @return
	 */
	List<Integer> findRoleIdsByUserId(Integer id);
}
