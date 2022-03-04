package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beans.PlaneOrder;


@Mapper
public interface PlaneOrderMapper {
	
	

	int addPlaneOrder(PlaneOrder planeorder);

	List<PlaneOrder> getPlaneOrderBynumber(String number);

}
