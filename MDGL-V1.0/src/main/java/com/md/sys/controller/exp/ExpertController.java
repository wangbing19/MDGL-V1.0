package com.md.sys.controller.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.ExpRemoteDiagnoseVo;
import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.exp.Expert;
import com.md.sys.service.exp.ExpertService;

@Controller
@RequestMapping("/exp/")
public class ExpertController {
	
	@Autowired
	private ExpertService expertService;
	
	/**
	 * 进入专家列表添加和修改页面
	 * @return
	 */
	@RequestMapping("doExpertIU")
	public String doExpertIU() {
		return "sys/exp_expert_edit";
	}
	
	/**
	 * 进入专家列表页面
	 * @return
	 */
	@RequestMapping("doExpert")
	public String doExpert() {
		return "sys/exp_expert";
	}
	
	/**
	 * 进入专家信息页面
	 * @return
	 */
	@RequestMapping("doExpertMessage")
	public String doExpertMessage() {
		return "sys/exp_expert_message";
	}
	
	/**
	 * 从浏览器获取添加信息(不包含专家信息这一列)并在专家表进行添加
	 * @param entity
	 * @return
	 */
	@RequestMapping("doInsertExp")
	@ResponseBody
	public JsonResult doInsertExp(Expert entity) {
		System.out.println("专家表添加="+entity);
		expertService.insertExp(entity);
		return new JsonResult("insert ok");
	}
	
	/**
	 * 从浏览器获取要删除的id并在专家表进行删除
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteExp")
	@ResponseBody
	public JsonResult doDeleteExp(Integer... ids) {
		expertService.deleteExp(ids);
		return new JsonResult("delete ok");
	}
	
	/**
	 * 从浏览器获取修改信息(不包含专家信息这一列)并在数据库进行修改
	 * @param entity
	 * @return
	 */
	@RequestMapping("doUpdateExp")
	@ResponseBody
	public JsonResult doUpdateExp(Expert entity) {
		expertService.updateExp(entity);
		return new JsonResult("update ok");
	}
	
	/**
	 * 基于条件进行分页查询
	 * @param expertName
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doLimitExp")
	@ResponseBody
	public JsonResult doLimitExp(String expertName,Integer pageCurrent) {
		System.out.println("expertName="+expertName);
		PageObject<Expert> pageObject = expertService.limitExp(expertName, pageCurrent);
		return new JsonResult(pageObject);
	}
	
	/**
	 * 对应远程诊断修改页面中的点击选择专家弹出的专家姓名
	 * @return
	 */
	@RequestMapping("doFindZTreeNodes")
	@ResponseBody
	public JsonResult doFindZTreeNodes(){
		System.out.println("aaa="+expertService.selectExpName());
		return new JsonResult(
		expertService.selectExpName());
	}
	
	/**
	 * 通过选择的id在修改页面获取专家表对应id中的信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doSelectExp")
	@ResponseBody
	public JsonResult doSelectExp(Integer id) {
		Expert entity = expertService.selectExp(id);
		return new JsonResult(entity);
	}
	
	@RequestMapping("doUpdateMessage")
	@ResponseBody
	public JsonResult doUpdateMessage(Expert entity) {
		expertService.updateMessage(entity);
		return new JsonResult("update ok");
	}
}
