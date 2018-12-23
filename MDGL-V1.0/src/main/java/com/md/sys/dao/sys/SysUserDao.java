package com.md.sys.dao.sys;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.common.vo.Node;
import com.md.sys.entity.sys.SysUser;



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
	 List<SysUser> findPageObjects(
			 @Param("username")String username,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
	 List<SysUser> searchPageObjects(
			 @Param("username")String username,
			 @Param("startIndex")Integer startIndex,
			 @Param("pageSize")Integer pageSize);
	 
	 List<SysUser> findUserByUserName();
	 SysUser findUserByUserName(String username);
	 
	 int doValidById(
			 @Param("id")Integer id,
			 @Param("valid")Integer valid,
			 @Param("modifiedUser")String modifiedUser
			 );
	 List<Node> findZTreeNodes();
	 int doinsertObject(SysUser sysUser);
	 SysUser doFindObjectById(Integer id);
	 int doUpdateObject(SysUser sysUser);
	 
}








