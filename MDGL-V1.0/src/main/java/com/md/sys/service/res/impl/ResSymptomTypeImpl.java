package com.md.sys.service.res.impl;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.md.common.annotation.sys.RequiresLog;
import com.md.common.exception.ServiceException;
import com.md.sys.dao.res.ResSymptomTypeDao;
import com.md.sys.entity.res.ResSymptomType;
import com.md.sys.service.res.ResSymptomTypeService;
@Service
public class ResSymptomTypeImpl implements ResSymptomTypeService{
	@Autowired
	private ResSymptomTypeDao resSymptomTypeDao;
	@Override
	public List<Map<String, Object>> findPageObject(Integer id) {
		List<Map<String, Object>> findPageObjects = resSymptomTypeDao.findPageObject(id);
		return findPageObjects;
	}
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String,Object>> TypeDao = resSymptomTypeDao.findObjects();
		if(TypeDao==null) {
			throw new IllegalArgumentException("当前数据有误");
		}
		return TypeDao;
	}
	@RequiresLog("资源配置-项目配置-数据保存")
	@Override
	public int saveObject(ResSymptomType entity) {
		//1.合法验证
				if(entity==null)
				throw new ServiceException("保存对象不能为空");
				if(StringUtils.isEmpty(entity.getServiceName()))
				throw new ServiceException("菜单名不能为空");
				int rows;
				//2.保存数据
				try{
				rows=resSymptomTypeDao.insertObject(entity);
				}catch(Exception e){
				e.printStackTrace();
				throw new ServiceException("保存失败");
				}
				//3.返回数据
				return rows;
	}
	@RequiresLog("资源配置-项目配置-数据删除")
	@Override
	public int deleteObject(Integer id){
		//验证数据
		if(id==null||id<=0) {
			throw new  IllegalArgumentException("请选择一个");
		}//执行删除操作
		int rows;
		try {
		rows=resSymptomTypeDao.deleteObject(id);
		}catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统故障,正在努力恢复");
		}
		return rows;
	}
	@RequiresLog("资源配置-项目配置-数据修改")
	@Override
	public int updateObject(ResSymptomType entity) {
		//验证数据
		if(entity==null)
			throw new ServiceException("保存数据不能为空");
		if(StringUtils.isEmpty(entity.getServiceName()))
			throw new ServiceException("服务名称不能为空");
		return resSymptomTypeDao.updateObject(entity);
	
	}
}
	
