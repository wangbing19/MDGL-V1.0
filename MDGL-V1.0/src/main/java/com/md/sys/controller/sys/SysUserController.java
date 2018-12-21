package com.md.sys.controller.sys;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.entity.sys.SysUser;
import com.md.sys.service.sys.SysUserService;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;
//	 @Autowired
//	 private ShiroUserRealm shiroUserRealm;

	@RequestMapping("doUserListUI")
	public String doUserListUI() {
		return "sys/sys_user_list";
	}

	@RequestMapping("doUserEditUI")
	public String doUserEditUI() {
		return "sys/sys_user_edit";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		System.out.println("find.service=" + sysUserService.getClass().getName());
		return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
	}
	
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id,Integer valid) {
		sysUserService.doValidById(id, valid);
		return new JsonResult("update ok");
	}
	@RequestMapping("doFindZTreeNodes")
	@ResponseBody
	public JsonResult doFindZTreeNodes() {
		return new JsonResult(sysUserService.findZTreeNodes());
	}
}
