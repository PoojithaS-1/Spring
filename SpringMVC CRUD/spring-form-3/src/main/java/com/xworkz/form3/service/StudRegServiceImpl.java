package com.xworkz.form3.service;

import com.xworkz.form3.dto.StudRegDto;
import com.xworkz.form3.entity.StudRegEntity;
import com.xworkz.form3.repository.StudRegRepository;
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
public class StudRegServiceImpl implements StudRegService{
    @Autowired
    StudRegRepository studRegRepository;
    @Override
    public Boolean validateAndSave(StudRegDto studRegDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<StudRegDto>> validate = validator.validate(studRegDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            StudRegEntity studRegEntity = new StudRegEntity();
            try {
                BeanUtils.copyProperties(studRegEntity, studRegDto);
                System.out.println(studRegEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            studRegRepository.save(studRegEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<StudRegDto> getAllStudInfo() {
        List<StudRegEntity> entities=studRegRepository.getAllStudInfo();
        List<StudRegDto> studRegDtoList =new ArrayList<>();
        if (entities != null) {
            for (StudRegEntity entity : entities) {
                StudRegDto dto = new StudRegDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(studRegDtoList);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                studRegDtoList.add(dto);
            }
        }
        return studRegDtoList;
    }
    @Override
    public void deleteById(int id) {
        studRegRepository.deleteById(id);
        if (studRegRepository != null) {
            studRegRepository.deleteById(id);
            System.out.println("Student Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Student Info with id " + id + " not found");
        }
    }
}
