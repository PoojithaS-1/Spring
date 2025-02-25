package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.VisaApplyDto;
import com.xworkz.formapp.entity.VisaApplyEntity;
import com.xworkz.formapp.repository.VisaApplyRepository;
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
public class VisaApplyServiceImpl implements VisaApplyService {
@Autowired
    VisaApplyRepository visaApplyRepository;
    @Override
    public Boolean validateAndSave(VisaApplyDto visaApplyDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<VisaApplyDto>> validate = validator.validate(visaApplyDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            VisaApplyEntity visaApplyEntity = new VisaApplyEntity();
            try {
                BeanUtils.copyProperties(visaApplyEntity, visaApplyDto);
                System.out.println(visaApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            visaApplyRepository.save(visaApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<VisaApplyDto> getAllApplicantInfo() {
        List<VisaApplyEntity> entities = visaApplyRepository.getAllApplicantInfo();
        List<VisaApplyDto> visaApplyDtoList = new ArrayList<>();
        if (entities != null) {
            for (VisaApplyEntity entity : entities) {
                VisaApplyDto dto = new VisaApplyDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(visaApplyDtoList);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                visaApplyDtoList.add(dto);
            }
        }
        return visaApplyDtoList;

    }
    @Override
    public void deleteById(int id) {
        visaApplyRepository.deleteById(id);
        if (visaApplyRepository != null) {
            visaApplyRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}