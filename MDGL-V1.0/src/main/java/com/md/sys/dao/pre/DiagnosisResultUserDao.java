package com.md.sys.dao.pre;

import org.apache.ibatis.annotations.Param;

public interface DiagnosisResultUserDao {
	/**根据症状id删除症状和用户的关系数据*/
	int deleteObjectByDiagnosisId(@Param("diagnosisId")Integer diagnosisId);
}
