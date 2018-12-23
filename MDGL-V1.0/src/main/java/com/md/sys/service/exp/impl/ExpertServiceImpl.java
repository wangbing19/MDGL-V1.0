package com.md.sys.service.exp.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.druid.util.StringUtils;
import com.md.common.exception.ServiceException;
import com.md.common.vo.ExpRemoteDiagnoseVo;
import com.md.common.vo.Node;
import com.md.common.vo.PageObject;
import com.md.sys.dao.exp.ExpertDao;
import com.md.sys.entity.exp.Expert;
import com.md.sys.service.exp.ExpertService;

@Service
public class ExpertServiceImpl implements ExpertService {

	@Autowired
	private ExpertDao expertDao;
	
	/**
	 * 为专家表添加数据
	 */
	@Override
	public int insertExp(Expert entity) {
		if(entity==null)
			throw new ServiceException("数据不能为空");
		if(StringUtils.isEmpty(entity.getExpertName()))
			throw new ServiceException("专家姓名不能为空");
		if(StringUtils.isEmpty(entity.getExpertTel()))
			throw new ServiceException("专家电话不能为空");
		if(StringUtils.isEmpty(entity.getAppointmentTime()))
			throw new ServiceException("专家预约时间不能为空");
		//执行添加
		int count = expertDao.insertExp(entity);
		if(count==0)
			throw new ServiceException("添加失败");
		return count;
	}

	/**
	 * 删除专家表指定id的数据
	 */
	@Override
	public int deleteExp(Integer... ids) {
		if(ids==null||ids.length==0)
			throw new ServiceException("请选择数据");
		int count = expertDao.deleteExp(ids);
		if(count==0)
			throw new ServiceException("要删除的数据已不存在");
		return count;
	}

	/**
	 * 修改专家表数据
	 */
	@Override
	public int updateExp(Expert entity) {
		if(entity==null)
			throw new ServiceException("数据不能为空");
		if(StringUtils.isEmpty(entity.getExpertName()))
			throw new ServiceException("专家姓名不能为空");
		if(StringUtils.isEmpty(entity.getExpertTel()))
			throw new ServiceException("专家电话不能为空");
		if(StringUtils.isEmpty(entity.getAppointmentTime()))
			throw new ServiceException("专家预约时间不能为空");
		//执行修改
		int count = expertDao.updateExp(entity);
		if(count==0)
			throw new ServiceException("要修改的数据已经不存在");
		return count;
	}

	/**
	 * 通过获取的专家姓名和当前页数进行分页查询
	 */
	@Override
	public PageObject<Expert> limitExp(String expertName, Integer pageCurrent) {
		//1.判断当前页码值
		if(pageCurrent<1||pageCurrent==null)
			throw new ServiceException("请输入正确的页码值");
		//2.查询总记录数
		int rowCount = expertDao.countExp(expertName);
		//System.out.println("rowCount="+rowCount);
		if(rowCount==0)
			throw new ServiceException("您要查询的记录不存在");
		
		int pageSize=2;
		int startIndex=(pageCurrent-1)*pageSize;

		//3.依据条件获取当前页数据
		List<Expert> records=
				expertDao.limitExp(expertName, startIndex, pageSize);
		//System.out.println("records="+records);

		//4.封装数据
		PageObject<Expert> pageObject=new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);//当前页码值
		pageObject.setRowCount(rowCount);//总记录数
		pageObject.setPageSize(pageSize);//每一页显示条数
		pageObject.setRecords(records);//当前页显示数据
		return pageObject;
	}

	/**
	 * 对应远程诊断修改页面中的点击选择专家弹出的专家姓名
	 * @return
	 */
	//@Transactional(readOnly=true)//默认为false
	@Override
	public List<Node> selectExpName() {
		return expertDao.selectExpName();
	}

	/**
	 * 通过选择的id在修改页面获取远程诊断表对应id中的信息
	 */
	@Override
	public Expert selectExp(Integer id) {
		if (id <= 0 || id == null)
			throw new ServiceException("请输入正确的参数");
		Expert entity = expertDao.selectExp(id);
		return entity;
	}

	/**
	 * 通过从前端获取的专家表id和专家信息在数据进行修改
	 */
	@Override
	public int updateMessage(Expert entity) {
		if(entity==null)
			throw new ServiceException("数据不能为空");
		if(StringUtils.isEmpty(entity.getExpertMessage()))
			throw new ServiceException("专家信息不能为空");
		int count = expertDao.updateMessage(entity);
		if(count==0)
			throw new ServiceException("要添加的数据可能已经不存在");
		return count;
	}
}
