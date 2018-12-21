package com.md.sys.service.pre;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.md.common.vo.Node;
import com.md.sys.vo.pre.DiagnosisDate;
import com.md.sys.entity.pre.Symptom;


public interface DiagnosisResultService {
	Symptom findObject(Integer id);
	<T> List<Map<String, T>> findObjects();
	int getChildNum(Integer id);
	int deleteObjectById(Integer id);
	List<Node> findZtreeMenuNodes();
	int insertObject(Symptom symptom);
	int updateObject(DiagnosisDate diagnosisDate);
	int updateDisTypeByid(@Param("disType")Integer disType,@Param("id")Integer id);
}
