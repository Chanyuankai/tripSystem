package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beans.CarOrder;


@Mapper
public interface CarOrderMapper {
	
	

	int addCarOrder(CarOrder carorder);

	List<CarOrder> getCarOrderBynumber(String number);

}
