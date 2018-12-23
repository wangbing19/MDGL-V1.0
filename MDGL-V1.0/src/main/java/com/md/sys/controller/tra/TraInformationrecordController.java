package com.md.sys.controller.tra;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.tra.TraInformationrecord;
import com.md.sys.service.tra.TraInformationrecordServic;


@Controller
@RequestMapping("traInformationrecord")
public class TraInformationrecordController {
	@Autowired
	private TraInformationrecordServic traInformationrecordService;
	 
	@RequestMapping("doTraInformationrecordUI")
	public String doTraInformationrecordUI() {
		// 此值交给视图解析器解析
		return "sys/TraInformationrecord_list";// WEB-INF/sys/sys_log.html
	}
	@RequestMapping("doUpdateUI")
	public String doUpdateUI() {
		// 此值交给视图解析器解析
		return "sys/TraInformationrecord_edit";// WEB-INF/sys/sys_log.html
	}
	/**查询所有数据*/
	@RequestMapping("dofindObjects")
	@ResponseBody
	public JsonResult dofindObjects(){
		List<Map<String, Object>> list= traInformationrecordService.findObjects();
	    return new JsonResult(list);
	}
	/**根据用户名做分页查询*/
	@RequestMapping("dofindPageObjects")
	@ResponseBody
	public JsonResult dofindPageObjects(String name,Integer pageCurrent){
	 PageObject<TraInformationrecord> pageObject=
			 traInformationrecordService.findPageObjects(name,pageCurrent);
	return new JsonResult(pageObject);
	}
	/**新增数据*/
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(TraInformationrecord entity){
		
		traInformationrecordService.saveObject(entity);
		return new JsonResult("保存成功");
	}
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id){
		return new JsonResult(traInformationrecordService.findObjectById(id));
	}
	/**修改*/
	@RequestMapping("doUpdate")
	@ResponseBody
	public JsonResult doUpdate(TraInformationrecord entity){
		System.out.println(entity);
		traInformationrecordService.update(entity);
		return new JsonResult("修改成功");
	}
	/**删除*/
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		System.out.println(id);
		traInformationrecordService.deleteObejcts(id);
		return new JsonResult("删除成功");
	}
}
