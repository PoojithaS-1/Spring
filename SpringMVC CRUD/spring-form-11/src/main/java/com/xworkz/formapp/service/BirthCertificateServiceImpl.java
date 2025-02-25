package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.BirthCertificateDto;
import com.xworkz.formapp.entity.BirthCertificateEntity;
import com.xworkz.formapp.repository.BirthCertificateRepository;
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
public class BirthCertificateServiceImpl implements BirthCertificateService {
    @Autowired
    BirthCertificateRepository birthCertificateRepository;

    @Override
    public Boolean validateAndSave(BirthCertificateDto birthCertificateDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<BirthCertificateDto>> validate = validator.validate(birthCertificateDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            BirthCertificateEntity birthCertificateEntity = new BirthCertificateEntity();
            try {
                BeanUtils.copyProperties(birthCertificateEntity, birthCertificateDto);
                System.out.println(birthCertificateEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            birthCertificateRepository.save(birthCertificateEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<BirthCertificateDto> getAllApplicantInfo() {
        List<BirthCertificateEntity> entities = birthCertificateRepository.getAllApplicantInfo();
        List<BirthCertificateDto> birthCertificateDtos = new ArrayList<>();
        if (entities != null) {
            for (BirthCertificateEntity entity : entities) {
                BirthCertificateDto dto = new BirthCertificateDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(birthCertificateDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                birthCertificateDtos.add(dto);
            }
        }
        return birthCertificateDtos;

    }
    @Override
    public void deleteById(int id) {
        birthCertificateRepository.deleteById(id);
        if (birthCertificateRepository != null) {
            birthCertificateRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}