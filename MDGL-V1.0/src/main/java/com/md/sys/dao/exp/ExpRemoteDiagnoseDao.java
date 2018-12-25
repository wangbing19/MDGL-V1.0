package com.md.sys.dao.exp;

import java.util.List;
import org.apache.ibatis.annotations.Param;


import com.md.common.vo.ExpRemoteDiagnoseVo;
import com.md.sys.entity.exp.ExpRemoteDiagnose;



public interface ExpRemoteDiagnoseDao {
	/**
	 * 对应添加作用
	 * @param entity:从浏览器获取的添加信息
	 * @return
	 */
	int insertObject(ExpRemoteDiagnose entity);
			

	/**
	 *不输入客户名字的话默认是查询出全部信息
	 * @param username 客户名字
	 * @param startIndex 当前页的第一个信息对应的门店诊断序号
	 * @param pageSize 每一页显示的数量
	 * @return
	 */
	List<ExpRemoteDiagnoseVo> findPageObjects(
			@Param("customerName") String customerName,
			@Param("startIndex")Integer startIndex,
			@Param("pageSize")Integer pageSize,
			@Param("registerParentid")Integer registerParentid);
	
	
	/**
	 * 查询对应客户姓名的数量,如果没输入客户姓名则查询远程诊断表中的所有数量
	 * @param customerName:客户姓名
	 * @return
	 */
	int getRowCount(
			@Param("customerName") String customerName,
			@Param("registerParentid")Integer registerParentid);
	
	/**
	 * 远程诊断表删除一条数据
	 * @param id
	 * @return
	 */
	int delete(@Param("ids")Integer... ids);
	
	/**
	 * 对应远程诊断修改
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
	 * 是否解决的点击事件切换
	 * @param id
	 * @param valid
	 * @param modifiedUser
	 * @return
	 */
	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);
}
