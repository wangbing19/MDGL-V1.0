package com.md.sys.service.pre.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.common.annotation.sys.RequiresLog;
import com.md.common.exception.ServiceException;
import com.md.sys.dao.pre.DiagnosisResultUserDao;
import com.md.sys.service.pre.DiagnosisDescUserService;
import com.md.sys.vo.pre.DiagnosisDescUserDate;
@Service
public class DiagnosisDescUserServiceImpl implements DiagnosisDescUserService{

	@Autowired
	private DiagnosisResultUserDao diagnosisResultUserDao;
	@Override								
	public DiagnosisDescUserDate findDescObjectByUserId(Integer userId) {
		if(userId==null) {
			throw new ServiceException("请先选择");
		}
		return diagnosisResultUserDao.findDescObjectByUserId(userId);
	}
	@Override
	@RequiresLog("症状处方-查找症状处方内容")
	public int deleteDescObjectByUserId(Integer userId) {
		if(userId==null) {
			throw new ServiceException("请先选择");
		}
		return diagnosisResultUserDao.deleteDescObjectByUserId(userId);
	}
	@Override
	public int updateDescObjectByUserId(Integer diagnosisId, Integer userId) {
		if(userId==null) {
			throw new ServiceException("请先选择");
		}
		return diagnosisResultUserDao.updateDescObjectByUserId(diagnosisId, userId);
	}
	@Override
	public int insertDescObject(Integer userId, Integer diagnosisId) {
		return diagnosisResultUserDao.insertDescObject(userId, diagnosisId);
	}
	@Override
	public Integer findIsHaveDescObjectByUserId(Integer userId) {
		return diagnosisResultUserDao.findIsHaveDescObjectByUserId(userId);
	}
	@Override
	public Integer findUserIdIsExiste(Integer userId) {
		return diagnosisResultUserDao.findUserIdIsExiste(userId);
	}

}
