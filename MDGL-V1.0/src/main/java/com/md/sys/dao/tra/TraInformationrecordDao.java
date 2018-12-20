package com.md.sys.dao.tra;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.tra.TraInformationrecord;



public interface TraInformationrecordDao {
/**查询表中所有数据*/
List<Map<String,Object>> findObjects();  
/**
 * 基于条件（username）查询系统中的总记录数，
 * 我们会在业务层基于总记录数进行总页数的计算操作
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
}	
