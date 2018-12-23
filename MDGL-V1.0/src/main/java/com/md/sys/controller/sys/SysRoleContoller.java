package com.md.sys.controller.sys;

import java.util.Arrays;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.entity.sys.SysRole;
import com.md.sys.service.sys.SysRoleService;
import com.md.sys.vo.sys.SysRoleMenuResult;



@RequestMapping("/role/")
@Controller
public class SysRoleContoller {

	 @Autowired
	 private SysRoleService sysRoleService;
	 
	 @RequiresPermissions("sys:role:view")
	 @RequestMapping("doRoleListUI")
	 public String doRoleListUI(){
		 return "sys/sys_role_list";
	 }
	 
	 @RequestMapping("doRoleEditUI")
	 public String doRoleEditUI(){
		 return "sys/sys_role_edit";
	 }
	 
	 @RequestMapping("doFindRoles")
	 @ResponseBody
	 public JsonResult doFindObjects(){
	  	 return new JsonResult(sysRoleService.findObjects());
	 }
	 @RequestMapping("doFindObjectById")
	 @ResponseBody
	 public JsonResult doFindObjectById(Integer id){
		 SysRoleMenuResult findObjectById = sysRoleService.findObjectById(id);
		 System.out.println(findObjectById);
	     return new JsonResult(findObjectById);
	 }

	 @RequestMapping("doUpdateObject")
	 @ResponseBody
	 public JsonResult doUpdateObject(
			 SysRole entity,Integer[] menuIds){
		 System.out.println("entity="+entity);
		 System.out.println("menuIds="+Arrays.toString(menuIds));
		 sysRoleService.updateObject(entity, menuIds);
		 return new JsonResult("update ok");
	 }
	 
	 @RequestMapping("doSaveObject")
	 @ResponseBody
	 public JsonResult doSaveObject(
			 SysRole entity,Integer[] menuIds){
		 sysRoleService.saveObject(entity, menuIds);
		 return new JsonResult("save ok");
	 }
	 
	 @RequestMapping("doDeleteObject")
	 @ResponseBody
	 public JsonResult doDeleteObject(Integer id){
		 sysRoleService.deleteObject(id);
		 return new JsonResult("delete ok");
	 }
	 
	 
	 
	 @GetMapping("doFindPageObjects")
	 @ResponseBody
	 public JsonResult doFindPageObjects(String name,Integer pageCurrent){
		 System.out.println("name="+name);
		 return new JsonResult(
		sysRoleService.findPageObjects(
				name, pageCurrent));
	 }
	 
	 
	 
}
