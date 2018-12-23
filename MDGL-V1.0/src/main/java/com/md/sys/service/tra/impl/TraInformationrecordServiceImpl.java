package com.md.sys.service.tra.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.tra.TraInformationrecordDao;
import com.md.sys.entity.tra.TraInformationrecord;
import com.md.sys.service.tra.TraInformationrecordServic;
@Service
public class TraInformationrecordServiceImpl implements TraInformationrecordServic {

	@Autowired
	private TraInformationrecordDao traInformationrecordDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String,Object>> list = traInformationrecordDao.findObjects();
		if(list==null) {
			throw new IllegalArgumentException("当前数据有误");
		}
		return list;
	}

	@Override
	public PageObject<TraInformationrecord> findPageObjects(String name, Integer pageCurrent) {
		//验证参数合法性
		//验证pageCurrent的合法性
		//不合法抛出IllegalArgumentException异常
		if(pageCurrent==null||pageCurrent<1) {
			System.out.println(pageCurrent);
			throw new IllegalArgumentException("当前页码值不正确");}
		//基于条件查询总记录数
		int rowCount=traInformationrecordDao.getRowCount(name);
		System.out.println("name"+name);
		//验证查询结果!结果为0停止执行
		if(rowCount==0)
			throw new ServiceException("没有记录");
		//基于条件查询当前页记录
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<TraInformationrecord> records=
				traInformationrecordDao.findPageObjects(name, startIndex, pageSize);
		//对分页信息以及当前页记录作封装
		PageObject<TraInformationrecord> pageObject=new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		int pageCount=(rowCount-1)/pageSize+1;
		pageObject.setPageCount(pageCount);
		//pageObject.setPageCount(rowCount-1)/pageSize+1;
		pageObject.setRowCount(rowCount);
				
		return pageObject;
	}

	@Override
	public int saveObject(TraInformationrecord entity) {
		//验证数据合法性
		System.out.println(entity);
		if(entity==null)
		throw new ServiceException("保存数据不能为空");
		System.out.println(entity.toString());
		if(StringUtils.isEmpty(entity.getUsername()))
		throw new ServiceException("用户名不能为空");
		
		//将数据写入数据库
		int rows=traInformationrecordDao.insertObject(entity);
		
		return rows;	
	}
	
	@Override
	public int update(TraInformationrecord entity) {
		//System.out.println(entity);
		if(entity==null)
			throw new ServiceException("用户信息不能为空");
		if(StringUtils.isEmpty(entity.getUsername()))
			throw new ServiceException("用户名不能为空");
		int rows=0;
		rows=traInformationrecordDao.updateObject(entity);
		
		return rows;
	}

	@Override
	public int deleteObejcts(Integer... ids) {
		//1.判定参数合法性
		if(ids==null||ids.length==0)
			throw new IllegalArgumentException("请选择一个");
		//2.执行删除操作
		int rows;
		try {
		rows=traInformationrecordDao.deleteObjects(ids);
		}catch(Throwable e) {
			e.printStackTrace();
			throw new ServiceException("系统故障,正在努力恢复中...");
		}
		//4.对结果进行验证
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@Override
	public TraInformationrecord findObjectById(Integer id) {
		if(id==null||id<=0)
			throw new ServiceException("id的值不合法");
		TraInformationrecord result=traInformationrecordDao.findObjectById(id);
		if(result==null)
			throw new ServiceException("此记录可能已经不存在");
		return result;
	}

	
	


}
