package com.md.sys.service.ppo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.common.vo.PageObject;
import com.md.sys.entity.ppo.PpoAppointment;

public interface PpoAppointmentService {
	/**查询所有预约训练师信息*/
	public List<PpoAppointment> findTrainernameByname(String appointmentName);
	/**分页查询*/
	public PageObject<PpoAppointment> findAppointment(String appointmentName,Integer pageCurrent);
	/**增加预约训练师信息*/
	int insertAppointment(PpoAppointment ppoAppointment);
	/**删除预约训练师信息*/
	int deleteAppointment(@Param("AppointmentId")Integer id);
	/**修改预约训练师信息*/
	/*
	int updateAppointment(PpoAppointment ppoAppointment);
	*/
	PpoAppointment findAppointmentById(PpoAppointment entity);
	int updateAppointment(PpoAppointment ppoAppointment);
}
