package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.AadharApplyDto;
import com.xworkz.formapp.entity.AadharApplyEntity;
import com.xworkz.formapp.repository.AadharApplyRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class AadharApplyServiceImpl implements AadharApplyService{
    @Autowired
    AadharApplyRepository aadharApplyRepository;
    @Override
    public Boolean validateAndSave(AadharApplyDto aadharApplyDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<AadharApplyDto>> validate = validator.validate(aadharApplyDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            AadharApplyEntity aadharApplyEntity = new AadharApplyEntity();
            try {
                BeanUtils.copyProperties(aadharApplyEntity, aadharApplyDto);
                System.out.println(aadharApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            aadharApplyRepository.save(aadharApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<AadharApplyDto> getAllApplicantInfo() {
        List<AadharApplyEntity> entities=aadharApplyRepository.getAllApplicantInfo();
        List<AadharApplyDto> aadharApplyDtoList =new ArrayList<>();
        if (entities != null) {
            for (AadharApplyEntity entity : entities) {
                AadharApplyDto dto = new AadharApplyDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(aadharApplyDtoList);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                aadharApplyDtoList.add(dto);
            }
        }
        return aadharApplyDtoList;

    }
    @Override
    public void deleteById(int id) {
        aadharApplyRepository.deleteById(id);
        if (aadharApplyRepository != null) {
            aadharApplyRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }

}
