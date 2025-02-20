package com.xworkz.airplaneapp.service;

import com.xworkz.airplaneapp.dto.AirplaneDto;
import com.xworkz.airplaneapp.entity.AirplaneEntity;
import com.xworkz.airplaneapp.repository.AirplaneRepo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class AirplaneServiceImpl implements AirplaneService{
@Autowired
    AirplaneRepo airplaneRepo;
    @Override
    public Boolean validateAndSave(AirplaneDto airplaneDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<AirplaneDto>> validate = validator.validate(airplaneDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            AirplaneEntity airplaneEntity = new AirplaneEntity();
            try {
                BeanUtils.copyProperties(airplaneEntity, airplaneDto);
                System.out.println(airplaneEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            airplaneRepo.save(airplaneEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public AirplaneEntity getById(Integer airplaneId) {
        AirplaneEntity airplaneEntity = airplaneRepo.getById(airplaneId);
        if (airplaneEntity != null) {
            System.out.println("AirPlane id found\n" + airplaneEntity);
        }
        else {
            System.out.println("AirPlane id not found");
        }
        return airplaneEntity;    }

    @Override
    public AirplaneEntity getByNoOfSeats(Integer noOfSeats) {
        AirplaneEntity airplaneEntity = airplaneRepo.getByNoOfSeats( noOfSeats);
        if (airplaneEntity != null) {
            System.out.println(" noOfSeats found\n" + airplaneEntity);
        }
        else {
            System.out.println(" noOfSeats not found");
        }
        return airplaneEntity;    }

    @Override
    public AirplaneEntity getByModel(String airplaneModel) {
        AirplaneEntity airplaneEntity = airplaneRepo.getByModel(airplaneModel);
        if (airplaneEntity != null) {
            System.out.println("airplaneModel found\n" + airplaneEntity);
        }
        else {
            System.out.println("airplaneModel not found");
        }
        return airplaneEntity;    }

    @Override
    public Integer updateByModel(String airplaneModel, Integer noOfSeats) {
        int rows=airplaneRepo.updateByModel(airplaneModel,noOfSeats);
        if (rows>0){
            System.out.println("noOfSeats is updated");
        }else {
            System.out.println("noOfSeats not updated");
        }return 0;    }

    @Override
    public Integer updateById(Integer airplaneId, Integer noOfSeats) {
        int rows=airplaneRepo.updateById(airplaneId, noOfSeats);
        if (rows>0){
            System.out.println("noOfSeats is updated");
        }else {
            System.out.println("noOfSeats not updated");
        }return 0;    }

    @Override
    public Integer deleteById(Integer airplaneId) {
        int rows = airplaneRepo.deleteById(airplaneId);
        if (rows > 0) {
            System.out.println("Country with ID " + airplaneId + " is deleted");
        } else {
            System.out.println("Country with ID " + airplaneId + " not found or not deleted");
        }
        return rows;    }

    @Override
    public List<AirplaneDto> getAllData() {
        List<AirplaneEntity> entities=airplaneRepo.getAllData();
        List<AirplaneDto> airplaneDtos =new ArrayList<>();
        if (entities != null) {
            for (AirplaneEntity entity : entities) {
                AirplaneDto dto = new AirplaneDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(airplaneDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                airplaneDtos.add(dto);
            }
        }
        return airplaneDtos;    }
}