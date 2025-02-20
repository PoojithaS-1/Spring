package com.xworkz.schoolapp.service;

import com.xworkz.schoolapp.dto.SchoolDto;
import com.xworkz.schoolapp.entity.SchoolEntity;
import com.xworkz.schoolapp.repository.SchoolRepo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
public class SchoolServiceImpl implements SchoolService{
@Autowired
    SchoolRepo schoolRepo;
    @Override
    public Boolean validateAndSave(SchoolDto schoolDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<SchoolDto>> validate = validator.validate(schoolDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            SchoolEntity schoolEntity = new SchoolEntity();
            try {
                BeanUtils.copyProperties(schoolEntity, schoolDto);
                System.out.println(schoolEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            schoolRepo.save(schoolEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public SchoolEntity getById(Integer schoolId) {
        SchoolEntity schoolEntity = schoolRepo.getById(schoolId);
        if (schoolEntity != null) {
            System.out.println(" id found\n" + schoolEntity);
        }
        else {
            System.out.println(" id not found");
        }
        return schoolEntity;     }

    @Override
    public SchoolEntity getByNoOfClassrooms(Integer noOfClassrooms) {
        SchoolEntity schoolEntity = schoolRepo.getByNoOfClassrooms( noOfClassrooms);
        if (schoolEntity != null) {
            System.out.println("noOfClassrooms found\n" + schoolEntity);
        }
        else {
            System.out.println("noOfClassrooms not found");
        }
        return schoolEntity;     }

    @Override
    public SchoolEntity getByName(String schoolName) {
        SchoolEntity schoolEntity = schoolRepo.getByName(schoolName);
        if (schoolEntity != null) {
            System.out.println("School name found\n" + schoolEntity);
        }
        else {
            System.out.println("School name not found");
        }
        return schoolEntity;
    }

    @Override
    public Integer updateByName(String schoolName, Integer noOfClassrooms) {
        int rows=schoolRepo.updateByName(schoolName,noOfClassrooms);
        if (rows>0){
            System.out.println("noOfClassrooms is updated");
        }else {
            System.out.println("noOfClassrooms not updated");
        }return 0;    }

    @Override
    public Integer updateById(Integer schoolId, Integer noOfClassrooms) {
        int rows=schoolRepo.updateById(schoolId, noOfClassrooms);
        if (rows>0){
            System.out.println("noOfClassrooms is updated");
        }else {
            System.out.println("noOfClassrooms not updated");
        }return 0;
    }

    @Override
    public Integer deleteById(Integer schoolId) {
        int rows = schoolRepo.deleteById(schoolId);
        if (rows > 0) {
            System.out.println("school with ID " + schoolId + " is deleted");
        } else {
            System.out.println("school with ID " + schoolId + " not found or not deleted");
        }
        return rows;    }

    @Override
    public List<SchoolDto> getAllData() {
        List<SchoolEntity> entities=schoolRepo.getAllData();
        List<SchoolDto> schoolDtos =new ArrayList<>();
        if (entities != null) {
            for (SchoolEntity entity : entities) {
                SchoolDto dto = new SchoolDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(schoolDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                schoolDtos.add(dto);
            }
        }
        return schoolDtos;
    }
}
