package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.RationCardDto;
import com.xworkz.formapp.entity.RationCardEntity;
import com.xworkz.formapp.repository.RationCardRepository;
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
public class RationCardServiceImpl implements RationCardService{
    @Autowired
    RationCardRepository rationCardRepository;
    @Override
    public Boolean validateAndSave(RationCardDto rationCardDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<RationCardDto>> validate = validator.validate(rationCardDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            RationCardEntity rationCardEntity = new RationCardEntity();
            try {
                BeanUtils.copyProperties(rationCardEntity, rationCardDto);
                System.out.println(rationCardEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            rationCardRepository.save(rationCardEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<RationCardDto> getAllApplicantInfo() {
        List<RationCardEntity> entities=rationCardRepository.getAllApplicantInfo();
        List<RationCardDto> rationCardDtos =new ArrayList<>();
        if (entities != null) {
            for (RationCardEntity entity : entities) {
                RationCardDto dto = new RationCardDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(rationCardDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                rationCardDtos.add(dto);
            }
        }
        return rationCardDtos;

    }
    @Override
    public void deleteById(int id) {
        rationCardRepository.deleteById(id);
        if (rationCardRepository != null) {
            rationCardRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}
