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
import com.beans.Plane;
import com.beans.PlaneOrder;
import com.mapper.PlaneMapper;
import com.mapper.PlaneOrderMapper;

@Controller
public class PlaneController {
	
	@Resource
	private PlaneMapper planemapper;
	@Resource
	private PlaneOrderMapper planeordermapper;
	



	@GetMapping("plane-all.html")
	public String planelist(ModelMap m) {
     List<Plane> list = planemapper.selectAll();
    	m.put("list", list);	
    	m.addAttribute("msg","共有 " +selectsum()+" 条数据");
		return "plane-all.html"; 
	}
 int selectsum() {
   	 return planemapper.selectplaneSum();
    }
 
 @PostMapping("/planesearchDate")
 public String searchdate(String date,ModelMap m) {
	 List<Plane> plane= planemapper.getPlaneBydate(date);
 	m.put("plane", plane);
 	return "plane-searchdate.html";
 }
 @PostMapping("/planesearchPlace")
 public String searchplace(String departure,String arrive,ModelMap m) {
	 List<Plane> plane= planemapper.getPlaneByplace(departure,arrive);
 	m.put("plane", plane);
 	return "plane-searchdate.html";
 }
 
 @RequestMapping("/addPlaneOrder")
 public String addPlaneOrder(PlaneOrder planeorder,ModelMap m) {
	 planeordermapper.addPlaneOrder(planeorder); 
	 m.put("msg","购买成功");
 	 return planelist(m);
}
 @GetMapping("planelist-add.html")//后台机票列表
	public String planelistmanger(ModelMap m) {
  List<Plane> list = planemapper.selectAll();
 	m.put("list", list);	
 	m.addAttribute("msg","共有 " +selectsum()+" 条数据");
		return "planelist-add.html"; 
	}
 
 @PostMapping("/addplane") //后台机票添加 
 public String addplane(Plane plane,ModelMap m) {
 	planemapper.addplane(plane);
 	 m.put("msg","发布成功");
 	 return planelistmanger(m);
 }
 
 
 @GetMapping("/deleteplane/{id}")//后台机票删除
 public String deleteplane(@PathVariable int id,ModelMap m) {
   planemapper.delplane(id);
 	return planelistmanger(m);
 	
 }
 
 @GetMapping("/modificationplane/{id}")    
 public String modificationplane(@PathVariable int id, Model model){
     Plane plane = planemapper.getPlaneById(id);
     model.addAttribute("plane", plane);
     return "plane-update.html";
 }
 @PostMapping("/updateplane")
	public String updateplane(Plane plane,ModelMap m) {
	  planemapper.update_plane(plane);
		m.put("msg", "用户信息更新成功");
		return planelist(m); 
}
 
 @PostMapping("/planesearchDatemanger")
 public String searchdatemanger(String date,String departure,String arrive,ModelMap m) {
	 List<Plane> plane= planemapper.getPlaneBymanger(date,departure,arrive);
 	m.put("plane", plane);
 	return "plane-searchdatemanger.html";
 }
}
