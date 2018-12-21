package com.md.sys.service.sys;
import java.util.List;
import java.util.Map;

import com.md.common.vo.Node;
import com.md.sys.entity.sys.SysDept;


public interface SysDeptService {
	int saveObject(SysDept entity);
	int updateObject(SysDept entity);
	
	List<Node> findZTreeNodes();
	List<Map<String,Object>> findObjects();
	
	int deleteObject(Integer id);
}
