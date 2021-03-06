package com.md.sys.controller.exp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.entity.exp.ExpertReply;
import com.md.sys.service.exp.ExpertReplyService;

@Controller
@RequestMapping("/rep/")
public class ExpertReplyController {

	@Autowired
	private ExpertReplyService ExpertReplyService;

	/**
	 * 从浏览器获取添加信息在专家回复表进行添加
	 * @param entity
	 * @return
	 */
	@RequestMapping("doInsertRep")
	@ResponseBody
	public JsonResult doInsertRep(ExpertReply entity) {
		ExpertReplyService.insertRep(entity);
		return new JsonResult("添加成功");
	}

	/**
	 * 从浏览器获取要删除的<远程诊断表id>并在专家回复表进行删除
	 * @param id
	 * @return
	 */
	@RequestMapping("doDeleteRep")
	@ResponseBody
	public JsonResult doDeleteRep(Integer... id) {
		ExpertReplyService.deleteRep(id);
		return new JsonResult("删除成功");
	}

	/**
	 * 从浏览器获取要修改的信息并在专家回复表进行修改
	 * @param entity
	 * @return
	 */
	@RequestMapping("doUpdateRep")
	@ResponseBody
	public JsonResult doUpdateRep(ExpertReply entity) {
		ExpertReplyService.updateRep(entity);
		return new JsonResult("修改成功");
	}


	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出remoteDiagnoseId对应的信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doSelectRep")
	@ResponseBody
	public JsonResult doSelectRep(Integer id) {
		//System.out.println("id="+id);
		ExpertReply selectRep = 
				ExpertReplyService.selectRep(id);
		return new JsonResult(selectRep);
	}

}
