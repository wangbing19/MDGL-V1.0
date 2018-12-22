package com.md.sys.controller.ppo;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.ppo.PpoAppointment;
import com.md.sys.service.ppo.PpoAppointmentService;
import com.md.sys.service.ppo.PpoAppointmentTimeService;

@Controller
@RequestMapping("/appointment/")
public class PpoAppointmentController {
	@Autowired
	PpoAppointmentService ppoAppointmentService;
	@Autowired
	PpoAppointmentTimeService ppoAppointmentTimeService;
	/**查询训练师*/
	@RequestMapping("doAppointmentUI")
	public String doAppointmentUI() {
		return "sys/appointment_list";
	}
	/**保存预约训练师*/
	@RequestMapping("saveObjectUI")
	public String saveObject() {
		return "sys/appointment_edit";
	}
	/**保存训练师的预约时间*/
	@RequestMapping("doappointmentTimeUI")
	public String doappointmentTimeUI() {
		return "sys/appointmentTime_edit";
	}
	/**查询预约训练师*/
	@RequestMapping("doFindAppointment")
	@ResponseBody
	public JsonResult doFindAppointment(String appointmentName) {
		//System.out.println(appointmentName);
		List<PpoAppointment> pageObject = ppoAppointmentService.findTrainernameByname(appointmentName);
		return new JsonResult(pageObject);
	}
	/**查询所有训练师记录*/
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String appointmentName,Integer pageCurrent) {
		PageObject<PpoAppointment> pageObject = ppoAppointmentService.findAppointment(appointmentName, pageCurrent);
		return new JsonResult(pageObject);
	}
	/**增加预约训练师*/
	@RequestMapping("doinsertAppointment")
	@ResponseBody
	public JsonResult insertAppointment(PpoAppointment entity) {
		
		 ppoAppointmentService.insertAppointment(entity);
		return new JsonResult("保存成功！");
	}
	/**删除预约训练师*/
	@RequestMapping("dodeleteAppointment")
	@ResponseBody
	public JsonResult deleteAppointment(Integer id) {
		//System.out.println("删除ID"+id);
		
		 ppoAppointmentService.deleteAppointment(id);
		return new JsonResult("删除成功");
	}
	
	/**修改预约训练师*/
	@RequestMapping("doupdateAppointment")
	@ResponseBody
	public JsonResult updateAppointment(PpoAppointment entity) {
		System.out.println(entity);
		ppoAppointmentService.updateAppointment(entity);
		return new JsonResult("修改成功");
	}
	
	@RequestMapping("findAppointmentById")
	@ResponseBody
	public JsonResult findAppointmentById(PpoAppointment entity) {
		//System.out.println(entity);
		PpoAppointment findAppointmen = ppoAppointmentService.findAppointmentById(entity);
		return new JsonResult(findAppointmen);
	}
	/**添加预约时间*/
	@RequestMapping("dosaveAppointmentTime")
	@ResponseBody
	public JsonResult appointmentTime(String sTime,String eTime,Integer appointmentId) {
		System.out.println("1:"+sTime+   eTime+    appointmentId);	
		Date startTime=dateFormat(sTime);
		Date endTime=dateFormat(eTime);
		System.out.println("appointmentId"+appointmentId);
		ppoAppointmentTimeService.insertAppointment(startTime, endTime, appointmentId);
		return new JsonResult("保存成功！");
	}
	
	/**字符串转换时间格式方法*/
	public Date dateFormat(String strDate) {
		//System.out.println("dateFormat")
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date parseTime = null;
		try {
			parseTime = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//System.out.println(strDate+":"+parseTime);
		return parseTime;
	}
}
