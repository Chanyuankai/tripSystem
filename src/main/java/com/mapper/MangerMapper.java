package com.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.beans.Manger;


@Mapper
public interface MangerMapper {
	Manger login(@Param("number") String number,@Param("password") String password);
}
