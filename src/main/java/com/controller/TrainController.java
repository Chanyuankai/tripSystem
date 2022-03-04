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

import com.beans.PlaneOrder;
import com.beans.Train;
import com.beans.TrainOrder;
import com.mapper.TrainMapper;
import com.mapper.TrainOrderMapper;

@Controller
public class TrainController {
	@Resource
	private TrainMapper trainmapper;
	@Resource
	private TrainOrderMapper trainodermapper;


	@GetMapping("train-all.html")
	public String trainlist(ModelMap m) {
     List<Train> list = trainmapper.selectAll();
    	m.put("list", list);	
    	m.addAttribute("msg","共有 " +selectsum()+" 条数据");
		return "train-all.html"; 
	}
 int selectsum() {
   	 return trainmapper.selecttrainSum();
    }
 
 @PostMapping("/trainsearchDate")
 public String searchdate(String date,ModelMap m) {
	 List<Train> train= trainmapper.getTrainBydate(date);
 	m.put("train",train);
 	return "train-searchdate.html";
 }
 @PostMapping("/trainsearchPlace")
 public String searchplace(String departure,String arrive,ModelMap m) {
	 List<Train> train=trainmapper.getTrainByplace(departure,arrive);
 	m.put("train",train);
 	return "train-searchplace.html";
 }
 @RequestMapping("/addTrainOrder")
 public String addPlaneOrder(TrainOrder trainorder,ModelMap m) {
	 trainodermapper.addTrainOrder(trainorder); 
	 m.put("msg","购买成功");
 	 return trainlist(m);
}
 @GetMapping("trainlist-add.html")//后台车票列表
	public String trainlistmanger(ModelMap m) {
 List<Train> list = trainmapper.selectAll();
 m.put("list", list);
	m.addAttribute("msg","共有 " +selectsum()+" 条数据");
		return "trainlist-add.html"; 
	}
@PostMapping("/addtrain") //后台车票添加 
public String addtrain(Train train,ModelMap m) {
	 trainmapper.addtrain(train);
	 m.put("msg","发布成功");
	 return trainlistmanger(m);
}
@GetMapping("/deletetrain/{id}")//后台车票删除
public String deletetrain(@PathVariable int id,ModelMap m) {
	 trainmapper.deltrain(id);
	return trainlistmanger(m);
	
}

@GetMapping("/modificationtrain/{id}")    
public String modificationtrain(@PathVariable int id, Model model){
	 Train train = trainmapper.getTrainById(id);
  model.addAttribute("train", train);
  return "train-update.html";
}
@PostMapping("/updatetrain")
	public String updatetrain(Train train,ModelMap m) {
	 trainmapper.update_train(train);
		m.put("msg", "用户信息更新成功");
		return trainlist(m); 
}
@PostMapping("/trainsearchDatemanger")
public String searchdatemanger(String date,String departure,String arrive,ModelMap m) {
	 List<Train> train= trainmapper.getTrainBymanger(date,departure,arrive);
	m.put("train",train);
	return "train-searchdatemanger.html";
}
}
