package com.md.sys.dao.pre;

import org.apache.ibatis.annotations.Param;

import com.md.sys.vo.pre.DiagnosisDescUserDate;

public interface DiagnosisResultUserDao {
	/**根据症状id删除症状和用户的关系数据*/
	int deleteObjectByDiagnosisId(@Param("diagnosisId")Integer diagnosisId);
	/**根据用户的id查询信息及对应的症状描述信息*/
	DiagnosisDescUserDate findDescObjectByUserId(@Param("userId")Integer userId);
	/**根据用户id删除症状信息用户关系表*/
	int deleteDescObjectByUserId(@Param("userId")Integer userId);
	/**修改用户的症状信息（诊断id）*/
	int updateDescObjectByUserId(@Param("diagnosisId")Integer diagnosisId,@Param("userId")Integer userId);
	/**向用户症状关系表插入数据*/
	int insertDescObject(@Param("userId")Integer userId,@Param("diagnosisId")Integer diagnosisId);
	/**根据用户id查询该用户是否有绑定的症状*/
	Integer findIsHaveDescObjectByUserId(@Param("userId")Integer userId);
	/**根据用户id查找表中是否存在用户*/
	Integer findUserIdIsExiste(@Param("userId")Integer userId);
}
