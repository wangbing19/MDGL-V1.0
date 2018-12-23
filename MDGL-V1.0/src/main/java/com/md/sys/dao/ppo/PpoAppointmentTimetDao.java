package com.md.sys.dao.ppo;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;



public interface PpoAppointmentTimetDao {
	int insertAppointment(
			@Param("startTime")Date startTime,
			@Param("endTime")Date endTime,
			@Param("appointmentId")Integer appointmentId);
	List<Object>findAppointmentTime(Integer appointment_id);
	int deleteAppointmentTime(Integer appointment_id);
	int updateAppointment(Date sTime, Date eTime, Integer appointmentId);
}

