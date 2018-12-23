package com.md.sys.controller.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.res.ResProjectConfig;
import com.md.sys.service.res.ResProjectConfigService;
@Controller
@RequestMapping("ResProjectConfig") 
public class ResProjectConfigController {
	@Autowired
	private ResProjectConfigService resProjectConfigService;
	
	@RequestMapping("doResProjectConfigUI")
	public String doResProjectConfigUI() {
		// 此值交给视图解析器解析
		return "sys/ResProjectConfig_List";// WEB-INF/sys/sys_log.html
	}
	@RequestMapping("doPagingUI")
	public String doPagingUI() {
		// 此值交给视图解析器解析
		return "sys/ResProjectConfig_edit";// WEB-INF/sys/sys_log.html
	}
	
	@RequestMapping("doFingPageObject")
	@ResponseBody
	public JsonResult doFingPageObject(String projectName,Integer pageCurrent){
		PageObject<ResProjectConfig> pageObject=
				resProjectConfigService.findPageObjects(projectName, pageCurrent);
		
		return new JsonResult(pageObject);
	}
	@RequestMapping("doprojectStateById")
	@ResponseBody
	public JsonResult doprojectStateById(Integer id,Integer projectState) {
		
		resProjectConfigService.projectStateById(id, projectState);
		return new JsonResult("修改成功");
	}
	@RequestMapping("dosaveObject")
	@ResponseBody
	public JsonResult dosaveObject(ResProjectConfig entity){
		System.out.println("entity:"+entity);
		resProjectConfigService.saveObject(entity);
		return new JsonResult("保存成功");
	}
	@RequestMapping("dodeleteObjects")
	@ResponseBody
	public JsonResult dodeleteObjects(Integer...ids){
		resProjectConfigService.deleteObjects(ids);
		return new JsonResult("删除成功");
	}
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(ResProjectConfig entity){
		System.out.println("entity:"+entity);
		resProjectConfigService.updateObject(entity);
		return new JsonResult("修改成功");
	}
	
}
