package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beans.Car;
import com.beans.Plane;

@Mapper
public interface CarMapper {
	List<Car>selectAll();	
	int selectcarSum();
	List<Car> getCarBydate(String  date);
	List<Car> getCarByplace(String departure,String arrive);
	Car getCarById(int id);
	void addcar(Car car);
	void delcar(int id);
	void update_car(Car car);
	List<Car> getCarBymanger(String date, String departure, String arrive);
}
