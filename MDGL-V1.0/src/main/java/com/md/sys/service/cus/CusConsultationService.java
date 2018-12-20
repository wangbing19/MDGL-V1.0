package com.md.sys.service.cus;

import com.md.common.vo.PageObject;
import com.md.sys.entity.cus.CusConsultation;

public interface CusConsultationService {

	/**
	 * 基于用户/电话及当前页码值条件查询用户信息
	 * @param name
	 * @param pageCurrent
	 * @return
	 */
	PageObject<CusConsultation> findPageObjects(String name,String tel,Integer pageCurrent);
	
	/**
	 * 将CusCustomer类型数据添加到数据库
	 * @param cusCustomer
	 * @return
	 */
	int saveObject(CusConsultation cusConsultation);
	
	/**
	 * 基于id删除咨询表信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
//	
//	/**
//	 * 基于客户id修改客户信息
//	 * @param cusCustomer
//	 * @return
//	 */
//	int updateObject(CusCustomer cusCustomer);
//	
//	/**
//	 * 基于用户id修改用户状态
//	 * @param state
//	 * @return
//	 */
//	int updateStateById(Integer id,Integer state);
//	
//	/**
//	 * 根据id查找客户信息
//	 * @param id
//	 * @return
//	 */
//	CusCustomer findObjectById(Integer id);
}
