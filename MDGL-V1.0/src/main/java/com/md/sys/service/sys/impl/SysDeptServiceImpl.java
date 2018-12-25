package com.md.sys.service.sys.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.md.common.annotation.sys.RequiresLog;
import com.md.common.exception.ServiceException;
import com.md.common.vo.Node;
import com.md.sys.dao.sys.SysDeptDao;
import com.md.sys.entity.sys.SysDept;
import com.md.sys.service.sys.SysDeptService;


/***
 * @Transactional 注解可以应用在方法和类上
 * 1)定义在类上：所有方法都会开启事务
 * 2)定义在方法上：主要用于做事务特性设置
 * @author ta
 *
 */
@Transactional(timeout=30,rollbackFor=RuntimeException.class)
@Service
public class SysDeptServiceImpl implements SysDeptService {
	@Autowired
	private SysDeptDao sysDeptDao;
	//@Autowired
	//private SysUserDao sysUserDao;
	
	@Transactional(rollbackFor=Throwable.class)
	@Override
	@RequiresLog("系统管理-部门-更新部门信息")
	public int updateObject(SysDept entity) {
		//1.合法验证
		if(entity==null)
		throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
		throw new ServiceException("部门不能为空");
		int rows;
		//2.更新数据
		try{
		rows=sysDeptDao.updateObject(entity);
		}catch(Exception e){
		e.printStackTrace();
		throw new ServiceException("更新失败");
		}
		//3.返回数据
		return rows;
	}
	
	@Override
	@RequiresLog("系统管理-部门-新增部门")
	public int saveObject(SysDept entity) {
		//1.合法验证
		if(entity==null)
		throw new ServiceException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
		throw new ServiceException("部门不能为空");
		//2.保存数据
		int rows=sysDeptDao.insertObject(entity);
		//if(rows==1)
		//throw new ServiceException("save error");
		//3.返回数据
		return rows;
	}
	@Transactional(readOnly=false)//默认为false
	@Override
	public List<Node> findZTreeNodes() {
		return sysDeptDao.findZTreeNodes();
	}
	@Transactional(readOnly=false)
	@Override
	@RequiresLog("系统管理-部门-查找部门信息")
	public List<Map<String, Object>> findObjects() {
		return sysDeptDao.findObjects();
	}
	
	@Override
	@RequiresLog("系统管理-部门-删除部门信息")
	public int deleteObject(Integer id) {
		//1.合法性验证
		if(id==null||id<=0)
		throw new ServiceException("数据不合法,id="+id);
		//2.执行删除操作
		//2.1判定此id对应的菜单是否有子元素
		int childCount=sysDeptDao.getChildCount(id);
		if(childCount>0)
		throw new ServiceException("此元素有子元素，不允许删除");
		//2.2判定此部门是否有用户
		//int userCount=sysUserDao.getUserCountByDeptId(id);
		//if(userCount>0)
		//throw new ServiceException("此部门有员工，不允许对部门进行删除");
		//2.2判定此部门是否已经被用户使用,假如有则拒绝删除
		//2.3执行删除操作
		int rows=sysDeptDao.deleteObject(id);
		if(rows==0)
		throw new ServiceException("此信息可能已经不存在");
		return rows;
	}

}
