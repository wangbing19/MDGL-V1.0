package com.md.sys.controller.pre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.service.pre.DiagnosisDescUserService;
import com.md.sys.vo.pre.DiagnosisDescUserDate;

@Controller
@RequestMapping("/diagnosisDescuser/")
public class DiagnosisDescUserController {
	@Autowired
	private DiagnosisDescUserService diagnosisDescUserService;
	
	@RequestMapping("doDiagnosisDescUserUI")
	public String doDiagnosisDescUserUI() {
		return "sys/diagnosisDescUser";
	}
	
	@RequestMapping("doFindDescObjectByUserId")
	@ResponseBody
	public JsonResult doFindDescObjectByUserId(Integer userId) {
		DiagnosisDescUserDate descObject = diagnosisDescUserService.findDescObjectByUserId(userId);
		return new JsonResult(descObject);
	}
	
	@RequestMapping("doDeleteDescObjectByUserId")
	@ResponseBody
	public JsonResult doDeleteDescObjectByUserId(Integer userId) {
		diagnosisDescUserService.deleteDescObjectByUserId(userId);
		return new JsonResult("删除成功");
	}
	
	@RequestMapping("doUpdateDescObjectByUserId")
	@ResponseBody
	public JsonResult doUpdateDescObjectByUserId(Integer diagnosisId,Integer userId) {
		diagnosisDescUserService.updateDescObjectByUserId(diagnosisId, userId);
		return new JsonResult("更新成功");
	}
	
	@RequestMapping("doInsertDescObject")
	@ResponseBody
	public JsonResult doInsertDescObject(Integer userId,Integer diagnosisId) {
		diagnosisDescUserService.insertDescObject(userId, diagnosisId);
		return new JsonResult("插入成功");
	}	
	
	@RequestMapping("doFindIsHaveDescObjectByUserId")
	@ResponseBody
	public JsonResult doFindIsHaveDescObjectByUserId(Integer userId) {
		Integer findIsHaveDescObjectByUserId = diagnosisDescUserService.findIsHaveDescObjectByUserId(userId);
		return new JsonResult(findIsHaveDescObjectByUserId);
	}
	@RequestMapping("doFindUserIdIsExiste")
	@ResponseBody
	public JsonResult doFindUserIdIsExiste(Integer userId){
		return new JsonResult(diagnosisDescUserService.findUserIdIsExiste(userId));
	}
}
