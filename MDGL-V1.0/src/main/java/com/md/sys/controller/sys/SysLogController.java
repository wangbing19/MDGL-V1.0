package com.md.sys.controller.sys;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.md.common.vo.JsonResult;
import com.md.common.vo.PageObject;
import com.md.sys.entity.sys.SysLog;
import com.md.sys.service.sys.SysLogService;

/**
 * 日志管理的控制层对象
 * 
 * @Controller注解 用于描述这个对象要交给spring管理， 可以认为是spring中的一个bean对象。
 * @RequestMapping 用于定义此controller对象 的一个根路径映射，当访问某个方法时，方法映射 路径的前面都会加上这个根路径
 */
@Controller
@RequestMapping("/log/")
public class SysLogController {

	@Autowired
	private SysLogService sysLogService;

	/**
	 * 加载页面
	 * 
	 * @return
	 */
	@RequiresPermissions("sys:log:view")
	@RequestMapping("doLogListUI")
	public String doLogListUI() {
		// 此值会交给视图解析器进行解析
		return "sys/log_list";
		// WEB-INF/pages/sys/log_list.html
	}

	/**
	 * 删除
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping("doDeleteObjects") // 只能处理post请求
	@ResponseBody
	public JsonResult doDeleteObjects(Integer... ids) {// spring mvc请求参数映射
		System.out.println("log.delete.service=" + sysLogService.getClass().getName());
		sysLogService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}

	/**
	 * 查询数据
	 * 
	 * @param username
	 * @param page
	 * @return
	 */
	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username, @RequestParam(value = "pageCurrent", required = false) Integer page) {
		PageObject<SysLog> pageObject = sysLogService.findPageObjects(username, page);
		return new JsonResult(pageObject);
	}

}
