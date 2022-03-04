package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beans.Scenic;

@Mapper
public interface ScenicMangerMapper {
	List<Scenic>selectAll();	
	int selectscenicSum();
	Scenic getScenicById(int id);
	void addscenic(Scenic scenic) ;
	void del_scenic(int id);
	void update_scenic(Scenic scenic);
}
