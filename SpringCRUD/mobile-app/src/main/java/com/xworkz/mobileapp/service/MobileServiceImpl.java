package com.xworkz.mobileapp.service;

import com.xworkz.mobileapp.dto.MobileDto;
import com.xworkz.mobileapp.entity.MobileEntity;
import com.xworkz.mobileapp.repository.MobileRepo;
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
public class MobileServiceImpl implements MobileService{
@Autowired
    MobileRepo mobileRepo;
    @Override
    public Boolean validateAndSave(MobileDto mobileDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<MobileDto>> validate = validator.validate(mobileDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            MobileEntity mobileEntity = new MobileEntity();
            try {
                BeanUtils.copyProperties(mobileEntity, mobileDto);
                System.out.println(mobileEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            mobileRepo.save(mobileEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }

    @Override
    public List<MobileDto> getAllData() {
        List<MobileEntity> entities=mobileRepo.getAllData();
        List<MobileDto> mobileDtos =new ArrayList<>();
        if (entities != null) {
            for (MobileEntity entity : entities) {
                MobileDto dto = new MobileDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(mobileDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                mobileDtos.add(dto);
            }
        }
        return mobileDtos;

      }

    @Override
    public MobileEntity getById(Integer id) {
        MobileEntity mobileEntity = mobileRepo.getById(id);
        if (mobileEntity != null) {
            System.out.println("Mobile id found\n" + mobileEntity);
        }
        else {
            System.out.println("Mobile id not found");
        }
        return mobileEntity;

    }

    @Override
    public MobileEntity getByModel(String model) {
            MobileEntity mobileEntity = mobileRepo.getByModel(model);
        if (mobileEntity != null) {
            System.out.println("Theatre Model found\n" + mobileEntity);
        }
        else {
            System.out.println("Theatre Model not found");
        }
        return mobileEntity;    }

    @Override
    public MobileEntity getByBrand(String brand) {
        MobileEntity mobileEntity = mobileRepo.getByBrand(brand);
        if (mobileEntity != null) {
            System.out.println("Theatre brand found\n" + mobileEntity);
        }
        else {
            System.out.println("Theatre brand not found");
        }
        return mobileEntity;
    }

    @Override
    public Integer updateByBrand(String brand, String model) {
        int rows=mobileRepo.updateByBrand(brand, model);
        if (rows>0){
            System.out.println("model is updated");
        }else {
            System.out.println("model not updated");
        }return 0;    }

    @Override
    public Integer updateById(Integer id, String model) {
        int rows=mobileRepo.updateById(id,model);
        if (rows>0){
            System.out.println("model is updated");
        }else {
            System.out.println("model not updated");
        }return 0;
    }

    @Override
    public Integer deleteById(Integer id) {
        int rows = mobileRepo.deleteById(id);
        if (rows > 0) {
            System.out.println("Mobile with ID " + id + " is deleted");
        } else {
            System.out.println("Mobile with ID " + id + " not found or not deleted");
        }
        return rows;
    }
}
