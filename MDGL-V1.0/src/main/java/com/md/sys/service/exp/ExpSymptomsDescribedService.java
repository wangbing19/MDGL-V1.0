package com.md.sys.service.exp;

import com.md.sys.entity.exp.ExpSymptomsDescribed;

public interface ExpSymptomsDescribedService {
	
	/**
	 * 从浏览器获取添加信息在症状描述表进行添加
	 * @param entity
	 * @return
	 */
	int insertSym(ExpSymptomsDescribed entity);
	
	/**
	 * 从浏览器获取要删除的<远程诊断表id>并在症状描述表进行删除
	 * @param ids
	 * @return
	 */
	int deleteSym(Integer... ids);
	
	/**
	 * 从浏览器获取要修改的信息并在症状描述表进行修改
	 * @param entity
	 * @return
	 */
	int updateSym(ExpSymptomsDescribed entity);
	
	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出个remoteDiagnoseId对应的信息 
	 * @param remoteDiagnoseId
	 * @return
	 */
	ExpSymptomsDescribed selectSym(Integer remoteDiagnoseId);
}
