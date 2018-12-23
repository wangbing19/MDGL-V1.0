package com.md.sys.service.exp;

import com.md.sys.entity.exp.ExpertReply;

public interface ExpertReplyService {
	
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
	int deleteRep(Integer... ids);
	
	/**
	 * 从浏览器获取要修改的信息并在专家回复表进行修改
	 * @param entity
	 * @return
	 */
	int updateRep(ExpertReply entity);
	
	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出个remoteDiagnoseId对应的信息 
	 * @param remoteDiagnoseId
	 * @return
	 */
	ExpertReply selectRep(Integer remoteDiagnoseId);
}
