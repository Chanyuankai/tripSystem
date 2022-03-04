package com.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.beans.PlaneOrder;
import com.beans.ScenicOrder;
import com.beans.CarOrder;
import com.beans.TrainOrder;
import com.mapper.PlaneMapper;
import com.mapper.PlaneOrderMangerMapper;
import com.mapper.PlaneOrderMapper;

@Controller
public class PlaneOrderController {
	
	@Resource
	private PlaneOrderMapper planeordermapper;
	
	@Resource
	private PlaneOrderMangerMapper planeordermangermapper;
    
	
	@GetMapping("orderlist-all.html")
	public String planelistorder(ModelMap m1,ModelMap m2,ModelMap m3) {
		List<PlaneOrder> listplane = planeordermangermapper.selectAllplaneorder();
    	m1.put("listplane", listplane);	
    	m1.addAttribute("msgp","共有 " +selectplaneordersum()+" 条数据");
    	
    	List<CarOrder> listcar = planeordermangermapper.selectAllcarorder();
    	m2.put("listcar", listcar);	
    	m2.addAttribute("msgc","共有 " +selectcarordersum()+" 条数据");
    	
    	List<TrainOrder> listtrain = planeordermangermapper.selectAlltrainorder();
    	m3.put("listtrain", listtrain);	
    	m3.addAttribute("msgt","共有 " +selecttrainordersum()+" 条数据");
    	
    	List<ScenicOrder> listscenic = planeordermangermapper.selectAllscenicorder();
    	m3.put("listscenic", listscenic);	
    	m3.addAttribute("msgs","共有 " +selectscenicordersum()+" 条数据");
    	
		return "orderlist-all.html"; 
	}
 int selectplaneordersum() {
   	 return planeordermangermapper.selectplaneorderSum();
    }
 int selectcarordersum() {
   	 return planeordermangermapper.selectcarorderSum();
    }
 int selecttrainordersum() {
   	 return planeordermangermapper.selecttrainorderSum();
    }
 int selectscenicordersum() {
   	 return planeordermangermapper.selectscenicorderSum();
    }
	
}
