package com.md.sys.dao.ppo;


import java.util.Date;

import org.apache.ibatis.annotations.Param;



public interface PpoAppointmentTimetDao {
	int insertAppointment(
			@Param("startTime")Date startTime,
			@Param("endTime")Date endTime,
			@Param("appointmentId")Integer appointmentId);
}
