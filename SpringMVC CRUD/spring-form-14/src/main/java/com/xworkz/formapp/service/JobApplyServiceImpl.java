package com.xworkz.formapp.service;

import com.xworkz.formapp.dto.JobApplyDto;
import com.xworkz.formapp.entity.JobApplyEntity;
import com.xworkz.formapp.repository.JobApplyRepository;
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
public class JobApplyServiceImpl implements JobApplyService{
    @Autowired
    JobApplyRepository jobApplyRepository;
    @Override
    public Boolean validateAndSave(JobApplyDto jobApplyDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<JobApplyDto>> validate = validator.validate(jobApplyDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            JobApplyEntity jobApplyEntity = new JobApplyEntity();
            try {
                BeanUtils.copyProperties(jobApplyEntity, jobApplyDto);
                System.out.println(jobApplyEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            jobApplyRepository.save(jobApplyEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<JobApplyDto> getAllApplicantInfo() {
        List<JobApplyEntity> entities=jobApplyRepository.getAllApplicantInfo();
        List<JobApplyDto> jobApplyDtos =new ArrayList<>();
        if (entities != null) {
            for (JobApplyEntity entity : entities) {
                JobApplyDto dto = new JobApplyDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(jobApplyDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                jobApplyDtos.add(dto);
            }
        }
        return jobApplyDtos;

    }
    @Override
    public void deleteById(int id) {
        jobApplyRepository.deleteById(id);
        if (jobApplyRepository != null) {
            jobApplyRepository.deleteById(id);
            System.out.println("Applicant Info with id " + id + " deleted successfully");
        } else {
            System.out.println("Applicant Info with id " + id + " not found");
        }
    }

}
