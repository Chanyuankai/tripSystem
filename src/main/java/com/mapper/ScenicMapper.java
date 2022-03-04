package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beans.Scenic;

@Mapper
public interface ScenicMapper {
	List<Scenic>selectAll();	
	int selectscenicSum();
	Scenic getScenicById(int id);
	static void addscenic(Scenic scenic) {
		// TODO Auto-generated method stub
		
	}
	List<Scenic> getScenicBysite(String site);
	List<Scenic> getScenicByname(String name);

}
