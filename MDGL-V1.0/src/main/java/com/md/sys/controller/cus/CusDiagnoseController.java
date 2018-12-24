package com.md.sys.controller.cus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.cus.CusDiagnose;
import com.md.sys.service.cus.CusDiagnoseService;
import com.md.sys.vo.cus.CusDiagnoseResult;

@Controller
@RequestMapping("cusDiagnose")
public class CusDiagnoseController {
	
	@Autowired
	private CusDiagnoseService cusDiagnoseService;
	
	/**点击跳转用户页面*/
	@RequestMapping("doCusDiagnoseListUI")
	public String doCusConsultationListUI() {
		return "sys/cusDiagnose_list";
	}
	
	/**诊断表页面加载,查询*/
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(Integer userId, Integer pageCurrent) {
		PageObject<CusDiagnoseResult> pageObject = cusDiagnoseService.findPageObjects(userId, pageCurrent);
		return new JsonResult(pageObject);
	}
	
	/**跳转到修改或新增信息*/
	@RequestMapping("doCusDiagnoseEditUI")
	public String doCusConsultationEditUI() {
		return "sys/cusDiagnose_edit";
	}
	
	/**将CusCustomer类型数据添加到数据库*/
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(CusDiagnose cusDiagnose) {
		cusDiagnoseService.saveObject(cusDiagnose);
		return new JsonResult("Save ok");
	}
	
	
	/**基于id删除咨询表信息*/
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		cusDiagnoseService.deleteObject(id);
		return new JsonResult("Delete ok");
	}
	
	/**基于咨询表id更改用户信息*/
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(CusDiagnose cusDiagnose) {
		cusDiagnoseService.updateObject(cusDiagnose);
		return new JsonResult("Update ok");
	}
	
	/**基于咨询表id,查询相关id所有信息*/
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		CusDiagnose cusDiagnose = cusDiagnoseService.findObjectById(id);
		return new JsonResult(cusDiagnose);
	}
	
	
	/**基于咨询表id,查询相关id所有信息*/
	@RequestMapping("doFindObjectByCustomerId")
	@ResponseBody
	public JsonResult doFindObjectByCustomerId(Integer customerId) {
		
		CusDiagnose cusDiagnose = cusDiagnoseService.findObjectByCustomerId(customerId);
		return new JsonResult(cusDiagnose);
	}
	
	
	
}
