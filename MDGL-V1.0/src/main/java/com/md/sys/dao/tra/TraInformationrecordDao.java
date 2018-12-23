package com.md.sys.dao.tra;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.tra.TraInformationrecord;



public interface TraInformationrecordDao {
	/**查询表中所有数据*/
	List<Map<String,Object>> findObjects();  
	/**
	 * 基于条件查询总记录数
	 * @param username 查询条件(例如查询哪个用户的日志信息)
	 * @return 总记录数(基于这个结果可以计算总页数)
	 * 说明：假如如下方法没有使用注解修饰，在基于名字进行查询
	 * 时候会出现There is no getter for property named
	 * 'username' in 'class java.lang.String'
	 */
	int getRowCount(@Param("username") String username);

	/**
	 * 基于条件查询当前页要显示的记录
	 * @param username 查询条件
	 * @param startIndex 当前页起始位置
	 * @param pageSize 页面大小（每页要显示的书记记录条数）
	 * @return
	 */
	List<TraInformationrecord> findPageObjects(
			@Param("username") String username,
			@Param("startIndex") Integer startIndex,
			@Param("pageSize") Integer pageSize
			);

	List<TraInformationrecord> findUser();

	/**
	 * 负责将用户信息写入到数据库
	 */
	int insertObject(TraInformationrecord entity);

	int updateObject(TraInformationrecord entity);

	int deleteObjects(@Param("ids")Integer... ids);

	TraInformationrecord findObjectById(Integer id);
}