package com.md.sys.controller.sys;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.annotation.sys.RequiresLog;
import com.md.common.vo.JsonResult;
import com.md.sys.entity.sys.SysDept;
import com.md.sys.service.sys.SysDeptService;

@Controller
@RequestMapping("/dept/")
public class SysDeptController {
	@Autowired SysDeptService sysDeptService;
	/**
	 * 
	 * @return 组织管理--加载页面
	 */
	@RequiresPermissions("sys:dept:add")
	@RequiresLog("增加部门")
	@RequestMapping("doDeptListUI")
	public String doDeptListUI() {
		return "sys/sys_dept_list";
	}
	
	/**
	 * 页面初始化数据
	 * @return
	 */
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects() {
		return new JsonResult(sysDeptService.findObjects());
	}
	/**
	 * 加载编辑页面
	 * @return
	 */
	@RequiresPermissions("sys:dept:edit")
	@RequestMapping("doDeptEditUI")
	public String doDeptEditUI() {
		return "sys/sys_dept_edit";
	}
	/**
	 * 查询组织结构数据
	 * @return
	 */
	@RequestMapping("doFindZTreeNodes")
	@ResponseBody
	public JsonResult doFindZTreeNodes() {
		return new JsonResult(sysDeptService.findZTreeNodes());
	}
	/**
	 * 新增保存
	 * @param entity
	 * @return
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(SysDept entity){
		sysDeptService.saveObject(entity);
		return new JsonResult("save ok");
	}
	
	/**
	 * 更新
	 */
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(SysDept entity){
		System.out.println(entity.toString());
		sysDeptService.updateObject(entity);
		return new JsonResult("save ok");
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysDeptService.deleteObject(id);
		return new JsonResult("delete ok");
	}

}
