package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.DLApplyDto;
import com.xworkz.formapp.entity.DLApplyEntity;
import com.xworkz.formapp.repository.DLApplyRepository;
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
public class DLApplyServiceImpl implements DLApplyService{
    @Autowired
    DLApplyRepository dlApplyRepository;
    @Override
    public Boolean validateAndSave(DLApplyDto dlApplyDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<DLApplyDto>> validate = validator.validate(dlApplyDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            DLApplyEntity dlApplyEntity = new DLApplyEntity();
            try {
                BeanUtils.copyProperties(dlApplyEntity, dlApplyDto);
                System.out.println(dlApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            dlApplyRepository.save(dlApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<DLApplyDto> getAllApplicantInfo() {
        List<DLApplyEntity> entities = dlApplyRepository.getAllApplicantInfo();
        List<DLApplyDto> dlApplyDtoList = new ArrayList<>();
        if (entities != null) {
            for (DLApplyEntity entity : entities) {
                DLApplyDto dto = new DLApplyDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(dlApplyDtoList);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                dlApplyDtoList.add(dto);
            }
        }
        return dlApplyDtoList;

    }
    @Override
    public void deleteById(int id) {
        dlApplyRepository.deleteById(id);
        if (dlApplyRepository != null) {
            dlApplyRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}
