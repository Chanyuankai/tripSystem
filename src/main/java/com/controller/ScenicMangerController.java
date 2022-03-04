package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.beans.Manger;
import com.beans.Plane;
import com.beans.Scenic;
import com.beans.User;
import com.mapper.MangerMapper;
import com.mapper.ScenicMangerMapper;


@Controller
public class ScenicMangerController {
	
	@Resource
	private ScenicMangerMapper scenicmangermapper;
	private MangerMapper mangermapper;
	

	@RequestMapping("login-manger.html") 
	public String loginmanger22(String number,String password,ModelMap m){
			return "login-manger.html";
		}
	@GetMapping("scenicmanger-all.html")
	public String scenicmangerlist(ModelMap m) {
     List<Scenic> list = scenicmangermapper.selectAll();
    	m.put("list", list);	
    	m.addAttribute("msg","共有 " +selectsum()+" 条数据");
		return "scenicmanger-all.html"; 
	}
 int selectsum() {
   	 return scenicmangermapper.selectscenicSum();
    }
 
 @RequestMapping("addscenic")
 public String addscenic(@RequestParam("file") MultipartFile img, Scenic scenic,ModelMap m) throws IOException {
     /**
      * 上传图片
      */
     //图片上传成功后，将图片的地址写到数据库
     //保存图片的路径
     String filePath = "D:\\eclipse-workspace222\\trip1\\src\\main\\resources\\templates\\img";
     //获取原始图片的拓展名
     String originalFilename = img.getOriginalFilename();
     //新的文件名字
     String newFileName =UUID.randomUUID() + originalFilename;
     //封装上传文件位置的全路径
     File targetFile = new File(filePath, newFileName);
     //把本地文件上传到封装上传文件位置的全路径
     img.transferTo(targetFile);
     scenic.setImg(newFileName);
     /**
      * 保存商品
      */
     scenicmangermapper.addscenic(scenic);
     return scenicmangerlist(m);
 }
 @GetMapping("/detailscenicmanger/{id}")    
 public String modificationscenic(@PathVariable int id, Model model){
     Scenic scenic = scenicmangermapper.getScenicById(id);
     model.addAttribute("scenic", scenic);
     return "scenicmanger-details.html";
 }
 @PostMapping("/updateScenicOrder")
 public String updatescenic(Scenic scenic,ModelMap m) {
   scenicmangermapper.update_scenic(scenic);
 	m.put("msg", "信息更新成功");
 	return scenicmangerlist(m); 
 }
 @GetMapping("/deletescenic/{id}")
 public String deletescenic(@PathVariable int id,ModelMap m) {
 scenicmangermapper.del_scenic(id);
 return scenicmangerlist(m);

 }
}
 

