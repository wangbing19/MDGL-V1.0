package com.md.sys.dao.cus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.cus.CusConsultation;

/**
 * 咨询表Dao接口
 */
public interface CusConsultationDao {
	
	/**
	 * 基于用户名/电话查询当前页记录
	 * @param name	查询条件
	 * @param tel	查询条件
	 * @param startIndex	起始位置
	 * @param pageSize	页面大小
	 * @return	当前页记录
	 */
	List<CusConsultation> findPageObjects(
			@Param("name")String name,
			@Param("tel")String tel,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 基于用户名查询记录总数
	 * @param name
	 * @return
	 */
	int getRowCount(
			@Param("name")String name,
			@Param("tel")String tel);
	
	/**
	 * 新增数据到CusConsultation咨询表
	 * @param cusConsultation
	 * @return
	 */
	int insertObject(CusConsultation cusConsultation);
	
	/**
	 * 基于咨询表id删除咨询表信息
	 * @param id
	 * @return
	 */
	int deleteObject(@Param("id")Integer id);
	
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
