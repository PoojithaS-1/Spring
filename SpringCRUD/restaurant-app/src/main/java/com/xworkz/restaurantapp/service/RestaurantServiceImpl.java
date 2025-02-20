package com.xworkz.restaurantapp.service;

import com.xworkz.restaurantapp.dto.RestaurantDto;
import com.xworkz.restaurantapp.entity.RestaurantEntity;
import com.xworkz.restaurantapp.repository.RestaurantRepo;
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
public class RestaurantServiceImpl implements RestaurantService{
@Autowired
    RestaurantRepo restaurantRepo;
    @Override
    public Boolean validateAndSave(RestaurantDto restaurantDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RestaurantDto>> validate = validator.validate(restaurantDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            RestaurantEntity restaurantEntity = new RestaurantEntity();
            try {
                BeanUtils.copyProperties(restaurantEntity, restaurantDto);
                System.out.println(restaurantEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            restaurantRepo.save(restaurantEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
    @Override
    public RestaurantEntity getById(Integer restaurantId) {
        RestaurantEntity restaurantEntity = restaurantRepo.getById(restaurantId);
        if (restaurantEntity != null) {
            System.out.println("restaurantId found\n" + restaurantEntity);
        }
        else {
            System.out.println("restaurantId not found");
        }
        return restaurantEntity;

    }

    @Override
    public RestaurantEntity getByNoOfTabels(Integer noOfTables) {
        RestaurantEntity restaurantEntity = restaurantRepo.getByNoOfTabels( noOfTables);
        if (restaurantEntity != null) {
            System.out.println("noOfTabels found\n" + restaurantEntity);
        }
        else {
            System.out.println("noOfTabels not found");
        }
        return restaurantEntity;

    }

    @Override
    public RestaurantEntity getByName(String restaurantName) {
        RestaurantEntity restaurantEntity = restaurantRepo.getByName(restaurantName);
        if (restaurantEntity != null) {
            System.out.println("restaurantName found\n" + restaurantEntity);
        }
        else {
            System.out.println("restaurantName not found");
        }
        return restaurantEntity;


    }

    @Override
    public Integer updateByName(String restaurantName,Integer noOfTables ) {
        int rows=restaurantRepo.updateByName( restaurantName, noOfTables );
        if (rows>0){
            System.out.println("noOfTabels is updated");
        }else {
            System.out.println("noOfTabels not updated");
        }return 0;
    }

    @Override
    public Integer updateById(Integer restaurantId, Integer noOfTables ) {
        int rows=restaurantRepo.updateById(restaurantId, noOfTables);
        if (rows>0){
            System.out.println("noOfTabels is updated");
        }else {
            System.out.println("noOfTabels not updated");
        }return 0;
    }

    @Override
    public Integer deleteById(Integer restaurantId) {
        int rows = restaurantRepo.deleteById(restaurantId);
        if (rows > 0) {
            System.out.println("restaurant with ID " + restaurantId + " is deleted");
        } else {
            System.out.println("restaurant with ID " + restaurantId + " not found or not deleted");
        }
        return rows;
    }

    @Override
    public List<RestaurantDto> getAllData() {
        List<RestaurantEntity> entities=restaurantRepo.getAllData();
        List<RestaurantDto> restaurantDtos =new ArrayList<>();
        if (entities != null) {
            for (RestaurantEntity entity : entities) {
                RestaurantDto dto = new RestaurantDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(restaurantDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                restaurantDtos.add(dto);
            }
        }
        return restaurantDtos;

    }
}