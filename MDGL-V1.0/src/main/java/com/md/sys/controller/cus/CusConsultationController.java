package com.md.sys.controller.cus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.cus.CusConsultation;
import com.md.sys.service.cus.CusConsultationService;

@Controller
@RequestMapping("cusConsultation")
public class CusConsultationController {
	
	@Autowired
	private CusConsultationService cusConsultationService;
	
	/**点击跳转用户页面*/
	@RequestMapping("doCusConsultationListUI")
	public String doCusConsultationListUI() {
		return "sys/cusConsultation_list";
	}
	
	/**咨询表页面加载,查询*/
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult dofindPageObjects(String name, String tel, Integer pageCurrent) {
		PageObject<CusConsultation> pageObjects = cusConsultationService.findPageObjects(name, tel, pageCurrent);
		return new JsonResult(pageObjects);
	}
	
	/**跳转到修改或新增信息*/
	@RequestMapping("doCusConsultationEditUI")
	public String doCusConsultationEditUI() {
		return "sys/cusConsultation_edit";
	}
	
	/**将CusCustomer类型数据添加到数据库*/
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(CusConsultation cusConsultation) {
		cusConsultationService.saveObject(cusConsultation);
		return new JsonResult("Save ok");
	}
	
	/**将CusCustomer类型数据添加到数据库*/
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		cusConsultationService.deleteObject(id);
		return new JsonResult("Delete ok");
	}
	
	
	
}
