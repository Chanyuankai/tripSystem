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
import com.beans.Plane;
import com.beans.PlaneOrder;
import com.beans.Scenic;
import com.beans.Train;
import com.beans.TrainOrder;
import com.beans.User;
import com.mapper.CarMapper;
import com.mapper.CarOrderMapper;
import com.mapper.PlaneMapper;
import com.mapper.PlaneOrderMapper;
import com.mapper.ScenicMapper;
import com.mapper.TrainMapper;
import com.mapper.TrainOrderMapper;
import com.mapper.UserMapper;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
public class UserController {
	
	private String loginNumber;
	@Resource
	private UserMapper usermapper;
	@Resource
	private PlaneMapper planemapper;
	@Resource
	private CarMapper carmapper;
	@Resource
	private TrainMapper trainmapper;
	@Resource
	private PlaneOrderMapper planeordermapper;
	@Resource
	private TrainOrderMapper trainordermapper;
	@Resource
	private CarOrderMapper carordermapper;
	@Resource
	private ScenicMapper scenicmapper;


@GetMapping("top.html")
public String index(ModelMap m) {
	m.put("loginNumber", loginNumber);
	return "top";
}
@GetMapping("left.html")
public String index2(ModelMap m) {
	m.put("loginNumber", loginNumber);
	return "left";
}


@GetMapping("index.html")
public String index3(ModelMap m) {
	m.put("loginNumber", loginNumber);
	return "index";
}

@RequestMapping("/login") 
public String loginuser(String number,String password,ModelMap m){
	//进行数据库访问
	User user=usermapper.loginuser(number, password);
	if (user!=null) {
		loginNumber=number;
		index(m);
		index2(m);
		index3(m);
	
		return "main";  
	}
	else {
		m.put("msg", "用户名或密码错误,登录失败");
		return "login";
	}	
}

@GetMapping("/detailplane/{id}")    
public String deailplane(@PathVariable int id, Model model,ModelMap m){	 
    Plane plane = planemapper.getPlaneById(id);
    m.put("loginNumber", loginNumber);
    model.addAttribute("plane", plane);
	return "plane-details";
} 

@GetMapping("/detailtrain/{id}")    
public String deailtrain(@PathVariable int id, Model model,ModelMap m){	 
    Train train = trainmapper.getTrainById(id);
    m.put("loginNumber", loginNumber);
    model.addAttribute("train", train);
	return "train-details";
} 

@GetMapping("/detailcar/{id}")    
public String deailcar(@PathVariable int id, Model model,ModelMap m){	 
    Car car = carmapper.getCarById(id);
    m.put("loginNumber", loginNumber);
    model.addAttribute("car", car);
	return "car-details";
}
@GetMapping("/detailscenic/{id}")    
public String deailscenic(@PathVariable int id, Model model,ModelMap m){	 
    Scenic scenic = scenicmapper.getScenicById(id);
    m.put("loginNumber", loginNumber);
    model.addAttribute("scenic", scenic);
	return "scenic-details";
}

@GetMapping("/personaltrain/{number}")    
public String personaltrain(@PathVariable String number, Model model,ModelMap m){	 
    List<TrainOrder> trainorder = trainordermapper.getTrainOrderBynumber(number);
	m.put("trainorder",trainorder);
	return "personaltrainorder-all";
} 
@GetMapping("/personalcar/{number}")    
public String personalcar(@PathVariable String number, Model model,ModelMap m){	 
    List<CarOrder> carorder = carordermapper.getCarOrderBynumber(number);
	m.put("carorder",carorder);
	return "personalcarorder-all";
} 
@GetMapping("/personalplane/{number}")    
public String personalplane(@PathVariable String number, Model model,ModelMap m){	 
    List<PlaneOrder> planeorder = planeordermapper.getPlaneOrderBynumber(number);
	m.put("planeorder",planeorder);
	return "personalplaneorder-all";
} 
@GetMapping("userlist-all.html")
public String userlist(ModelMap m) {
 List<User> userlist = usermapper.selectuserAll();
	m.put("userlist", userlist);	
	m.addAttribute("msg","共有 " +selectusersum()+" 条数据");
	return "userlist-all.html"; 
}
int selectusersum() {
	 return usermapper.selectuserSum();
}

@PostMapping("/adduser")  
public String addUser(User user,ModelMap m) {
usermapper.addUser(user);
 m.put("msg","发布成功");
 return userlist(m);
}
@GetMapping("/deleteuser/{id}")
public String delete(@PathVariable int id,ModelMap m) {
usermapper.del_user(id);
return userlist(m);

}
@GetMapping("/modification/{id}")    
public String modification(@PathVariable int id, Model model){
User user = usermapper.getUserById(id);
model.addAttribute("user", user);
return "user-update.html";
} 
//真正的进行修改
@PostMapping("/updateuser")
public String updateuser(User user,ModelMap m) {
  usermapper.update_user(user);
	m.put("msg", "用户信息更新成功");
	return userlist(m); 
}
@PostMapping("/searchuser")
public String searchuser(String name,ModelMap m) {
User user= usermapper.getUserByname(name);
m.put("user", user);
return "user-add.html";
}
}
