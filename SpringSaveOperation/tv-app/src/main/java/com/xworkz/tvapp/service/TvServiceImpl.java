package com.xworkz.tvapp.service;

import com.xworkz.tvapp.dto.TvDto;
import com.xworkz.tvapp.entity.TvEntity;
import com.xworkz.tvapp.repository.TvRepository;
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
public class TvServiceImpl implements TvService{
@Autowired
    TvRepository tvRepository;
    @Override
    public Boolean validateAndSave(TvDto tvDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<TvDto>> validate = validator.validate(tvDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            TvEntity tvEntity = new TvEntity();
            try {
                BeanUtils.copyProperties(tvEntity, tvDto);
                System.out.println(tvEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            tvRepository.save(tvEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
}
