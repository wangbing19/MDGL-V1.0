package com.md.sys.service.tra;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.md.common.vo.PageObject;
import com.md.sys.entity.tra.TraInformationrecord;

public interface TraInformationrecordServic {
	
	List<Map<String,Object>> findObjects();
	PageObject<TraInformationrecord> findPageObjects(
			 String name,
			 Integer pageCurrent);
	
	int saveObject(TraInformationrecord entity);
	
	int deleteObejcts(Integer...ids);
	
	int update(TraInformationrecord entity);
	
	TraInformationrecord findObjectById(Integer id);
	
}


