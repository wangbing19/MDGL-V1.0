package com.md.sys.service.pre.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.common.exception.ServiceException;
import com.md.common.vo.Node;
import com.md.sys.vo.pre.DiagnosisDate;
import com.md.sys.dao.pre.DiagnosisResultDao;
import com.md.sys.dao.pre.DiagnosisResultDescDao;
import com.md.sys.dao.pre.DiagnosisResultUserDao;
import com.md.sys.entity.pre.Symptom;
import com.md.sys.service.pre.DiagnosisResultService;
@Service
public class DiagnosisResultServiceImpl implements DiagnosisResultService {
	@Autowired 
	private DiagnosisResultDao diagnosisResultDao;
	@Autowired
	private DiagnosisResultDescDao diagnosisResultDescDao;
	@Autowired
	private DiagnosisResultUserDao diagnosisResultUserDao;
	@Override
	public List<Map<String,Object>> findObjects() {
		List<Map<String, Object>> list = diagnosisResultDao.findObjects();
		for(Map m:list) {
			Integer id =(Integer) m.get("id");
			int childNum = getChildNum(id);
			//System.out.println(id+"子菜单个数："+childNum);
			if(childNum==0) {
				updateDisTypeByid(1,id);
			}else {
				updateDisTypeByid(0,id);
			}
		}
		if(list==null||list.size()==0) 
		throw new ServiceException("没有对应的记录");
		list = diagnosisResultDao.findObjects();
		return list;
	}
	@Override
	public int getChildNum(Integer id) {
		return diagnosisResultDao.getChildNum(id);
	}
	@Override
	public int deleteObjectById(Integer id) {
		if(id==null) {
			throw new ServiceException("请先选择症状");
		}
		int rows = diagnosisResultDao.getChildNum(id);
		if(rows!=0) {
			throw new ServiceException("请先删除子症状");
		}
		int row = diagnosisResultDao.deleteObjectById(id);
		if(row==0) {
			throw new ServiceException("该记录可能不存在了");
		}
		diagnosisResultDescDao.deleteObjectByDiagnosisId(id); //删除症状与症状描述的关系数据
		diagnosisResultUserDao.deleteObjectByDiagnosisId(id); //删除症状与用户的关系数据
		return rows;
	}
	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> Ztree = diagnosisResultDao.findZtreeMenuNodes();
		if(Ztree==null||Ztree.size()==0) {
			throw new ServiceException("记录不存在");			
		}
		return Ztree;
	}
	@Override
	public int insertObject(Symptom symptom) {
		if(symptom==null) {
			throw new ServiceException("插入的数据有误");
		}
		int row = diagnosisResultDao.insertObject(symptom);
		
		diagnosisResultDescDao.insertObjectByDiagnosisId(symptom.getId());
		return row;
	}
	@Override
	public int updateObject(DiagnosisDate diagnosisDate) {
		if(diagnosisDate==null) {
			throw new ServiceException("请先选择");
		}
		int row = diagnosisResultDao.updateObject(diagnosisDate);
		diagnosisResultDescDao.updateObject(diagnosisDate);
		return row;
	}
	@Override
	public int updateDisTypeByid(Integer disType, Integer id) {		
		return diagnosisResultDao.updateDisTypeByid(disType, id);
	}
	@Override
	public Symptom findObject(Integer id) {
		return diagnosisResultDao.findObject(id);
	}
}
