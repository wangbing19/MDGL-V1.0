package com.md.sys.service.ppo;

import java.util.List;

import com.md.common.vo.PageObject;
import com.md.sys.entity.ppo.PpoAppointment;

public interface PpoAppointmentService {
	public List<PpoAppointment> findTrainernameByname(String appointmentName);
	public PageObject<PpoAppointment> findAppointment(String appointmentName,Integer pageCurrent);
}
