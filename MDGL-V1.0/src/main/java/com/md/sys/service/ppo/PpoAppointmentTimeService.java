package com.md.sys.service.ppo;

import java.util.Date;
import java.util.List;

public interface PpoAppointmentTimeService {
	int insertAppointment(Date sTime,Date eTime,Integer appointmentId );
	List<Object>findAppointmentTime(Integer appointment_id);
	int deleteAppointmentTime(Integer appointment_id);
	int updateAppointment(Date sTime, Date eTime, Integer appointmentId);
}
