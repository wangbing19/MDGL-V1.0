package com.md.sys.controller.ppo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.ppo.PpoAppointment;
import com.md.sys.service.ppo.PpoAppointmentService;

@Controller
@RequestMapping("/appointment/")
public class PpoAppointmentController {
	@Autowired
	PpoAppointmentService ppoAppointmentService;
	@RequestMapping("doAppointmentUI")
	public String doAppointmentUI() {
		return "sys/appointment_list";
	}
	@RequestMapping("saveObject")
	public String saveObject() {
		return "sys/appointment_edit";
	}
	@RequestMapping("doFindAppointment")
	@ResponseBody
	public JsonResult doFindAppointment(String appointmentName) {
		//System.out.println(appointmentName);
		List<PpoAppointment> pageObject = ppoAppointmentService.findTrainernameByname(appointmentName);
		return new JsonResult(pageObject);
	}
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String appointmentName,Integer pageCurrent) {
		PageObject<PpoAppointment> pageObject = ppoAppointmentService.findAppointment(appointmentName, pageCurrent);
		return new JsonResult(pageObject);
	}
	
}
