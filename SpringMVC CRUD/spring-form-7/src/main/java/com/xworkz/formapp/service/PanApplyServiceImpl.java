package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.PanApplyDto;
import com.xworkz.formapp.entity.PanApplyEntity;
import com.xworkz.formapp.repository.PanApplyRepository;
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
public class PanApplyServiceImpl implements PanApplyService{
    @Autowired
    PanApplyRepository panApplyRepository;
    @Override
    public Boolean validateAndSave(PanApplyDto panApplyDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<PanApplyDto>> validate = validator.validate(panApplyDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            PanApplyEntity panApplyEntity = new PanApplyEntity();
            try {
                BeanUtils.copyProperties(panApplyEntity, panApplyDto);
                System.out.println(panApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            panApplyRepository.save(panApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<PanApplyDto> getAllApplicantInfo() {
        List<PanApplyEntity> entities=panApplyRepository.getAllApplicantInfo();
        List<PanApplyDto> panApplyDtoList =new ArrayList<>();
        if (entities != null) {
            for (PanApplyEntity entity : entities) {
                PanApplyDto dto = new PanApplyDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(panApplyDtoList);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                panApplyDtoList.add(dto);
            }
        }
        return panApplyDtoList;

    }
    @Override
    public void deleteById(int id) {
        panApplyRepository.deleteById(id);
        if (panApplyRepository != null) {
            panApplyRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}
