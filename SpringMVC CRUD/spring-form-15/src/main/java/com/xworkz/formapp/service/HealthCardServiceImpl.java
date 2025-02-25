package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.HealthCardDto;
import com.xworkz.formapp.entity.HealthCardEntity;
import com.xworkz.formapp.repository.HealthCardRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class HealthCardServiceImpl implements HealthCardService{
    @Autowired
    HealthCardRepository healthCardRepository;
    @Override
    public Boolean validateAndSave(HealthCardDto healthCardDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<HealthCardDto>> validate = validator.validate(healthCardDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            HealthCardEntity healthCardEntity = new HealthCardEntity();
            try {
                BeanUtils.copyProperties(healthCardEntity, healthCardDto);
                System.out.println(healthCardEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            healthCardRepository.save(healthCardEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<HealthCardDto> getAllApplicantInfo() {
        List<HealthCardEntity> entities=healthCardRepository.getAllApplicantInfo();
        List<HealthCardDto> healthCardDtos =new ArrayList<>();
        if (entities != null) {
            for (HealthCardEntity entity : entities) {
                HealthCardDto dto = new HealthCardDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(healthCardDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                healthCardDtos.add(dto);
            }
        }
        return healthCardDtos;

    }

    @Override
    public void deleteById(Integer id) {
        healthCardRepository.deleteById(id);
        if (healthCardRepository != null) {
            healthCardRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}
