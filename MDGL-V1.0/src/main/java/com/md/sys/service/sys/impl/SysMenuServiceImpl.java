package com.md.sys.service.sys.impl;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.md.common.exception.ServiceException;
import com.md.common.utils.ShiroUtils;
import com.md.common.vo.Node;
import com.md.sys.dao.sys.SysMenuDao;
import com.md.sys.dao.sys.SysRoleMenuDao;
import com.md.sys.entity.sys.SysMenu;
import com.md.sys.service.sys.SysMenuService;


/**
 * 声明式事务控制(底层借助代理机制控制事务)
 * 1)基于xml(了解)
 * 2)基于注解(趋势,例如spring boot)
 * 注解方式的声明式事务控制需要借助@Transactional
 * 注解对类或方法进行描述。
 */
@Transactional(rollbackFor=Throwable.class,
               timeout=5,
               isolation=Isolation.READ_COMMITTED)
@Service
public class SysMenuServiceImpl implements SysMenuService {
	@Autowired
	private SysMenuDao sysMenuDao;
	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;
	
	@Transactional(timeout=3)
	@Override
	public int updateObject(SysMenu entity) {
		if(entity==null)
			throw new IllegalArgumentException("参数异常");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("菜单名不能为空");
		entity.setModifiedUser(ShiroUtils.getUser().getUsername());
		int rows=sysMenuDao.updateObject(entity);
		//4.返回结果
		return rows;
	}
	
	@Override
	public int saveObject(SysMenu entity) {
		if(entity==null)
		throw new IllegalArgumentException("参数异常");
		if(StringUtils.isEmpty(entity.getName()))
		throw new IllegalArgumentException("菜单名不能为空");
		entity.setCreatedUser(ShiroUtils.getUser().getUsername());
		entity.setModifiedUser(ShiroUtils.getUser().getUsername());
		int rows=sysMenuDao.insertObject(entity);
		return rows;
	}
	/**
	 * 假如是读事务，建议readOnly属性的值为true，
	 * readOnly默认为false
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Node> findZtreeMenuNodes() {
		List<Node> list=sysMenuDao.findZtreeMenuNodes();
		if(list==null||list.size()==0)
		throw new ServiceException("记录不存在");
		return list;
	}
	@Override
	public int deleteObject(Integer id) {
		//1.验证参数有效性
		if(id==null||id<1)
		throw new IllegalArgumentException("参数id无效");
		//2.统计菜单是否有子菜单，并进行验证
		int rowCount=sysMenuDao.getChildCount(id);
		if(rowCount>0)
		throw new ServiceException("请先删除子菜单");
		//3.删除当前菜单信息
		int rows=sysMenuDao.deleteObject(id);
		if(rows==0)
		throw new ServiceException("记录可能已经不存在");
		//4.删除菜单角色的关系数据
		int count=sysRoleMenuDao.deleteObjectsByMenuId(id);
		//if(count>0)throw new ServiceException("关系数据删除失败");
		return rows;
	}

	@Transactional(readOnly=false,propagation=Propagation.REQUIRES_NEW)
	@Override
	public List<Map<String, Object>> findObjects() {
		List<Map<String, Object>> list=sysMenuDao.findObjects();
		if(list==null||list.size()==0)
		throw new ServiceException("没有对应数据");
		return list;
	}

}
