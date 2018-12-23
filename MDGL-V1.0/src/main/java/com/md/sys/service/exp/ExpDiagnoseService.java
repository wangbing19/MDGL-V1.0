package com.md.sys.service.exp;


import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.md.common.vo.PageObject;
import com.md.common.vo.ExpRemoteDiagnoseVo;
import com.md.sys.entity.exp.ExpRemoteDiagnose;


public interface ExpDiagnoseService {

	/**
	 * 对应前端远程诊断模块中的添加作用
	 * 将从前端获取的用户信息添加到数据库
	 * @param entity
	 * @return
	 */
	int saveObject(ExpRemoteDiagnose entity);
	
	/**
	 * 对应前端页面远程诊断模块呈现页面,基于条件分页查询用户信息
	 * @param username 输入的客户姓名
	 * @param pageCurrent 当前页数
	 * @return
	 */
	PageObject<ExpRemoteDiagnoseVo> findPageObjects(
			String username,
			Integer pageCurrent);
	
	/**
	 * 删除一条:通过获取的id删除表中对应的数据
	 * @param id
	 * @return
	 */
	int delete(Integer... ids);
	
	/**
	 * 将修改后的数据发送到数据库进行修改
	 * @param entity
	 * @return
	 */
	int update(ExpRemoteDiagnose entity);
	
	/**
	 * 通过选择的id在修改页面获取远程诊断表对应id中的信息 
	 * @param id
	 * @return
	 */
	ExpRemoteDiagnoseVo select(Integer id);
	
	/**
	 * 显示是否解决的点击事件切换
	 * @param id
	 * @param valid
	 * @return
	 */
	int validById(Integer id,Integer valid);
}
