package com.md.sys.service.exp.impl;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.md.common.utils.ShiroUtils;
import com.md.sys.entity.sys.SysUser;
import com.md.common.annotation.sys.RequiresLog;
import com.md.common.exception.ServiceException;
import com.md.common.vo.PageObject;
import com.md.common.vo.ExpRemoteDiagnoseVo;

import com.md.sys.dao.exp.ExpRemoteDiagnoseDao;
import com.md.sys.dao.exp.ExpSymptomsDescribedDao;
import com.md.sys.dao.exp.ExpertReplyDao;
import com.md.sys.entity.exp.ExpRemoteDiagnose;
import com.md.sys.service.exp.ExpDiagnoseService;

/**
 * 对应远程诊断表
 * 
 * @author tarena
 *
 */
@Service
public class ExpDiagnoseServiceImpl implements ExpDiagnoseService {

	@Autowired
	private ExpRemoteDiagnoseDao remoteDiagnoseDao;
	@Autowired
	private ExpertReplyDao expertReplyDao;
	@Autowired
	private ExpSymptomsDescribedDao expSymptomsDescribedDao;

	/**
	 * 对应远程诊断添加
	 */
	@RequiresLog("远程诊断添加")
	@Override
	public int saveObject(ExpRemoteDiagnose entity) {
		// 1.对参数进行校验
		if (entity == null)
			throw new IllegalArgumentException("保存对象不能为空");
		if (StringUtils.isEmpty(entity.getDeptSite()))
			throw new IllegalArgumentException("门店地址不能为空");
		if (StringUtils.isEmpty(entity.getDeptName()))
			throw new IllegalArgumentException("门店名称不能为空");
		if (StringUtils.isEmpty(entity.getCustomerName()))
			throw new IllegalArgumentException("客户姓名不能为空");
		if (StringUtils.isEmpty(entity.getCustomerTel()))
			throw new IllegalArgumentException("客户电话不能为空");
		if (StringUtils.isEmpty(entity.getSendName()))
			throw new IllegalArgumentException("发送人姓名不能为空");
		if (StringUtils.isEmpty(entity.getSendTel()))
			throw new IllegalArgumentException("发送人电话不能为空");

		// 获取登录用户的账号
		SysUser user=ShiroUtils.getUser();
		String loginuser=user.getUsername();//获取添加时用户的账号名
		String modifyuser=user.getUsername();//获取修改时用户的账号名(添加时默认是自身账号)
		int parentId=user.getParentId();
		entity.setRegisterUser(loginuser);
		entity.setModifiedUser(loginuser);
		entity.setRegisterParentid(parentId);
		//System.out.println("添加="+entity);
		
		// 保存用户自身信息
		int rows = remoteDiagnoseDao.insertObject(entity);
		
		// 通过专家表id查询专家姓名
		// entity.getExpertId();
		return rows;
	}

	/**
	 * 对应远程诊断分页查询
	 */
	@Override
	public PageObject<ExpRemoteDiagnoseVo> findPageObjects(String customerName, Integer pageCurrent) {

		// 1.判断当前页是否合法
		if (pageCurrent == null || pageCurrent <= 0)
			throw new ServiceException("参数不合法");

		// 获取登录用户的账号
		SysUser user=ShiroUtils.getUser(); 
		//System.out.println("user"+user);
		Integer parentId = user.getParentId();
		// 2.依据条件获取总记录数

		int rowCount = remoteDiagnoseDao.getRowCount(customerName,parentId);
		//System.out.println("rowCount" + rowCount);
		// 3.判断记录是否存在
		/*if (rowCount == 0)
			throw new ServiceException("您要查询记录不存在");*/

		// 4.计算每一页的开始下标
		int pageSize = 10;
		int startIndex = (pageCurrent - 1) * pageSize;

		// System.out.println("5555"+user.getParentId());

		// 5.依据条件获取当前页数据
		List<ExpRemoteDiagnoseVo> records = remoteDiagnoseDao.findPageObjects(customerName, startIndex, pageSize,//1);
		parentId);// 获取父级id
		//System.out.println("records=" + records);

		// 6.封装数据
		PageObject<ExpRemoteDiagnoseVo> pageObject = new PageObject<>();
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(rowCount);
		pageObject.setPageSize(pageSize);
		pageObject.setRecords(records);
		return pageObject;
	}

