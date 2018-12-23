package com.md.sys.service.res.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.res.ResProjectConfigDao;
import com.md.sys.entity.res.ResProjectConfig;
import com.md.sys.service.res.ResProjectConfigService;
@Service
public class ResProjectConfigImpl implements ResProjectConfigService {
	@Autowired
	private ResProjectConfigDao resProjectConfigDao;
	@Override
	public PageObject findPageObjects(String projectName, Integer pageCurrent) {
		//1.数据合法性验证
		if(pageCurrent==null||pageCurrent<=0)
			throw new ServiceException("参数不合法");
		//2.依据条件获取总记录数
		int rowCount=resProjectConfigDao.getRowCount(projectName);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		//3.计算startIndex的值
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		//4.依据条件获取当前页数据
		List<ResProjectConfig> records=
				resProjectConfigDao.findPageObjects(
						projectName, startIndex, pageSize);
		System.out.println(records);
		//5.封装数据
		PageObject<ResProjectConfig> pageObject=new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		return pageObject;
	}
	@Override
	public int getRowCount(String projectName) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int projectStateById(Integer id, Integer projectState) {
		if(id==null||id<=0)
			throw new ServiceException("参数不合法,id="+id);
		if(projectState!=1&&projectState!=0)
			throw new ServiceException("参数不合法,projectState="+projectState);
		//执行是否有效操作
		int rows;
		try {
			rows=resProjectConfigDao.projectStateById(id, projectState);
			System.out.println("rows:"+rows);
		}catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("底层正在维护");
		}
		//3.判定结果,并返回
		if(rows==0)
			throw new ServiceException("此记录可能已经不存在");
		return rows;
	}
	@Override
	public int saveObject(ResProjectConfig entity) {
		//验证数据合法性
		if(entity==null)
			throw new ServiceException("不能保存空值");
		if(StringUtils.isEmpty(entity.getProjectName()))
			throw new ServiceException("症状名称不能为空");
		//2将数据写入数据库
		int rows=resProjectConfigDao.insertObject(entity);
		return rows;
	}
	@Override
	public int deleteObjects(Integer... ids) {

		//1.判定参数合法性
		if(ids==null||ids.length==0) {
			System.out.println(ids);
		throw new IllegalArgumentException("请选择一个");
		//2.执行删除操作
		}
		int row = 0;
		try {
			row =resProjectConfigDao.deleteObjects(ids);
		}catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统故障,正在努力恢复中");
		}
		if(row==0){
			throw new ServiceException("记录可能已经不存在");
		}
		return row;
	}
	@Override
	public int updateObject(ResProjectConfig entity) {
		if(entity==null)
			throw new ServiceException("用户信息不能为空");
		if(StringUtils.isEmpty(entity.getProjectName()))
			throw new ServiceException("症状名称不能为空");
		int rows=0;
		rows=resProjectConfigDao.updateObject(entity);
		
		return rows;
	
	}




}
