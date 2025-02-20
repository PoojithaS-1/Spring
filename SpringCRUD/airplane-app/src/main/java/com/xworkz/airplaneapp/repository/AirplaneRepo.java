package com.xworkz.airplaneapp.repository;

import com.xworkz.airplaneapp.dto.AirplaneDto;
import com.xworkz.airplaneapp.entity.AirplaneEntity;

import java.util.List;

public interface AirplaneRepo {

    Boolean save(AirplaneEntity airplaneEntity);
AirplaneEntity getById(Integer airplaneId);

AirplaneEntity getByNoOfSeats(Integer noOfSeats);

AirplaneEntity getByModel(String airplaneModel);

Integer updateByModel(String airplaneModel, Integer noOfSeats);

Integer updateById(Integer airplaneId, Integer noOfSeats);

Integer deleteById(Integer airplaneId);

List<AirplaneEntity> getAllData();
}
