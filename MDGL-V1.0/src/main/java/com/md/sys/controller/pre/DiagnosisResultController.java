package com.md.sys.controller.pre;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.Node;
import com.md.sys.vo.pre.DiagnosisDate;
import com.md.sys.dao.pre.DiagnosisResultDescDao;
import com.md.sys.entity.pre.DiagnosisDesc;
import com.md.sys.entity.pre.Symptom;
import com.md.sys.service.pre.DiagnosisDescService;
import com.md.sys.service.pre.DiagnosisResultService;

@Controller
@RequestMapping("/diagnosis/")
public class DiagnosisResultController {
	
	@Autowired
	private DiagnosisResultService diagnosisResultService;	
	@Autowired
	private DiagnosisDescService diagnosisDescService;
	
	@RequestMapping("doFindObject")
	@ResponseBody
	public JsonResult doFindObject(Integer id) {
		Symptom findObject = diagnosisResultService.findObject(id);
		return new JsonResult(findObject);
	}
	
	/**查询所有症状名称和对应父级症状名称*/
	@RequestMapping("doFindObjects")
	@ResponseBody
	public JsonResult doFindObjects(){
		List<Map<String, Object>> list = diagnosisResultService.findObjects();
		System.out.println(list);
		return new JsonResult(list);
	}
	
	@RequestMapping("doGetChildNum")
	@ResponseBody
	public JsonResult doGetChildNum(Integer id) {
		int childNum = diagnosisResultService.getChildNum(id);
		return new JsonResult(childNum);
	}
	
	@RequestMapping("doDeleteObject")
	@ResponseBody
	public JsonResult doDeleteObject(Integer id) {
		diagnosisResultService.deleteObjectById(id);
		return new JsonResult("删除成功");
	}
	
	@RequestMapping("doDiagnosis")
	public String doDiagnosis() {
		return "sys/diagnosis_list";
	}
	@RequestMapping("doDiagnosisInsertOrUpdate")
	public String doDiagnosisInsertOrUpdate() {
		return "sys/diagnosis_edit";
	}
	
	@RequestMapping("doFindZtreeMenuNodes")
	@ResponseBody
	public JsonResult doFindZtreeMenuNodes(){
		List<Node> findZtreeMenuNodes = diagnosisResultService.findZtreeMenuNodes();
		return new JsonResult(findZtreeMenuNodes);
	}
	
	@RequestMapping("doInsertObject")
	@ResponseBody
	public JsonResult doInsertObject(Symptom symptom) {
		diagnosisResultService.insertObject(symptom);
		return new JsonResult("添加成功");
	}
	
	@RequestMapping("doFindDescObject")
	@ResponseBody
	public JsonResult doFindDescObject(Integer diagnosisId) {
		DiagnosisDesc desc = diagnosisDescService.findDescByDiagnosisId(diagnosisId);
		System.out.println(desc);
		return new JsonResult(desc);
	}
	
	@RequestMapping("doUpdateObject")
	@ResponseBody
	public JsonResult doUpdateObject(DiagnosisDate diagnosisDate) {
		diagnosisResultService.updateObject(diagnosisDate);
		return new JsonResult("修改成功");
	}	
	
	@RequestMapping("doUpdateDisType")
	@ResponseBody
	public JsonResult doUpdateDisType(Integer disType,Integer id) {
		diagnosisResultService.updateDisTypeByid(disType, id);
		return new JsonResult("更新成功");
	}
}
