package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.ScholarshipDto;
import com.xworkz.formapp.entity.ScholarshipEntity;
import com.xworkz.formapp.repository.ScholarshipRepository;
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
public class ScholarshipServiceImpl implements ScholarshipService{
    @Autowired
    ScholarshipRepository scholarshipRepository;
    @Override
    public Boolean validateAndSave(ScholarshipDto scholarshipDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<ScholarshipDto>> validate = validator.validate(scholarshipDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            ScholarshipEntity scholarshipEntity = new ScholarshipEntity();
            try {
                BeanUtils.copyProperties(scholarshipEntity, scholarshipDto);
                System.out.println(scholarshipEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            scholarshipRepository.save(scholarshipEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<ScholarshipDto> getAllApplicantInfo() {
        List<ScholarshipEntity> entities=scholarshipRepository.getAllApplicantInfo();
        List<ScholarshipDto> scholarshipDtos =new ArrayList<>();
        if (entities != null) {
            for (ScholarshipEntity entity : entities) {
                ScholarshipDto dto = new ScholarshipDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(scholarshipDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                scholarshipDtos.add(dto);
            }
        }
        return scholarshipDtos;

    }
    @Override
    public void deleteById(int id) {
        scholarshipRepository.deleteById(id);
        if (scholarshipRepository != null) {
            scholarshipRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}
