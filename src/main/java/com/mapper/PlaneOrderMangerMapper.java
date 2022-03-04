package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beans.CarOrder;
import com.beans.PlaneOrder;
import com.beans.ScenicOrder;
import com.beans.TrainOrder;
@Mapper
public interface PlaneOrderMangerMapper {
	List<PlaneOrder> selectAllplaneorder();
	int selectplaneorderSum();
	int selectcarorderSum();
	int selecttrainorderSum();
	List<CarOrder> selectAllcarorder();
	List<TrainOrder> selectAlltrainorder();
	List<ScenicOrder> selectAllscenicorder();
	int selectscenicorderSum();

}
