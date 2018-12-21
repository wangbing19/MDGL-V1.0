package com.md.sys.service.impl.cus;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.cus.CusConsultationDao;
import com.md.sys.entity.cus.CusConsultation;
import com.md.sys.service.cus.CusConsultationService;

/**咨询表业务层实现类*/
@Service
public class CusConsultationServiceImpl implements CusConsultationService {

	@Autowired
	private CusConsultationDao CusConsultationDao;

	/**基于用户/电话及当前页码值条件查询用户信息*/
	@Override
	public PageObject<CusConsultation> findPageObjects(String name, String tel, Integer pageCurrent) {
		//1.数据合法性验证
		if(pageCurrent==null||pageCurrent<=0)
			throw new ServiceException("页码值不正确");
		//2.依据条件获取总记录数并进行验证
		int rowCount = CusConsultationDao.getRowCount(name,tel);
	//	System.out.println(rowCount);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		//3.基于条件查询当前页记录
		int pageSize=10;
		int startIndex = (pageCurrent-1)*pageSize;
		List<CusConsultation> records =
				CusConsultationDao.findPageObjects(name, tel, startIndex, pageSize);
		//4.对查询结果进行封装并返回
		PageObject<CusConsultation> pageObject = 
				new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);

		/*	页数设置，在com.md.common.vo.PageObject<T>中的getPageCount更改返回值
		 *  int pageCount=(rowCount-1)/pageSize+1;
		 *	pageObject.setPageCount(pageCount);
		 */	
		return pageObject;
	}

	/**将CusCustomer类型数据添加到数据库*/
	@Override
	public int saveObject(CusConsultation entity) {
		//验证数据合法性
		if(entity==null)
			throw new ServiceException("对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("用户名不能为空");
		if(StringUtils.isEmpty(entity.getTel()))
			throw new ServiceException("电话不能为空");
		//保存数据
		int rows = CusConsultationDao.insertObject(entity);
		
		//返回结果
		return rows;
	}

	/**
	 * 基于id删除咨询表信息
	 */
	@Override
	public int deleteObject(Integer id) {
		System.out.println("测试"+id);
		//验证数据
		if(id==null||id<=0)
			throw new ServiceException("请选择一条数据");
		//执行删除
		int rows = CusConsultationDao.deleteObject(id);
		//判断数据有无
		if(rows==0)
			throw new ServiceException("数据可能已删除");
		return rows;
	}

	/**
	 * 基于咨询表id更改用户信息
	 */
	@Override
	public int updateObject(CusConsultation entity) {
		//验证数据
		if(entity==null)
			throw new ServiceException("对象不能为空");
		if(entity.getId()==0)
			throw new ServiceException("对象id不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("用户名不能为空");
		if(StringUtils.isEmpty(entity.getTel()))
			throw new ServiceException("电话不能为空");
		//执行
		int rows = CusConsultationDao.updateObject(entity);
		if(rows==0)
			throw new ServiceException("修改失败");
		return rows;
	}

	/**
	 * 基于咨询表id,查询相关id所有信息
	 */
	@Override
	public CusConsultation findObjectById(Integer id) {
		if(id==null||id<=0)
			throw new ServiceException("id错误");
		//执行删除
		CusConsultation cusConsultation = CusConsultationDao.findObjectById(id);
		return cusConsultation;
	}



}
