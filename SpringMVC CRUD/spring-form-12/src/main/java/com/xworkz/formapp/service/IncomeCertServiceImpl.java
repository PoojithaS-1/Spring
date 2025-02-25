package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.IncomeCertDto;
import com.xworkz.formapp.entity.IncomeCertificateEntity;
import com.xworkz.formapp.repository.IncomeCertRepository;
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
public class IncomeCertServiceImpl implements IncomeCertService{
    @Autowired
    IncomeCertRepository incomeCertRepository;
    @Override
    public Boolean validateAndSave(IncomeCertDto incomeCertDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<IncomeCertDto>> validate = validator.validate(incomeCertDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            IncomeCertificateEntity incomeCertEntity = new IncomeCertificateEntity();
            try {
                BeanUtils.copyProperties(incomeCertEntity, incomeCertDto);
                System.out.println(incomeCertEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            incomeCertRepository.save(incomeCertEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<IncomeCertDto> getAllApplicantInfo() {
        List<IncomeCertificateEntity> entities=incomeCertRepository.getAllApplicantInfo();
        List<IncomeCertDto> incomeCertDtos =new ArrayList<>();
        if (entities != null) {
            for (IncomeCertificateEntity entity : entities) {
                IncomeCertDto dto = new IncomeCertDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(incomeCertDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                incomeCertDtos.add(dto);
            }
        }
        return incomeCertDtos;

    }
    @Override
    public void deleteById(int id) {
        incomeCertRepository.deleteById(id);
        if (incomeCertRepository != null) {
            incomeCertRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}
