package com.md.sys.dao.exp;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.exp.ExpSymptomsDescribed;

public interface ExpSymptomsDescribedDao {
	/**
	 * 从浏览器获取添加信息在症状描述表进行添加
	 * @param entity
	 * @return
	 */
	int insertSym(ExpSymptomsDescribed entity);
	
	/**
	 * 从浏览器获取要删除的<远程诊断表id>并在症状描述表进行删除
	 * @param ids
	 * @return
	 */
	int deleteSym(@Param("ids")Integer... ids);
	
	/**
	 * 从浏览器获取要修改的信息并在症状描述表进行修改
	 * @param entity
	 * @return
	 */
	int updateSym(ExpSymptomsDescribed entity);
	
	/**
	 * 通过远程诊断表的id查询到症状描述表的id(与远程诊断删除数据关联)
	 * 意义:在远程诊断删除一条数据后将这条数据对应的症状描述数据一起删除
	 * @param id 远程诊断表的id
	 * @return
	 */
	List<Integer> selectSymId(@Param("ids")Integer... ids);
	
	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出remoteDiagnoseId对应的信息
	 * @param remoteDiagnoseId
	 * @return
	 */
	ExpSymptomsDescribed selectSym(@Param("remoteDiagnoseId")Integer remoteDiagnoseId);
}
