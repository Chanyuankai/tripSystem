package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.beans.User;

@Mapper
public interface UserMapper {
            List<User>selectAll();	
	        int selectuserSum();
			int addUser(User user);  //这里用int 或 void都可以			
			int del_user(int id);
			User getUserById(int id);
			int update_user(User user); 

			User loginuser(@Param("number") String number,@Param("password") String password);
			User getUserByname(String name);
			List<User> selectuserAll();

}
