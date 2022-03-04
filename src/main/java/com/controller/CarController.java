package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.beans.Car;
import com.beans.CarOrder;
import com.mapper.CarMapper;
import com.mapper.CarOrderMapper;

@Controller
public class CarController {
	@Resource
	private CarMapper carmapper;
	@Resource
	private CarOrderMapper carordermapper;

	@GetMapping("car-all.html")
	public String Carlist(ModelMap m) {
     List<Car> list = carmapper.selectAll();
    	m.put("list", list);	
    	m.addAttribute("msg","共有 " +selectsum()+" 条数据");
		return "car-all.html"; 
	}
 int selectsum() {
   	 return carmapper.selectcarSum();
    }
 
 @PostMapping("/carsearchDate")
 public String searchdate(String date,ModelMap m) {
	 List<Car> car= carmapper.getCarBydate(date);
 	m.put("car",car);
 	return "car-searchdate.html";
 }
 @PostMapping("/carsearchPlace")
 public String searchplace(String departure,String arrive,ModelMap m) {
	 List<Car> car=carmapper.getCarByplace(departure,arrive);
 	m.put("car",car);
 	return "car-searchplace.html";
 }
 
 @RequestMapping("/addcarOrder")
 public String addCarOrder(CarOrder carorder,ModelMap m) {
	 carordermapper.addCarOrder(carorder); 
	 m.put("msg","购买成功");
 	 return Carlist(m);
}
 
 @GetMapping("carlist-add.html")//后台车票列表
	public String carlistmanger(ModelMap m) {
 List<Car> list = carmapper.selectAll();
 m.put("list", list);
	m.addAttribute("msg","共有 " +selectsum()+" 条数据");
		return "carlist-add.html"; 
	}
@PostMapping("/addcar") //后台车票添加 
public String addplane(Car car,ModelMap m) {
	carmapper.addcar(car);
	 m.put("msg","发布成功");
	 return carlistmanger(m);
}
@GetMapping("/deletecar/{id}")//后台车票删除
public String deletecar(@PathVariable int id,ModelMap m) {
carmapper.delcar(id);
	return carlistmanger(m);
	
}
@GetMapping("/modificationcar/{id}")    
public String modificationcar(@PathVariable int id, Model model){
	 Car car = carmapper.getCarById(id);
  model.addAttribute("car", car);
  return "car-update.html";
}
@PostMapping("/updatecar")
	public String updatecar(Car car,ModelMap m) {
	 carmapper.update_car(car);
		m.put("msg", "用户信息更新成功");
		return Carlist(m); 
}
@PostMapping("/carsearchDatemanger")
public String searchdatemanger(String date,String departure,String arrive,ModelMap m) {
	 List<Car> car= carmapper.getCarBymanger(date,departure,arrive);
	m.put("car",car);
	return "car-searchdatemanger.html";
}

 
}
