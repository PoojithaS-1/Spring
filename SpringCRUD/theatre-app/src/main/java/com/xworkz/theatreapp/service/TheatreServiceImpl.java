package com.xworkz.theatreapp.service;

import com.xworkz.theatreapp.dto.TheatreDto;
import com.xworkz.theatreapp.entity.TheatreEntity;
import com.xworkz.theatreapp.repository.TheatreRepo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class TheatreServiceImpl implements TheatreService{
@Autowired
    TheatreRepo theatreRepo;
    @Override
    public Boolean validateAndSave(TheatreDto theatreDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<TheatreDto>> validate = validator.validate(theatreDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            TheatreEntity theatreEntity = new TheatreEntity();
            try {
                BeanUtils.copyProperties(theatreEntity, theatreDto);
                System.out.println(theatreEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            theatreRepo.save(theatreEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public TheatreEntity getById(Integer id) {
            TheatreEntity theatreEntity = theatreRepo.getById(id);
            if (theatreEntity != null) {
                System.out.println("Theatre id found\n" + theatreEntity);
            }
            else {
                System.out.println("Theatre id not found");
            }
            return theatreEntity;

        }

    @Override
    public TheatreEntity getByAmenities(String amenities) {
        TheatreEntity theatreEntity = theatreRepo.getByAmenities(amenities);
        if (theatreEntity != null) {
            System.out.println("Theatre amenities found\n" + theatreEntity);
        }
        else {
            System.out.println("Theatre amenities not found");
        }
        return theatreEntity;

    }

    @Override
    public TheatreEntity getByName(String name) {
        TheatreEntity theatreEntity = theatreRepo.getByName(name);
        if (theatreEntity != null) {
            System.out.println("Theatre name found\n" + theatreEntity);
        }
        else {
            System.out.println("Theatre name not found");
        }
        return theatreEntity;


    }

    @Override
    public Integer updateByName(String name, String amenities) {
        int rows=theatreRepo.updateByName(name, amenities);
        if (rows>0){
            System.out.println("amenities is updated");
        }else {
            System.out.println("amenities not updated");
        }return 0;
    }

    @Override
    public Integer updateById(Integer id, String amenities) {
        int rows=theatreRepo.updateById(id, amenities);
        if (rows>0){
            System.out.println("amenities is updated");
        }else {
            System.out.println("amenities not updated");
        }return 0;
    }

    @Override
    public Integer deleteById(Integer id) {
        int rows = theatreRepo.deleteById(id);
        if (rows > 0) {
            System.out.println("Theatre with ID " + id + " is deleted");
        } else {
            System.out.println("Theatre with ID " + id + " not found or not deleted");
        }
        return rows;
    }

    @Override
    public List<TheatreDto> getAllData() {
        List<TheatreEntity> entities=theatreRepo.getAllData();
        List<TheatreDto> theatreDtos =new ArrayList<>();
        if (entities != null) {
            for (TheatreEntity entity : entities) {
                TheatreDto dto = new TheatreDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(theatreDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                theatreDtos.add(dto);
            }
        }
        return theatreDtos;

    }
}

