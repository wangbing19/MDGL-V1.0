package com.md.sys.service.ppo.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.md.common.exception.ServiceException;
import com.md.sys.dao.ppo.PpoAppointmentTimetDao;
import com.md.sys.service.ppo.PpoAppointmentTimeService;

@Service
public class PpoAppointmentTimeServiceImpl implements PpoAppointmentTimeService{
	@Autowired
	private PpoAppointmentTimetDao ppoAppointmentTimetDao;
		/**设置训练师的时间*/
	@Override
	@SuppressWarnings("unused")
	public int insertAppointment(Date sTime, Date eTime, Integer appointmentId) {
		if(sTime ==null)
			throw new ServiceException("开始时间不能为空");
		if(sTime ==null)
			throw new ServiceException("结束时间不能为空");
		if(appointmentId ==null)
			throw new ServiceException("请选择训练师");
		//System.out.println("1111111111111"+sTime+eTime+appointmentId);
		int rows = ppoAppointmentTimetDao.insertAppointment(sTime, eTime, appointmentId);
		return rows;
	}
	/**查询训练师的预约时间*/
	@Override
	public List<Object> findAppointmentTime(Integer appointment_id) {
		if(appointment_id ==null)
			throw new ServiceException("请选择训练师");
		//System.out.println("21212121"+appointment_id);
		List<Object> findAppointmentTimeObject = ppoAppointmentTimetDao.findAppointmentTime(appointment_id);
		
		if(findAppointmentTimeObject==null)
				throw new ServiceException("该训练师可能还没有设置训练时间");
		return findAppointmentTimeObject;
	}
	
	/**修改训练师的时间*/
	@Override
	@SuppressWarnings("unused")
	public int updateAppointment(Date sTime, Date eTime, Integer appointmentId) {
		if(sTime ==null)
			throw new ServiceException("开始时间不能为空");
		if(sTime ==null)
			throw new ServiceException("结束时间不能为空");
		if(appointmentId ==null)
			throw new ServiceException("请选择训练师");
		int rows = ppoAppointmentTimetDao.updateAppointment(sTime, eTime, appointmentId);
		return rows;
	}
	/**删除查询训练师的预约时间*/
	@Override
	public int deleteAppointmentTime(Integer appointment_id) {
		if(appointment_id==null)
			throw new ServiceException("请选择训练师");
		int rows = ppoAppointmentTimetDao.deleteAppointmentTime(appointment_id);
		return rows;
	}
	
	
	

	
	
}
