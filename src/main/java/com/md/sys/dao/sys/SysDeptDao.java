package com.md.sys.dao.sys;
import java.util.List;
import java.util.Map;

import com.md.common.vo.Node;
import com.md.sys.entity.sys.SysDept;


public interface SysDeptDao {
	int updateObject(SysDept entity);
	int insertObject(SysDept entity);
	List<Node> findZTreeNodes();
	List<Map<String,Object>> findObjects();
	int getChildCount(Integer id);
	int deleteObject(Integer id);
}
