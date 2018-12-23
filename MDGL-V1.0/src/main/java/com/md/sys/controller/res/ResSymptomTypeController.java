package com.md.sys.controller.res;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.entity.res.ResSymptomType;
import com.md.sys.service.res.ResSymptomTypeService;
@Controller
@RequestMapping("resSymptomType") 
public class ResSymptomTypeController {
	@Autowired
	private ResSymptomTypeService resSymptomTypeService;
	@RequestMapping("dofindPageObject")
	@ResponseBody
	public JsonResult dofindPageObject(Integer id){
		 List<Map<String, Object>> findPageObject = resSymptomTypeService.findPageObject(id);
		return new JsonResult (findPageObject);
	}
	@RequestMapping("dofindObjects")
	@ResponseBody
	public JsonResult dofindObjects(){
		List<Map<String, Object>> findObjects = resSymptomTypeService.findObjects();
		return new JsonResult(findObjects);
	}
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(ResSymptomType entity){
		resSymptomTypeService.saveObject(entity);
		return new JsonResult("Save ok");
	}
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult dodeleteObject(Integer id){
		resSymptomTypeService.deleteObject(id);
		return new JsonResult("delete Ok");
	}
	@RequestMapping("doupdateObject")
	@ResponseBody
	public JsonResult doupdateObject(ResSymptomType entity){
		resSymptomTypeService.updateObject(entity);
		return new JsonResult("update ok");
	}
	@RequestMapping("doResSymptomTypeList")
	public String doResSymptomTypeList() {
		return "sys/res_symptom_type_list";
	}
	@RequestMapping("doResSymptomTypeEdit")
	public String doResSymptomTypeEdit() {
		return "sys/res_symptom_type_edit";
	}
}
