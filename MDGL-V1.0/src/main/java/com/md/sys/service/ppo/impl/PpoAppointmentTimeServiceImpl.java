package com.md.sys.service.ppo.impl;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.ppo.PpoAppointmentDao;
import com.md.sys.dao.ppo.PpoAppointmentTimetDao;
import com.md.sys.entity.ppo.PpoAppointment;
import com.md.sys.entity.ppo.PpoAppointmentTime;
import com.md.sys.service.ppo.PpoAppointmentService;
import com.md.sys.service.ppo.PpoAppointmentTimeService;

@Service
public class PpoAppointmentTimeServiceImpl implements PpoAppointmentTimeService{
	@Autowired
	private PpoAppointmentTimetDao ppoAppointmentTimetDao;

	@SuppressWarnings("unused")
	public int insertAppointment(Date sTime, Date eTime, Integer appointmentId) {
		if(sTime ==null)
			throw new ServiceException("开始时间不能为空");
		if(sTime ==null)
			throw new ServiceException("结束时间不能为空");
		if(appointmentId ==null)
			throw new ServiceException("请选择训练师");
		System.out.println("1111111111111"+sTime+eTime+appointmentId);
		int rows = ppoAppointmentTimetDao.insertAppointment(sTime, eTime, appointmentId);
		return rows;
	}
	
	
	

	
	
}
