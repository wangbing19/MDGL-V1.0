package com.md.sys.dao.res;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.res.ResSymptomType;

public interface ResSymptomTypeDao {
	/**根据id查询一行数据*/
	List<Map<String,Object>> findPageObject(@Param("id")Integer id);
	/**查询所有*/
	List<Map<String,Object>> findObjects();
	/**新增数据*/
	int insertObject(ResSymptomType entity);
	/**根据id删除一行数据*/
	int deleteObject(Integer id);
	/**修改数据*/
	int updateObject(ResSymptomType entity);
	
	
}
