package com.md.sys.service.ppo.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.ppo.PpoAppointmentDao;
import com.md.sys.entity.ppo.PpoAppointment;
import com.md.sys.service.ppo.PpoAppointmentService;

@Service
public class PpoAppointmentServiceImpl implements PpoAppointmentService{
	@Autowired
	private PpoAppointmentDao ppoAppointmentDao;
	@Override
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
	@Override
	public PageObject<PpoAppointment> findAppointment(String appointmentName, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new ServiceException("页码值不正确");
		int rowCount=ppoAppointmentDao.getRowCount(appointmentName);
		if(rowCount==0)
			throw new ServiceException("记录不存在");
		int pageSize=3;
		int startIndex=(pageCurrent-1)*pageSize;
		List<PpoAppointment> records = ppoAppointmentDao.findAppointment(appointmentName, startIndex, pageSize);
		PageObject<PpoAppointment> pageObject = new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		int pageCount=(rowCount-1)/pageSize+1;
		System.out.println(pageCount);
		pageObject.setPageCount(pageCount);
		return pageObject;
	}

	
	
}
