package com.test;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;

public class TestDataSource extends TestBase {
	
	@Test
	public void testDruidSource() throws SQLException {
		DataSource ds = ctx.getBean("dataSource", DataSource.class);
		Connection connection = ds.getConnection();//获取数据库连接
		System.out.println(connection);
	}

}
