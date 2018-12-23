package com.md.sys.service.sys.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.md.common.annotation.sys.RequiresLog;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.sys.dao.sys.SysLogDao;
import com.md.sys.entity.sys.SysLog;
import com.md.sys.service.sys.SysLogService;

@Service
public class SysLogServiceImpl implements SysLogService {
	/**
	 * @Qualifier 要与@Autowired注解结合使用。 当为@Autowired修饰的属性按类型注入值，存
	 *            在多个类型时，可以借助@Qualifier指定其要 注入的bean的名字
	 */
	@Autowired 
	@Qualifier("sysLogDao")
	private SysLogDao sysLogDao;

	@RequiresLog("系统管理-日志-删除日志")
	@Override
	public int deleteObjects(Integer... ids) {
		if (ids == null || ids.length == 0)
			throw new IllegalArgumentException("请先选择");
		int rows = 0;
		try {
			rows = sysLogDao.deleteObjects(ids);
		} catch (Throwable e) {
			e.printStackTrace();
			throw new ServiceException(e);
		}
		if (rows == 0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

	@RequiresLog("系统管理-日志-查询日志")
	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		if (pageCurrent == null || pageCurrent < 1)
			throw new IllegalArgumentException("页码值不正确");
		int rowCount = sysLogDao.getRowCount(username);
		if (rowCount == 0)
			throw new ServiceException("记录不存在");
		int pageSize = 15;// 页面大小
		int startIndex = (pageCurrent - 1) * pageSize;// 起始位置
		List<SysLog> records = sysLogDao.findPageObjects(username, startIndex, pageSize);
		PageObject<SysLog> pageObject = new PageObject<>();
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setPageSize(pageSize);
		int pageCount = (rowCount - 1) / pageSize + 1;
		pageObject.setPageCount(pageCount);
		return pageObject;
	}

}
