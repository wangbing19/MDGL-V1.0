package com.md.sys.service.res;

import java.util.List;
import java.util.Map;


import com.md.sys.entity.res.ResSymptomType;

public interface ResSymptomTypeService {

	List<Map<String,Object>> findPageObject(Integer id);
	
	List<Map<String,Object>> findObjects();
	
	int saveObject(ResSymptomType entity);
	
	int deleteObject(Integer id); 
	
	int updateObject(ResSymptomType entity);
}
