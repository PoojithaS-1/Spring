package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.PassportRegDto;
import com.xworkz.formapp.entity.PassportRegEntity;
import com.xworkz.formapp.repository.PassportRegRepository;
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
public class PassportRegServiceImpl implements PassportRegService {
@Autowired
    PassportRegRepository passportRegRepository;
    @Override
    public Boolean validateAndSave(PassportRegDto passportRegDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<PassportRegDto>> validate = validator.validate(passportRegDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            PassportRegEntity passportRegEntity = new PassportRegEntity();
            try {
                BeanUtils.copyProperties(passportRegEntity, passportRegDto);
                System.out.println(passportRegEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            passportRegRepository.save(passportRegEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<PassportRegDto> getAllApplicantInfo() {
        List<PassportRegEntity> entities = passportRegRepository.getAllApplicantInfo();
        List<PassportRegDto> passportRegDtoList = new ArrayList<>();
        if (entities != null) {
            for (PassportRegEntity entity : entities) {
                PassportRegDto dto = new PassportRegDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(passportRegDtoList);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                passportRegDtoList.add(dto);
            }
        }
        return passportRegDtoList;

    }
    @Override
    public void deleteById(int id) {
        passportRegRepository.deleteById(id);
        if (passportRegRepository != null) {
            passportRegRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}