package com.md.sys.service.ppo;

import java.util.Date;

public interface PpoAppointmentTimeService {
	int insertAppointment(Date sTime,Date eTime,Integer appointmentId );
}
