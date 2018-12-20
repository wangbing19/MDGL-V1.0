package com.md.sys.controller.cus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.cus.CusCustomer;
import com.md.sys.service.cus.CusCustomerService;
import com.md.sys.vo.cus.CusCustomerResult;

@Controller
@RequestMapping("customer")
public class CusCustomerController {

	@Autowired
	private CusCustomerService cusCustomerService;
	
	/**点击跳转用户页面*/
	@RequestMapping("doCustomerListUI")
	public String doCustomerListUI() {
		return "sys/customer_list";
	}
	
	/**用户页面查看所有信息*/
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String name, Integer pageCurrent) {
		
		PageObject<CusCustomerResult> pageObjects = cusCustomerService.findPageObjects(name, pageCurrent);
		return new JsonResult(pageObjects);
	}
	
	/**跳转到查看用户具体信息*/
	@RequestMapping("doCustomerAll")
	public String doCustomerAll() {
		return "sys/customer_all";
	}
	
	/**跳转到新增或修改信息*/
	@RequestMapping("doCustomerEditUI")
	public String doCustomerEditUI() {
		return "sys/customer_edit";
	}
	
	/**将CusCustomer类型数据添加到数据库*/
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(CusCustomer entity) {
		cusCustomerService.saveObject(entity);
		return new JsonResult("Save Ok");
	}
	
	/**基于id删除客户信息*/
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		cusCustomerService.deleteObject(id);
		return new JsonResult("Delete Ok");
	}
	
	/**基于客户id修改客户信息*/
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(CusCustomer cusCustomer) {
		cusCustomerService.updateObject(cusCustomer);
		return new JsonResult("Update Ok");
	}
	
	/**基于用户id修改用户状态*/
	@RequestMapping("doUpdateStateById")
	@ResponseBody
	public JsonResult doUpdateStateById(Integer id, Integer state) {
		cusCustomerService.updateStateById(id, state);
		return new JsonResult("Update Ok");
	}
	
	@RequestMapping("doFindObjectById")
	@ResponseBody
	public JsonResult doFindObjectById(Integer id) {
		CusCustomer cusCustomer = cusCustomerService.findObjectById(id);
		return new JsonResult(cusCustomer);
	}
	
}
