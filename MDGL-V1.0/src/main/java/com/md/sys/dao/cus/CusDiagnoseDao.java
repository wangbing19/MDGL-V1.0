package com.md.sys.dao.cus;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.cus.CusDiagnose;
import com.md.sys.vo.cus.CusDiagnoseResult;

/**
 * 诊断表Dao接口
 */
public interface CusDiagnoseDao {

	/**
	 * 基于用户id、客户名查询当前页记录
	 * @param userId	查询条件
	 * @param startIndex	起始位置
	 * @param pageSize	页面大小
	 * @return	当前页记录
	 */
	List<CusDiagnoseResult> findPageObjects(
			@Param("userId")Integer userId,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 基于用户id/客户名查询记录总数
	 * @param userId
	 * @return
	 */
	int getRowCount(@Param("userId")Integer userId);
	
	/**
	 * 将CusDiagnose类型数据添加到数据库
	 * @param cusDiagnose
	 * @return
	 */
	int insertObject(CusDiagnose cusDiagnose);
	
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
	int updateObject(CusDiagnose cusDiagnose);
	
	/**
	 * 根据id查找客户信息
	 * @param id
	 * @return
	 */
	CusDiagnose findObjectById(@Param("id")Integer id);
	
}
