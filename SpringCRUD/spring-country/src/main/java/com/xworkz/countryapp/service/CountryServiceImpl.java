package com.xworkz.countryapp.service;

import com.xworkz.countryapp.dto.CountryDto;
import com.xworkz.countryapp.entity.CountryEntity;
import com.xworkz.countryapp.repository.CountryRepository;
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
public class CountryServiceImpl implements CountryService {
    @Autowired
    CountryRepository countryRepository;
    @Override
    public Boolean validateAndSave(CountryDto countryDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<CountryDto>> validate = validator.validate(countryDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            CountryEntity countryEntity = new CountryEntity();
            try {
                BeanUtils.copyProperties(countryEntity, countryDto);
                System.out.println(countryEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            countryRepository.save(countryEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
    @Override
    public CountryEntity getById(Integer countryId) {
        CountryEntity countryEntity = countryRepository.getById(countryId);
        if (countryEntity != null) {
            System.out.println("Country id found\n" + countryEntity);
        }
        else {
            System.out.println("Country id not found");
        }
        return countryEntity;

    }

    @Override
    public CountryEntity getByNoOfStates(Integer noOfStates) {
        CountryEntity countryEntity = countryRepository.getByNoOfStates( noOfStates);
        if (countryEntity != null) {
            System.out.println("country noOfStates found\n" + countryEntity);
        }
        else {
            System.out.println("country noOfStates not found");
        }
        return countryEntity;

    }

    @Override
    public CountryEntity getByName(String countryName) {
        CountryEntity countryEntity = countryRepository.getByName(countryName);
        if (countryEntity != null) {
            System.out.println("Country name found\n" + countryEntity);
        }
        else {
            System.out.println("Country name not found");
        }
        return countryEntity;


    }

    @Override
    public Integer updateByName(String countryName,Integer noOfStates ) {
        int rows=countryRepository.updateByName(countryName,noOfStates);
        if (rows>0){
            System.out.println("noOfStates is updated");
        }else {
            System.out.println("noOfStates not updated");
        }return 0;
    }

    @Override
    public Integer updateById(Integer countryId, Integer noOfStates ) {
        int rows=countryRepository.updateById(countryId, noOfStates);
        if (rows>0){
            System.out.println("noOfStates is updated");
        }else {
            System.out.println("noOfStates not updated");
        }return 0;
    }

    @Override
    public Integer deleteById(Integer countryId) {
        int rows = countryRepository.deleteById(countryId);
        if (rows > 0) {
            System.out.println("Country with ID " + countryId + " is deleted");
        } else {
            System.out.println("Country with ID " + countryId + " not found or not deleted");
        }
        return rows;
    }

    @Override
    public List<CountryDto> getAllData() {
        List<CountryEntity> entities=countryRepository.getAllData();
        List<CountryDto> countryDtos =new ArrayList<>();
        if (entities != null) {
            for (CountryEntity entity : entities) {
                CountryDto dto = new CountryDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(countryDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                countryDtos.add(dto);
            }
        }
        return countryDtos;

    }
}
