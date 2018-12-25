package com.md.sys.dao.exp;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.common.vo.Node;
import com.md.sys.entity.exp.Expert;

public interface ExpertDao {
	/**
	 * 与远程诊断表并用,通过专家表id查找专家姓名
	 * @param id
	 * @return
	 */
	Expert findId(Integer expertId);
	
	/**
	 * 在专家表添加信息
	 * @param entity
	 * @return
	 */
	int insertExp(Expert entity);
	
	/**
	 * 通过获取专家表id删除对应的专家表数据
	 * @param ids
	 * @return
	 */
	int deleteExp(@Param("ids")Integer... ids);
	
	/**
	 * 通过获取修改信息并在专家表进行修改
	 * @param entity
	 * @return
	 */
	int updateExp(Expert entity);
	
	/**
	 * 基于条件进行分页查询
	 * @param expertName
	 * @param startIndex
	 * @param pageSize
	 * @return
	 */
	List<Expert> limitExp(
			@Param("expertName") String expertName,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 通过专家姓名查询专家表总条数
	 * @param expertName
	 * @return
	 */
	int countExp(@Param("expertName")String expertName);
	
	/**
	 * 对应远程诊断修改页面中的点击选择专家弹出的专家姓名
	 * @return
	 */
	List<Node> selectExpName();
	
	/**
	 * 通过选择的id在修改页面获取专家表对应id中的信息
	 * @param id
	 * @return
	 */
	Expert selectExp(Integer id);
	
	/**
	 * 通过从前端获取的专家表id和专家信息在数据进行修改
	 * @param entity
	 * @return
	 */
	int updateMessage(Expert entity);
}
