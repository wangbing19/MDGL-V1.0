package com.md.sys.service.pre.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.sys.dao.pre.DiagnosisResultDescDao;
import com.md.sys.entity.pre.DiagnosisDesc;
import com.md.sys.service.pre.DiagnosisDescService;
@Service
public class DiagnosisDescServiceImpl implements DiagnosisDescService{
	@Autowired
	private DiagnosisResultDescDao diagnosisResultDescDao;
	@Override
	public DiagnosisDesc findDescByDiagnosisId(Integer diagnosisId) {
		return diagnosisResultDescDao.findDescByDiagnosisId(diagnosisId);
	}
}
