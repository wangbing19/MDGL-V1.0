package com.md.sys.controller.sys;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.entity.sys.SysMenu;
import com.md.sys.service.sys.SysMenuService;



@Controller
@RequestMapping("/menu/")
public class SysMenuController {
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequiresPermissions("sys:menu:view")
	@RequestMapping("doMenuListUI")
	public String doMenuListUI(){
	 return "sys/sys_menu_list";
	}
	
	@RequiresPermissions("sys:menu:add")
    @RequestMapping("doMenuEditUI")
	public String doMenuEditUI(){
	  return "sys/sys_menu_edit";
	}

    @RequestMapping("doUpdateObject")
    @ResponseBody
    public JsonResult doUpdateObject(SysMenu entity){
    	sysMenuService.updateObject(entity);
    	return new JsonResult("update ok");
    }
    
    @RequestMapping("doSaveObject")
    @ResponseBody
    public JsonResult doSaveObject(SysMenu entity){
    	sysMenuService.saveObject(entity);
    	return new JsonResult("save ok");
    }
    
	@RequestMapping("doFindZtreeMenuNodes")
	@ResponseBody
	public JsonResult doFindZtreeMenuNodes(){
		 return new JsonResult(
		 sysMenuService.findZtreeMenuNodes());
	}

	@RequiresPermissions("sys:menu:delete")
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id){
		sysMenuService.deleteObject(id);
		return new JsonResult("delete ok");
	}

	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		List<Map<String,Object>> list=
				sysMenuService.findObjects();
		return new JsonResult(list);
	}
}