	/**
	 * 删除:通过获取的id删除表中对应的数据
	 */
	@RequiresLog("远程诊断删除")
	@Override
	public int delete(Integer... ids) {
		// 1.判断传入的id
		if (ids.length == 0 || ids == null)
			throw new ServiceException("请先选择要删除的序号");
		// 2.执行删除
		int count = remoteDiagnoseDao.delete(ids);
		// 3.判断是否删除
		if (count == 0)
			throw new ServiceException("数据可能已经不存在");
		// 4.删除远程诊断id对应的专家回复表中对应的行
		List<Integer> exp = expertReplyDao.selectExpId(ids);
		for (int i = 0; i < exp.size(); i++) {
			expertReplyDao.deleteRep(exp.get(i));
		}

		// 5.删除远程诊断id对应的症状描述表中对应的行
		List<Integer> sym = expSymptomsDescribedDao.selectSymId(ids);
		for (int i = 0; i < sym.size(); i++) {
			expSymptomsDescribedDao.deleteSym(sym.get(i));
		}
		return count;
	}

	/**
	 * 从前端获取修改后的信息并在数据库进行修改
	 */
	@RequiresLog("远程诊断修改")
	@Override
	public int update(ExpRemoteDiagnose entity) {
		//System.out.println("entity=" + entity);
		if (entity == null)
			throw new ServiceException("数据不能为空");
		if (StringUtils.isEmpty(entity.getDeptSite()))
			throw new IllegalArgumentException("门店地址不能为空");
		if (StringUtils.isEmpty(entity.getDeptName()))
			throw new IllegalArgumentException("门店名称不能为空");
		if (StringUtils.isEmpty(entity.getCustomerName()))
			throw new IllegalArgumentException("客户姓名不能为空");
		if (StringUtils.isEmpty(entity.getCustomerTel()))
			throw new IllegalArgumentException("客户电话不能为空");
		if (StringUtils.isEmpty(entity.getSendName()))
			throw new IllegalArgumentException("发送人姓名不能为空");
		if (StringUtils.isEmpty(entity.getSendTel()))
			throw new IllegalArgumentException("发送人电话不能为空");
		// 执行修改
		SysUser user = ShiroUtils.getUser();
		String username = user.getUsername();
		entity.setModifiedUser(username);
		int count = remoteDiagnoseDao.update(entity);
		
		if (count == 0)
			throw new ServiceException("要修改的数据已不存在");
		// 删除关联表的数据(待定)
		return count;
	}

	/**
	 * 通过选择的id在修改页面获取远程诊断表对应id中的信息
	 */
	@Override
	public ExpRemoteDiagnoseVo select(Integer id) {
		if (id <= 0 || id == null)
			throw new ServiceException("请输入正确的参数");
		ExpRemoteDiagnoseVo entity = remoteDiagnoseDao.select(id);
		return entity;
	}


	/**
	 * 显示是否解决的点击事件切换
	 */
	@RequiresLog("远程诊断已解决未解决")
	@Override
	public int validById(Integer id, Integer valid) {
		//1.合法性验证
		if(id==null||id<=0)
			throw new ServiceException("参数不合法,id="+id);
		if(valid!=1&&valid!=0)
			throw new ServiceException("参数不合法,valie="+valid);
		SysUser user=ShiroUtils.getUser();
		int rows=remoteDiagnoseDao.validById(id, valid,user.getUsername());
		if(rows==0)
			throw new ServiceException("记录可能已经不存在");
		return rows;
	}

}
