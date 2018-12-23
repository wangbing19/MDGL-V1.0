package com.md.sys.controller.exp;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.sys.dao.exp.ExpertReplyDao;
import com.md.sys.entity.exp.ExpSymptomsDescribed;
import com.md.sys.entity.exp.ExpertReply;
import com.md.sys.service.exp.ExpertReplyService;

@Controller
@RequestMapping("/rep/")
public class ExpertReplyController {

	@Autowired
	private ExpertReplyService ExpertReplyService;
	@Autowired
	private ExpertReplyDao expertReplyDao;

	/**
	 * 从浏览器获取添加信息在专家回复表进行添加
	 * @param entity
	 * @return
	 */
	@RequestMapping("doInsertRep")
	@ResponseBody
	public JsonResult doInsertRep(ExpertReply entity) {
		ExpertReplyService.insertRep(entity);
		return new JsonResult("insert ok");
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
		return new JsonResult("delete ok");
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
		return new JsonResult("update ok");
	}


	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出remoteDiagnoseId对应的信息
	 * @param id
	 * @return
	 */
	@RequestMapping("doSelectRep")
	@ResponseBody
	public JsonResult doSelectRep(Integer id) {
		System.out.println("id="+id);
		ExpertReply selectRep = 
				ExpertReplyService.selectRep(id);
		return new JsonResult(selectRep);
	}

}
