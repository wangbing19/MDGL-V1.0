package com.md.sys.dao.ppo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.md.sys.entity.ppo.PpoAppointment;

public interface PpoAppointmentDao {
	public List<PpoAppointment> findTrainernameByname(String appointmentName);
	public List<PpoAppointment> findAppointment(@Param("trainername")String trainerName,
			@Param("startIndex")Integer startIndex,@Param("pageSize")Integer pageSize);
	public int getRowCount(@Param("trainername") String trainerName);
}
