package com.md.sys.service.cus.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.cus.CusConsultationDao;
import com.md.sys.dao.cus.CusCustomerDao;
import com.md.sys.entity.cus.CusConsultation;
import com.md.sys.entity.cus.CusCustomer;
import com.md.sys.service.cus.CusCustomerService;
import com.md.sys.vo.cus.CusCustomerResult;
/**客户表业务层实现类*/
@Service
public class CusCustomerServiceImpl implements CusCustomerService {

	@Autowired
	private CusCustomerDao cusCustomerDao;
	@Autowired
	private CusConsultationDao cusConsultationDao;
	

	/**
	 * 分页查询返回结果
	 */
	@Override
	public PageObject<CusCustomerResult> findPageObjects(String name, Integer pageCurrent) {
		//1.数据合法性验证
		if(pageCurrent==null||pageCurrent<=0)
			throw new ServiceException("页码值不正确");
		//2.依据条件获取总记录数并进行验证
		int rowCount = cusCustomerDao.getRowCount(name);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		//3.基于条件查询当前页记录
		int pageSize=10;
		int startIndex = (pageCurrent-1)*pageSize;
		List<CusCustomerResult> records =
				cusCustomerDao.findPageObjects(
						name, startIndex, pageSize);
		//4.对查询结果进行封装并返回
		PageObject<CusCustomerResult> pageObject = 
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

	/**
	 * 将CusCustomer类型数据添加到数据库
	 */
	@Override
	public int saveObject(CusCustomer entity) {
		//验证数据合法性
		if(entity==null)
			throw new ServiceException("对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("用户名不能为空");
		if(StringUtils.isEmpty(entity.getTel()))
			throw new ServiceException("电话不能为空");
		if(StringUtils.isEmpty(entity.getGuardian()))
			throw new ServiceException("监护人不能为空");
		//保存数据
		/**设置状态*/
		entity.setState(1);
		//建立咨询表对象并赋值
		CusConsultation consultation = new CusConsultation();
		consultation.setId(entity.getConsultationId());
		consultation.setName(entity.getName());
		consultation.setAge(entity.getAge());
		consultation.setGender(entity.getGender());
		consultation.setTel(entity.getTel());
		/**修改咨询表部分信息*/
		cusConsultationDao.updateObjectByCustomerId(consultation);
		int rows = cusCustomerDao.insertObject(entity);
		//返回结果
		return rows;
	}

	/**
	 * 基于id删除客户信息
	 */
	@Override
	public int deleteObject(Integer id) {
		//1.验证参数有效性
		if(id==null||id<1)
			throw new ServiceException("参数id无效");
		//2.删除当前菜单信息
		int rows = cusCustomerDao.deleteObject(id);
		if(rows==0)
			throw new ServiceException("此菜单可能已经不存在");
		//4.删除菜单角色的关系数据
		//关联其他表项未做删除
		return rows;
	}

	/**
	 * 基于客户id修改客户信息
	 */
	@Override
	public int updateObject(CusCustomer entity) {
		//验证数据合法性
		if(entity==null)
			throw new ServiceException("对象不能为空");
		if(entity.getId()<=0)
			throw new ServiceException("id错误");
		if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("客户名不能为空");
		if(StringUtils.isEmpty(entity.getTel()))
			throw new ServiceException("电话不能为空");
		if(StringUtils.isEmpty(entity.getGuardian()))
			throw new ServiceException("监护人不能为空");
		//保存数据
		int rows = cusCustomerDao.updateObject(entity);
		//返回结果
		return rows;
	}

	/**
	 * 基于用户id修改用户状态
	 * @param state
	 * @return
	 */
	@Override
	public int updateStateById(Integer id, Integer state) {
		if(id<=0||id==null)
			throw new ServiceException("id错误");
		if(state!=0 && state!=1)
			throw new ServiceException("状态错误");
		/**获取登陆用户,还未写*/
		String modifiedUser = null;
		int rows = cusCustomerDao.updateStateById(id, state, modifiedUser);
		return rows;
	}

	@Override
	public CusCustomer findObjectById(Integer id) {
		if(id<=0||id==null)
			throw new ServiceException("id错误");
		CusCustomer cusCustomer = cusCustomerDao.findObjectById(id);
		return cusCustomer;
	}

}
