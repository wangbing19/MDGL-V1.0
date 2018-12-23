package com.md.sys.dao.exp;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.md.sys.entity.exp.ExpertReply;

public interface ExpertReplyDao {
	
	/**
	 * 从浏览器获取添加信息在专家回复表进行添加
	 * @param entity
	 * @return
	 */
	int insertRep(ExpertReply entity);
	
	/**
	 * 从浏览器获取要删除的<远程诊断表id>并在专家回复表进行删除
	 * @param ids
	 * @return
	 */
	int deleteRep(@Param("ids")Integer... ids);
	
	/**
	 * 从浏览器获取要修改的信息并在专家回复表进行修改
	 * @param entity
	 * @return
	 */
	int updateRep(ExpertReply entity);
	
	/**
	 * 通过远程诊断表的id查询到专家回复表的id,在远程诊断实现类中的删除使用
	 * @param id远程诊断表的id
	 * @return
	 */
	List<Integer> selectExpId(@Param("ids")Integer... ids);
	
	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出remoteDiagnoseId对应的信息
	 * @param remoteDiagnoseId
	 * @return
	 */
	ExpertReply selectRep(@Param("remoteDiagnoseId")Integer remoteDiagnoseId);
	
}
