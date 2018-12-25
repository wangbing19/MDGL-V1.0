package com.md.sys.service.exp;

import java.util.List;

import com.md.common.vo.Node;
import com.md.common.vo.PageObject;
import com.md.sys.entity.exp.Expert;

public interface ExpertService {
	
	/**
	 * 获取从浏览器添加的数据添加到数据库
	 * @param entity
	 * @return
	 */
	int insertExp(Expert entity);
	
	/**
	 * 从浏览器获取id并删除专家表指定id的数据
	 * @param ids
	 * @return
	 */
	int deleteExp(Integer... ids);
	
	/**
	 * 获取修改后的信息并在数据库进行修改
	 * @param entity
	 * @return
	 */
	int updateExp(Expert entity);
	
	/**
	 * 通过获取的专家姓名和当前页数进行分页查询
	 * @param expertName
	 * @param pageCurrent
	 * @return
	 */
	PageObject<Expert> limitExp(String expertName,Integer pageCurrent);
	
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
