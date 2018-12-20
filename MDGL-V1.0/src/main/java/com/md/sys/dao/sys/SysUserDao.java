package com.md.sys.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.sys.SysUser;
import com.md.sys.vo.sys.SysUserDeptResult;



public interface SysUserDao {


	 /**
	  * 基于用户名查询记录总数
	  * @param username
	  * @return
	  */
	 int getRowCount(@Param("username")String username);
	 /**
	  * 基于用户名查询当前页记录
	  * @param username 查询条件
	  * @param startIndex 起始页位置
	  * @param pageSize 页面大小
	  * @return 当前页记录
	  */
	 List<SysUserDeptResult> findPageObjects(
			 @Param("username")String username,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
}








