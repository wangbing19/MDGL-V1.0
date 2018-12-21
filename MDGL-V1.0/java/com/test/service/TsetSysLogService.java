package com.test.service;

import org.junit.Assert;
import org.junit.Test;

import com.db.common.vo.PageObject;
import com.db.sys.entity.SysLog;
import com.db.sys.service.SysLogService;
import com.test.TestBase;

public class TsetSysLogService extends TestBase {
	@Test
	public void testFindPageObject() {
		SysLogService sysLogService = ctx.getBean("sysLogServiceImpl", SysLogService.class);
		PageObject<SysLog> po = sysLogService.findPageObjects("admin", 1);
		System.out.println(po.getPageCount());
		System.out.println(po.getRowCount());
	}

	@Test
	public void testdeleteObjects() {
		SysLogService sysLogService = ctx.getBean("sysLogServiceImpl", SysLogService.class);
		int i = sysLogService.deleteObjects(78,79);
		//断言测试法，当返回值为false时，程序不会继续执行
		Assert.assertEquals(2, i);
	}

}
