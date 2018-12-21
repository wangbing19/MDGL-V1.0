package com.md.sys.service.cus;

import org.apache.ibatis.annotations.Param;

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
	
	/**
	 * 基于咨询表id更改用户信息
	 * @param cusConsultation
	 * @return
	 */
	int updateObject(CusConsultation cusConsultation);
	
	/**
	 * 基于咨询表id,查询相关id所有信息
	 * @param id
	 * @return
	 */
	CusConsultation findObjectById(@Param("id")Integer id);
}
