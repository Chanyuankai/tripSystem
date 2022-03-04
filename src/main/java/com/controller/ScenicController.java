package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.beans.Scenic;
import com.beans.ScenicOrder;
import com.mapper.ScenicMapper;
import com.mapper.ScenicOrderMapper;

@Controller
public class ScenicController {
	
	@Resource
	private ScenicMapper scenicmapper;
	@Resource
	private ScenicOrderMapper scenicordermapper;
	


	@GetMapping("scenic-all.html")
	public String sceniclist(ModelMap m) {
     List<Scenic> list = scenicmapper.selectAll();
    	m.put("list", list);	
    	m.addAttribute("msg","共有 " +selectsum()+" 条数据");
		return "scenic-all.html"; 
	}
 int selectsum() {
   	 return scenicmapper.selectscenicSum();
    }
@RequestMapping("/addScenicOrder")
 public String addScenicOrder(ScenicOrder scenicorder,ModelMap m) {
	 scenicordermapper.addScenicOrder(scenicorder); 
	 m.put("msg","购买成功");
 	 return sceniclist(m);
}
 @PostMapping("/scenicsearchSite")
 public String searchsite(String site,ModelMap m) {
	 List<Scenic> scenic= scenicmapper.getScenicBysite(site);
 	m.put("scenic",scenic);
 	return "scenic-searchsite.html";
 }
 @PostMapping("/scenicsearchname")
 public String searchname(String name,ModelMap m) {
	 List<Scenic> scenic= scenicmapper.getScenicByname(name);
 	m.put("scenic",scenic);
 	return "scenic-searchname.html";
 }
 

}
 

