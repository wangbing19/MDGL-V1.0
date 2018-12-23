package com.md.sys.dao.res;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.res.ResProjectConfig;
import com.md.sys.entity.tra.TraInformationrecord;

public interface ResProjectConfigDao {
	/**依据症状名称查询当前页数据*/
	List<ResProjectConfig> findPageObjects(
			@Param("projectName")String projectName,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	/**依据条件查询总记录数*/
	int getRowCount(String projectName);
	
	/**是否生效方法*/
	int projectStateById(@Param("id")Integer id,
						@Param("projectState")Integer projectState);
	
	/**新增数据*/
	int insertObject(ResProjectConfig entity);
	
	/**对选中的数据作删除操作*/
	int deleteObjects(@Param("ids")Integer... ids);
	
	/**对选中的数据进行修改*/
	int updateObject(ResProjectConfig entity);
}
