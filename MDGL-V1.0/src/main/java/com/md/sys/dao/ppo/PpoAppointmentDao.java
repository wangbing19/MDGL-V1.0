package com.md.sys.dao.ppo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.ppo.PpoAppointment;

public interface PpoAppointmentDao {
	public List<PpoAppointment> findTrainernameByname(String appointmentName);
	/**查询所有预约训练师信息*/
	public List<PpoAppointment> findAppointment(@Param("trainername")String trainerName,
			@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	/**分页查询*/
	public int getRowCount(@Param("trainername") String trainerName);
	/**增加预约训练师信息*/
	int insertAppointment(PpoAppointment ppoAppointment);
	/**删除预约训练师信息*/
	int deleteAppointment(@Param("AppointmentId")Integer id);
	/**基于id查询信息*/
	PpoAppointment findTrainernameById(Integer id);
	/**修改预约训练师信息*/
	int updateAppointment(PpoAppointment ppoAppointment);
}
