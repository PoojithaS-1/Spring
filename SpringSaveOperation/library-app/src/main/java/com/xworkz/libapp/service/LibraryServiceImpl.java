package com.xworkz.libapp.service;

import com.xworkz.libapp.dto.LibDto;
import com.xworkz.libapp.entity.LibEntity;
import com.xworkz.libapp.repository.LibraryRepo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

@Component
public class LibraryServiceImpl implements LibraryService{
@Autowired
    LibraryRepo libraryRepo;
    @Override
    public Boolean validateAndSave(LibDto libDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<LibDto>> validate = validator.validate(libDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            LibEntity libEntity = new LibEntity();
            try {
                BeanUtils.copyProperties(libEntity, libDto);
                System.out.println(libEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            libraryRepo.save(libEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}