package com.md.sys.controller.exp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.PageObject;
import com.md.common.vo.ExpRemoteDiagnoseVo;
import com.md.common.vo.JsonResult;
import com.md.sys.entity.exp.ExpRemoteDiagnose;
import com.md.sys.service.exp.ExpDiagnoseService;


@Controller
@RequestMapping("/dia/")
public class ExpDiagnoseController {
	@Autowired
	private ExpDiagnoseService expDiagnoseService;

	/**
	 * 进入远程诊断的显示页面
	 * @return
	 */
	@RequestMapping("doRemoteDiagnose")
	public String doRemoteDiagnose() {
		return "sys/exp_remote_diagnose";
	}


	/**
	 * 远程诊断管理的添加和修改页面
	 * @return
	 */
	
	@RequestMapping("doUserEditUI")
	public String doUserEditUI(){
		return "sys/exp_remote_diagnose_edit";
	}
	
	/**
	 * 点击症状描述按钮进入症状描述页面
	 * @return
	 */
	@RequestMapping("doSymptoms")
	public String dosymptoms() {
		return "sys/exp_symptoms_described";
	}
	
	/**
	 * 点击专家回复按钮进入专家回复页面
	 * @return
	 */
	@RequestMapping("doExpertReply")
	public String doExpertReply() {
		return "sys/exp_expert_reply";
	}

	/**对应前端用户管理模块中的添加作用
	 *将从前端获取的用户信息和角色信息添加到数据库
	 */
	@RequestMapping("doSaveObject")
	@ResponseBody
	public JsonResult doSaveObject(
			ExpRemoteDiagnose entity){
		//System.out.println("ExpRemoteDiagnose="+entity);
		expDiagnoseService.saveObject(entity);
		return new JsonResult("添加成功");
	}

	/**
	 * 对应前端页面远程诊断模块呈现页面,
	 * 从前端获取当前页码值并的开始下标返回指定长度的信息,
	 * 获取输入框中customerName的名字,没有则查询全部
	 * 并在数据库进行分页查询返回查询的信息
	 * @param customerName
	 * @param pageCurrent
	 * @return
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(
			String customerName,Integer pageCurrent){
		//System.out.println("username="+customerName);
		//System.out.println("pageCurrent="+pageCurrent);
		PageObject<ExpRemoteDiagnoseVo> pageObject=
				expDiagnoseService.findPageObjects(customerName,
						pageCurrent);
		return new JsonResult(pageObject);
	}

	/**
	 * 删除:从前端获取id,通过id从数据库删除对应的数据
	 * @param id
	 * @return
	 */
	@RequestMapping("doDelete")
	@ResponseBody
	public JsonResult doDelete(Integer... ids) {
		//System.out.println("id234="+ids);
		expDiagnoseService.delete(ids);
		return new JsonResult("删除成功");
	}

	/**
	 * 获取修改后的数据传入数据库
	 * @param entity
	 * @return
	 */
	@RequestMapping("doUpdate")
	@ResponseBody
	public JsonResult doUpdate(ExpRemoteDiagnose entity) {
		expDiagnoseService.update(entity);
		return new JsonResult("修改成功");
	}
	
	/**
	 * 通过选择的id在修改页面获取远程诊断表对应id中的信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doSelect")
	@ResponseBody
	public JsonResult doSelect(Integer id) {
		ExpRemoteDiagnoseVo entity = expDiagnoseService.select(id);
		return new JsonResult(entity);
	}
	
	/**
	 * 显示是否解决的点击事件切换
	 * @param id
	 * @param valid
	 * @return
	 */
	@RequestMapping("doValidById")
	@ResponseBody
	public JsonResult doValidById(
			Integer id,
			Integer valid){
		expDiagnoseService.validById(id,valid);
		return new JsonResult("切换成功");
	}
}
