package com.md.sys.service.res;

import org.springframework.stereotype.Service;

import com.md.common.vo.PageObject;
import com.md.sys.entity.res.ResProjectConfig;
@Service
public interface ResProjectConfigService {
	/**根据条件查询当前页数据*/
	PageObject<ResProjectConfig> findPageObjects(String projectName,Integer pageCurrent );
	/**根据条件查询总记录数*/
	int getRowCount(String projectName);
	
	/**是否生效方法*/
	int projectStateById(Integer id,Integer projectState);
	/**新增一条数据*/
	int saveObject(ResProjectConfig entity);
	/**对选中的id进行删除操作*/
	int deleteObjects(Integer...ids );
	/**对选中的数据进行删除*/
	int updateObject(ResProjectConfig entity);
}
