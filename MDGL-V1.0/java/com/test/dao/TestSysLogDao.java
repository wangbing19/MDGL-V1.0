package com.test.dao;

import java.util.List;

import org.junit.Test;

import com.db.sys.dao.SysLogDao;
import com.db.sys.entity.SysLog;
import com.test.TestBase;

public class TestSysLogDao extends TestBase{
	
	@Test
	public void testGetRowCount() {
		//1.获取syslogdao对象
		SysLogDao dao = ctx.getBean("sysLogDao", SysLogDao.class);
		int rowCount = dao.getRowCount("admin");
		System.out.println("rowCount="+rowCount);
	}
	
	@Test
	public void testFindPageObjects() {
		SysLogDao dao = ctx.getBean("sysLogDao", SysLogDao.class);
		List<SysLog> list = dao.findPageObjects("admin", 0, 3);
		for (SysLog sysLog : list) {
			System.out.println(sysLog);
		}
	}
	
	@Test
	public void testdeleteObjects() {
		SysLogDao dao = ctx.getBean("sysLogDao", SysLogDao.class);
		int rows = dao.deleteObjects(78,79);
		System.out.println(rows);
	}
	
}
