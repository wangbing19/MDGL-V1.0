package com.md.sys.service.ppo.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.ppo.PpoAppointmentDao;
import com.md.sys.entity.ppo.PpoAppointment;
import com.md.sys.service.ppo.PpoAppointmentService;

@Service
public class PpoAppointmentServiceImpl implements PpoAppointmentService{
	@Autowired
	private PpoAppointmentDao ppoAppointmentDao;
	
	public List<PpoAppointment> findTrainernameByname(String appointmentName) {
		if(appointmentName==null)
			throw new ServiceException("训练师不能为空");
		
		List<PpoAppointment> recorde = (List<PpoAppointment>) ppoAppointmentDao.findTrainernameByname(appointmentName);
		//System.out.println("PpoAppointmentServiceImpl");	
		//System.out.println(recorde.toString());
		if(recorde ==null)
			throw new ServiceException("没有该训练师");
		
		return recorde;
	}
	
	public PageObject<PpoAppointment> findAppointment(String appointmentName, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new ServiceException("页码值不正确");
		int rowCount=ppoAppointmentDao.getRowCount(appointmentName);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<PpoAppointment> records = ppoAppointmentDao.findAppointment(appointmentName, startIndex, pageSize);
		PageObject<PpoAppointment> pageObject = new PageObject<PpoAppointment>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		int pageCount=(rowCount-1)/pageSize+1;
		System.out.println(pageCount);
		pageObject.setPageCount(pageCount);
		return pageObject;
	}
	
	public int insertAppointment(PpoAppointment ppoAppointment) {
		if(ppoAppointment ==null)
			throw new ServiceException("保存数据不能为空");
		if(StringUtils.isEmpty(ppoAppointment.getTrainername()))
			throw new ServiceException("训练师姓名不能为空");
		if(StringUtils.isEmpty(ppoAppointment.getUser_name()))
			throw new ServiceException("门店名不能为空");
		int rows = ppoAppointmentDao.insertAppointment(ppoAppointment);
		System.out.println("保存状态："+rows);
		return rows;
	}
	/**删除预约训练师*/
	public int deleteAppointment(Integer id) {
		if(id==null)
			throw new ServiceException("请选择要删除的训练师");
		if(id<=0) 
		throw new ServiceException("选择的训练师不正确，重新选择");
		int deleteAppointment = ppoAppointmentDao.deleteAppointment(id);
		if(deleteAppointment==0)
			throw new ServiceException("该训练师已被删除");
		return deleteAppointment;
	}

	public int updateAppointment(PpoAppointment ppoAppointment) {
		if(ppoAppointment.getId()==null)
			throw new ServiceException("训练师id不能为空");
		int rows=ppoAppointmentDao.updateAppointment(ppoAppointment);
		if(rows==0)
			throw new ServiceException("该记录可能不存在");
		return rows;
	}

	public PpoAppointment findAppointmentById(PpoAppointment entity) {
		if(entity.getId()==null)
			throw new ServiceException("训练师不能为空");
		System.out.println("entity.getId():"+(entity.getId()));
		PpoAppointment roeds = ppoAppointmentDao.findTrainernameById(entity.getId());
		System.out.println("roeds:"+roeds);
		return roeds;
	}
	
	
	

	
	
}
