package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beans.TrainOrder;


@Mapper
public interface TrainOrderMapper {
	int addTrainOrder(TrainOrder trainorder);

	List<TrainOrder> getTrainOrderBynumber(String number);

}
