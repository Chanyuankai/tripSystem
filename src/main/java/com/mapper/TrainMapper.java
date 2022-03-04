package com.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.beans.Train;

@Mapper
public interface TrainMapper {
	List<Train>selectAll();	
	int selecttrainSum();
	List<Train> getTrainBydate(String  date);
	List<Train> getTrainByplace(String departure,String arrive);
	Train getTrainById(int id);
	void deltrain(int id);
	void update_train(Train train);
	List<Train> getTrainBymanger(String date, String departure, String arrive);
	void addtrain(Train train);
}
