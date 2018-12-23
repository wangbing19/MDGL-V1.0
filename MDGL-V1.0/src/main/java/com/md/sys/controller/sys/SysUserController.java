package com.md.sys.controller.sys;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.entity.sys.SysUser;
import com.md.sys.service.sys.SysUserService;
import com.md.sys.service.sys.realm.ShiroUserRealm;

@Controller
@RequestMapping("/user/")
public class SysUserController {
	@Autowired
	private SysUserService sysUserService;

	@Autowired
	private ShiroUserRealm shiroUserRealm;
	// @Autowired
	// private ShiroUserRealm shiroUserRealm;

	@RequiresPermissions("sys:user:view")
	@RequestMapping("doUserListUI")
	public String doUserListUI() {
		return "sys/sys_user_list";
	}

	@RequestMapping("doUserEditUI")
	public String doUserEditUI() {
		return "sys/sys_user_edit";
	}

	@RequestMapping("doLogout")
	public String doLogout() {
		shiroUserRealm.logout();
		counter.decrementAndGet();
		return "redirect:../doLoginUI.do";
	}

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, Integer pageCurrent) {
		return new JsonResult(sysUserService.findPageObjects(username, pageCurrent));
	}

	@RequestMapping("doSearchPageObjects")
	@ResponseBody
	public JsonResult searchPageObjects(String username, Integer pageCurrent) {
		return new JsonResult(sysUserService.searchPageObjects(username, pageCurrent));
	}

	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(Integer id, Integer valid) {
		sysUserService.doValidById(id, valid);
		return new JsonResult("update ok");
	}

	@RequestMapping("doFindZTreeNodes")
	@ResponseBody
	public JsonResult doFindZTreeNodes() {
		return new JsonResult(sysUserService.findZTreeNodes());
	}

	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysUser sysUser) {
		sysUserService.doSaveObject(sysUser);
		return new JsonResult("insert ok");
	}

	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		SysUser doFindObjectById = sysUserService.doFindObjectById(id);
		return new JsonResult(doFindObjectById);
	}

	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysUser sysUser) {
		int doUpdateObject = sysUserService.doUpdateObject(sysUser);
		return new JsonResult("update ok");
	}

	private AtomicInteger counter = new AtomicInteger(0);

	// private int count;
	@RequestMapping("doLogin")
	@ResponseBody
	public JsonResult doLogin(String username, String password) {
		// 1.封装用户信息
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		// 2.提交用户信息
		Subject subject = SecurityUtils.getSubject();
		subject.login(token);// 提交给SecurityManager
		int count = counter.incrementAndGet();// count+1;
		System.out.println("在线人数:" + count);
		return new JsonResult("login ok");
	}

}
