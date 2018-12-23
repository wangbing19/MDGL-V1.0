package com.md.sys.service.exp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.md.common.exception.ServiceException;
import com.md.sys.dao.exp.ExpSymptomsDescribedDao;
import com.md.sys.entity.exp.ExpSymptomsDescribed;
import com.md.sys.service.exp.ExpSymptomsDescribedService;

@Service
public class ExpSymptomsDescribedServiceImpl implements ExpSymptomsDescribedService {

	@Autowired
	private ExpSymptomsDescribedDao expSymptomsDescribedDao;

	/**
	 * 从浏览器获取添加信息在症状描述表进行添加
	 * @param entity
	 * @return
	 */
	@Override
	public int insertSym(ExpSymptomsDescribed entity) {
		//1.判断属性
		if(entity==null)
			throw new ServiceException("信息不能为空");
		if(StringUtils.isEmpty(entity.getSymptomsDescribed()))
			throw new ServiceException("回复不能为空");
		//2.执行添加
		int count = expSymptomsDescribedDao.insertSym(entity);
		if(count==0)
			throw new ServiceException("添加失败");
		return count;
	}

	/**
	 * 从浏览器获取要删除的<远程诊断表id>并在症状描述表进行删除
	 * @param ids
	 * @return
	 */
	@Override
	public int deleteSym(Integer... ids) {
		//1.判断属性
		if(ids==null||ids.length==0)
			throw new ServiceException("请选择要删除的行");
		//2.执行删除
		int count = expSymptomsDescribedDao.deleteSym(ids);
		if(count==0)
			throw new ServiceException("删除失败,记录可能已经不存在");
		return count;
	}

	/**
	 * 从浏览器获取要修改的信息并在症状描述表进行修改
	 * @param entity
	 * @return
	 */
	@Override
	public int updateSym(ExpSymptomsDescribed entity) {
		//1.判断属性
		if(entity==null)
			throw new ServiceException("信息不能为空");
		if(StringUtils.isEmpty(entity.getSymptomsDescribed()))
			throw new ServiceException("回复不能为空");
		//2.执行添加
		int count = expSymptomsDescribedDao.updateSym(entity);
		
		if(count==0)
			throw new ServiceException("修改失败,记录可能已经不存在");
		return count;
	}

	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出个remoteDiagnoseId对应的信息 
	 */
	@Override
	public ExpSymptomsDescribed selectSym(Integer remoteDiagnoseId) {
		if(remoteDiagnoseId==null||remoteDiagnoseId<=0)
			throw new ServiceException("参数不正确");
		ExpSymptomsDescribed selectSym = expSymptomsDescribedDao.selectSym(remoteDiagnoseId);
		return selectSym;
	}

}
