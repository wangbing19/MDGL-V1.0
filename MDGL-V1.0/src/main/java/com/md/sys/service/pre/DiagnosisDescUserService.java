package com.md.sys.service.pre;



import com.md.sys.vo.pre.DiagnosisDescUserDate;

public interface DiagnosisDescUserService {
	DiagnosisDescUserDate findDescObjectByUserId(Integer userId);
	int deleteDescObjectByUserId(Integer userId);
	int updateDescObjectByUserId(Integer diagnosisId,Integer userId);
	int insertDescObject(Integer userId,Integer diagnosisId);
	Integer findIsHaveDescObjectByUserId(Integer userId);
	Integer findUserIdIsExiste(Integer userId);
}
