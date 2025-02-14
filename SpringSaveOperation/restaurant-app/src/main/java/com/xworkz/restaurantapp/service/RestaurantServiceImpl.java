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
}