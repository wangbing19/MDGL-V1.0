package com.md.sys.dao.cus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.cus.CusCustomer;
import com.md.sys.vo.cus.CusCustomerResult;


/**
 * 客户表Dao接口
 */
public interface CusCustomerDao {

	/**
	 * 基于用户名查询当前页记录
	 * @param name	查询条件
	 * @param startIndex	起始位置
	 * @param pageSize	页面大小
	 * @return	当前页记录
	 */
	List<CusCustomerResult> findPageObjects(
			@Param("name")String name,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**
	 * 基于用户名查询记录总数
	 * @param name
	 * @return
	 */
	int getRowCount(@Param("name")String name);
	
	/**
	 * 将CusCustomer类型数据添加到数据库
	 * @param cusCustomer
	 * @return
	 */
	int insertObject(CusCustomer cusCustomer);
	
	/**
	 * 基于id删除客户信息
	 * @param id
	 * @return
	 */
	int deleteObject(Integer id);
	
	/**
	 * 基于客户id修改客户信息
	 * @param cusCustomer
	 * @return
	 */
	int updateObject(CusCustomer cusCustomer);
	
	/**
	 * 基于用户id修改用户状态
	 * @param state
	 * @return
	 */
	int updateStateById(
			@Param("id")Integer id ,
			@Param("state")Integer state,
			@Param("modifiedUser")String modifiedUser);
	/**
	 * 根据id查找客户信息
	 * @param id
	 * @return
	 */
	CusCustomer findObjectById(@Param("id")Integer id);
	
	/**
	 * 根据consultationId查询有无consultationId
	 * @param consultationId
	 * @return
	 */
	Integer findConsultationIdByConsultationId(@Param("consultationId")Integer consultationId);
	
	/**修改诊断表id*/
	int updateDiagnoseId(CusCustomer cusCustomer);
}
