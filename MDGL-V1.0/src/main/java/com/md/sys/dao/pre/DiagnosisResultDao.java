package com.md.sys.dao.pre;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.md.common.vo.Node;
import com.md.sys.vo.pre.DiagnosisDate;
import com.md.sys.entity.pre.Symptom;

public interface DiagnosisResultDao {
	
	/**根据症状id查询症状结果*/
	Symptom findObject(@Param("id")Integer id);
	
	/**查询症状名称和对应父症状名称
	 * @param <T>*/
	List<Map<String,Object>> findObjects();
	
	/**根据症状id查询该症状的子症状个数*/
	int getChildNum(@Param("id")Integer id);
	
	/**根据症状id删除对应的症状*/
	int deleteObjectById(@Param("id")Integer id); 
	
	/**查询ZTree中要显示的节点信息*/
	List<Node> findZtreeMenuNodes();
	
	/**添加信息到症状结果表*/
	int insertObject(Symptom symptom);
	
	
	/**修改症状结果表的数据*/
	int updateObject(DiagnosisDate diagnosisDate);
	
	/**根据症状id修改是否显示症状描述1显示 0不显示*/
	int updateDisTypeByid(@Param("disType")Integer disType,@Param("id")Integer id);
}
