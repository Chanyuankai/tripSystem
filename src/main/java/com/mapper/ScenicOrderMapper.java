package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.beans.ScenicOrder;


@Mapper
public interface ScenicOrderMapper {
	
	

	int addScenicOrder(ScenicOrder scenicorder);

}
