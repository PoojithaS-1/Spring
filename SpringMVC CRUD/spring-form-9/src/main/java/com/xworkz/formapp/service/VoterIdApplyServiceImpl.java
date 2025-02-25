package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.VoterIdApplyDto;
import com.xworkz.formapp.entity.VoterIdApplyEntity;
import com.xworkz.formapp.repository.VoterIdApplyRepository;
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
public class VoterIdApplyServiceImpl implements VoterIdApplyService{
    @Autowired
    VoterIdApplyRepository voterIdApplyRepository;
    @Override
    public Boolean validateAndSave(VoterIdApplyDto voterIdApplyDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<VoterIdApplyDto>> validate = validator.validate(voterIdApplyDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            VoterIdApplyEntity voterIdApplyEntity = new VoterIdApplyEntity();
            try {
                BeanUtils.copyProperties(voterIdApplyEntity, voterIdApplyDto);
                System.out.println(voterIdApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            voterIdApplyRepository.save(voterIdApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<VoterIdApplyDto> getAllApplicantInfo() {
        List<VoterIdApplyEntity> entities=voterIdApplyRepository.getAllApplicantInfo();
        List<VoterIdApplyDto> voterIdApplyDtos =new ArrayList<>();
        if (entities != null) {
            for (VoterIdApplyEntity entity : entities) {
                VoterIdApplyDto dto = new VoterIdApplyDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(voterIdApplyDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                voterIdApplyDtos.add(dto);
            }
        }
        return voterIdApplyDtos;

    }
    @Override
    public void deleteById(int id) {
        voterIdApplyRepository.deleteById(id);
        if (voterIdApplyRepository != null) {
            voterIdApplyRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }
}
