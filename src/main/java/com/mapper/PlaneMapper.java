package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;


import com.beans.Plane;


@Mapper
public interface PlaneMapper {
	List<Plane>selectAll();	
	int selectplaneSum();
	List<Plane> getPlaneBydate(String  date);
	List<Plane> getPlaneByplace(String departure,String arrive);
	Plane getPlaneById(int id);
	void addplane(Plane plane);
	void delplane(int id);
	void update_plane(Plane plane);
	List<Plane> getPlaneBymanger(String date, String departure, String arrive);

}
