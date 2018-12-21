package com.md.sys.dao.pre;

import org.apache.ibatis.annotations.Param;

import com.md.sys.vo.pre.DiagnosisDate;
import com.md.sys.entity.pre.DiagnosisDesc;

public interface DiagnosisResultDescDao {
	/**删除关系表：删除症状和症状描述的关系表，根据症状的id来删除*/
	int deleteObjectByDiagnosisId(@Param("diagnosisId")Integer diagnosisId);
	
	/**根据症状id向症状描述表插入数据*/
	int insertObjectByDiagnosisId(@Param("diagnosisId")Integer diagnosisId);
	
	/**根据症状id查询对应的症状描述*/
	DiagnosisDesc findDescByDiagnosisId(@Param("diagnosisId")Integer diagnosisId);
	
	/**修改症状描述关系表的数据*/
	int updateObject(DiagnosisDate diagnosisDate);
}
