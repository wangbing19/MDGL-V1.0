package com.md.sys.service.sys;
import java.util.Map;

import com.md.common.vo.PageObject;
import com.md.sys.entity.sys.SysUser;
import com.md.sys.vo.sys.SysUserDeptResult;


public interface SysUserService {
	
	
      /**
       * 基于条件分页查询用户信息
       * @param username
       * @param pageCurrent
       * @return
       */
	  PageObject<SysUserDeptResult> findPageObjects(
			   String username,
			  Integer pageCurrent);
}
