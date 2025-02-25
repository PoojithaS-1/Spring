package com.xworkz.edutechapp.service;

import com.xworkz.edutechapp.dto.EduTechDto;
import com.xworkz.edutechapp.entity.EduTechEntity;
import com.xworkz.edutechapp.repository.EdutechRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

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
public class EduTechServiceImpl implements EduTechService {
    @Autowired
    EdutechRepository edutechRepository;

    @Override
    public Boolean validateAndSave(EduTechDto eduTechDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<EduTechDto>> validate = validator.validate(eduTechDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            EduTechEntity eduTechEntity = new EduTechEntity();
            try {
                BeanUtils.copyProperties(eduTechEntity, eduTechDto);
                System.out.println(eduTechEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            edutechRepository.save(eduTechEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<EduTechDto> getAllTraineeInfo() {
        List<EduTechEntity> entities = edutechRepository.getAllTraineeInfo();
        List<EduTechDto> eduTechDtos = new ArrayList<>();
        if (entities != null) {
            for (EduTechEntity entity : entities) {
                EduTechDto dto = new EduTechDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(eduTechDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                eduTechDtos.add(dto);
            }
        }
        return eduTechDtos;
    }

    @Override
    public void deleteById(Integer id) {
        edutechRepository.deleteById(id);
        if (edutechRepository != null) {
            edutechRepository.deleteById(id);
            System.out.println("Trainee Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Trainee Info with id " + id + " not found");
        }
    }
}
