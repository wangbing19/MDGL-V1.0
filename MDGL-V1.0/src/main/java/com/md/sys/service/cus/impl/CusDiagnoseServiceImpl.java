package com.md.sys.service.cus.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.cus.CusCustomerDao;
import com.md.sys.dao.cus.CusDiagnoseDao;
import com.md.sys.entity.cus.CusCustomer;
import com.md.sys.entity.cus.CusDiagnose;
import com.md.sys.service.cus.CusDiagnoseService;
import com.md.sys.vo.cus.CusDiagnoseResult;

/**咨询表业务层实现类*/
@Service
public class CusDiagnoseServiceImpl implements CusDiagnoseService {

	@Autowired
	private CusDiagnoseDao cusDiagnoseDao;
	@Autowired
	private CusCustomerDao cusCustomerDao;

	/**基于用户id、客户名及当前页码值条件查询用户信息*/
	@Override
	public PageObject<CusDiagnoseResult> findPageObjects(Integer userId, Integer pageCurrent) {
		//1.数据合法性验证
		if(pageCurrent==null||pageCurrent<=0)
			throw new ServiceException("页码值不正确");
		//2.依据条件获取总记录数并进行验证
		int rowCount = cusDiagnoseDao.getRowCount(userId);
		//	System.out.println(rowCount);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		//3.基于条件查询当前页记录
		int pageSize=10;
		int startIndex = (pageCurrent-1)*pageSize;
		List<CusDiagnoseResult> records = cusDiagnoseDao.findPageObjects(userId, startIndex, pageSize);
		//4.对查询结果进行封装并返回
		PageObject<CusDiagnoseResult> pageObject = new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);

		/**页数设置，在com.md.common.vo.PageObject<T>中的getPageCount更改返回值
		 *  int pageCount=(rowCount-1)/pageSize+1;
		 *	pageObject.setPageCount(pageCount);
		 */
		return pageObject;
	}

	/**将CusDiagnose类型数据添加到数据库*/
	@Override
	public int saveObject(CusDiagnose cusDiagnose) {
		if(cusDiagnose.getrDs()==0)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		//保存数据
		
		
		int rows = cusDiagnoseDao.insertObject(cusDiagnose);
		CusCustomer cusCustomer = new CusCustomer();
		cusCustomer.setId(cusDiagnose.getCustomerId());
		cusCustomer.setDiagnoseId(cusDiagnose.getId());
		cusCustomerDao.updateDiagnoseId(cusCustomer);
		return rows;
	}

	/** 基于id删除咨询表信息*/
	@Override
	public int deleteObject(Integer id) {
		//验证数据
		if(id==null||id<=0)
			throw new ServiceException("请选择一条数据");
		//执行删除
		int rows = cusDiagnoseDao.deleteObject(id);
		//判断数据有无
		if(rows==0)
			throw new ServiceException("数据可能已删除");
		return rows;	
	}


	/**
	 * 基于咨询表id更改用户信息
	 */
	@Override
	public int updateObject(CusDiagnose cusDiagnose) {
		//验证数据
		if(cusDiagnose==null)
			throw new ServiceException("对象不能为空");
		if(cusDiagnose.getId()==0)
			throw new ServiceException("对象id不能为空");
		//执行
		int rows = cusDiagnoseDao.updateObject(cusDiagnose);
		//if(rows==0)
		//	throw new ServiceException("修改失败");
		return rows;
	}

	  /**
	  * 基于咨询表id,查询相关id所有信息
	  */
	@Override
	public CusDiagnose findObjectById(Integer id) {
		if(id==null||id<=0)
			throw new ServiceException("id错误");
		//执行查找
		CusDiagnose cusDiagnose = cusDiagnoseDao.findObjectById(id);
		return cusDiagnose;
	}

	@Override
	public CusDiagnose findObjectByCustomerId(Integer customerId) {
		System.out.println(customerId);
		if(customerId==null||customerId<=0)
			throw new ServiceException("customerId错误");
		CusDiagnose cusDiagnose = cusDiagnoseDao.findObjectByCustomerId(customerId);
		return cusDiagnose;
	}

	   

}
