package com.md.sys.service.exp.impl;

import javax.sql.rowset.serial.SerialException;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.md.common.annotation.sys.RequiresLog;
import com.md.common.exception.ServiceException;
import com.md.sys.dao.exp.ExpertReplyDao;
import com.md.sys.entity.exp.ExpSymptomsDescribed;
import com.md.sys.entity.exp.ExpertReply;
import com.md.sys.service.exp.ExpertReplyService;

@Service
public class ExpertReplyServiceImpl implements ExpertReplyService{

	@Autowired
	private ExpertReplyDao expertReplyDao;
	
	/**
	 * 从浏览器获取添加信息在专家回复表进行添加
	 * @param entity
	 * @return
	 */
	@RequiresPermissions("rep:yc:insert")
	@RequiresLog("远程诊断添加专家回复")
	@Override
	public int insertRep(ExpertReply entity) {
		//1.判断属性
		if(entity==null)
			throw new ServiceException("信息不能为空");
		if(StringUtils.isEmpty(entity.getExpertReply()))
			throw new ServiceException("回复不能为空");
		//2.执行添加
		int count = expertReplyDao.insertRep(entity);
		if(count==0)
			throw new ServiceException("添加失败");
		return count;
	}

	/**
	 * 从浏览器获取要删除的<远程诊断表id>并在专家回复表进行删除
	 * @param ids
	 * @return
	 */
	@Override
	public int deleteRep(Integer... ids) {
		//1.判断属性
		if(ids==null||ids.length==0)
			throw new ServiceException("请选择要删除的行");
		//2.执行删除
		int count = expertReplyDao.deleteRep(ids);
		if(count==0)
			throw new ServiceException("删除失败,记录可能已经不存在");
		return count;
	}

	/**
	 * 从浏览器获取要修改的信息并在专家回复表进行修改
	 * @param entity
	 * @return
	 */
	@RequiresPermissions("rep:yc:update")
	@RequiresLog("远程诊断添加专家回复修改")
	@Override
	public int updateRep(ExpertReply entity) {
		//1.判断属性
		if(entity==null)
			throw new ServiceException("信息不能为空");
		if(StringUtils.isEmpty(entity.getExpertReply()))
			throw new ServiceException("回复不能为空");
		//2.执行添加
		int count = expertReplyDao.updateRep(entity);
		if(count==0)
			throw new ServiceException("修改失败,记录可能已经不存在");
		return count;
	}

	/**
	 * 通过前端获取远程诊断表remoteDiagnoseId并查询出个remoteDiagnoseId对应的信息 
	 */
	@Override
	public ExpertReply selectRep(Integer remoteDiagnoseId) {
		if(remoteDiagnoseId==null||remoteDiagnoseId<=0)
			throw new ServiceException("参数不正确");
		ExpertReply selectRep = expertReplyDao.selectRep(remoteDiagnoseId);
		return selectRep;
	}
}
