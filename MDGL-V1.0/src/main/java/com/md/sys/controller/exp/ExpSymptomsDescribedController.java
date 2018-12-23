package com.md.sys.controller.exp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.entity.exp.ExpSymptomsDescribed;
import com.md.sys.entity.exp.ExpertReply;
import com.md.sys.service.exp.ExpSymptomsDescribedService;

@Controller
@RequestMapping("/sym/")
public class ExpSymptomsDescribedController {

	@Autowired
	private ExpSymptomsDescribedService ExpSymptomsDescribedService;
	
	/**
	 * 从浏览器获取添加信息在症状描述表进行添加
	 * @param entity
	 * @return
	 */
	@RequestMapping("doInsertSym")
	@ResponseBody
	public JsonResult doInsertSym(ExpSymptomsDescribed entity) {
		ExpSymptomsDescribedService.insertSym(entity);
		return new JsonResult("insert ok");
	}
	
	/**
	 * 从浏览器获取要删除的<远程诊断表id>并在症状描述表进行删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("doDeleteSym")
	@ResponseBody
	public JsonResult doDeleteSym(Integer... id) {
		ExpSymptomsDescribedService.deleteSym(id);
		return new JsonResult("delete ok");
	}
	
	/**
	 * 从浏览器获取要修改的信息并在症状描述表进行修改
	 * @param entity
	 * @return
	 */
	@RequestMapping("doUpdateSym")
	@ResponseBody
	public JsonResult doUpdateSym(ExpSymptomsDescribed entity) {
		//System.out.println("entity="+entity);
		ExpSymptomsDescribedService.updateSym(entity);
		return new JsonResult("update ok");
	}
	
	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出remoteDiagnoseId对应的信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doSelectSym")
	@ResponseBody
	public JsonResult doSelectSym(Integer id) {
		System.out.println("id="+id);
		ExpSymptomsDescribed selectSym = 
				ExpSymptomsDescribedService.selectSym(id);
		return new JsonResult(selectSym);
	}
}
