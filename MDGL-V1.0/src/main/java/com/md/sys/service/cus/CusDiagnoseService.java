package com.md.sys.service.cus;
import org.apache.ibatis.annotations.Param;

import com.md.common.vo.PageObject;
import com.md.sys.entity.cus.CusDiagnose;
import com.md.sys.vo.cus.CusDiagnoseResult;

public interface CusDiagnoseService {

	/**
	 * 基于用户id及当前页码值条件查询用户信息
	 * @param userId
	 * @param pageCurrent
	 * @return
	 */
	PageObject<CusDiagnoseResult> findPageObjects(Integer userId,Integer pageCurrent);
	
	/**
	 * 将CusCustomer类型数据添加到数据库
	 * @param cusCustomer
	 * @return
	 */
	int saveObject(CusDiagnose cusDiagnose);
	
	/**
	 * 基于id删除咨询表信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 基于咨询表id更改用户信息
	 * @param cusDiagnose
	 * @return
	 */
	int updateObject(CusDiagnose cusDiagnose);
	
	/**
	 * 基于咨询表id,查询相关id所有信息
	 * @param id
	 * @return
	 */
	CusDiagnose findObjectById(Integer id);
	
	/**
	 * 根据customerId查找客户信息
	 * @param id
	 * @return
	 */
	CusDiagnose findObjectByCustomerId(Integer customerId);
}
