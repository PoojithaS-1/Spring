package com.xworkz.userapp.service;

import com.xworkz.userapp.dto.UserDto;
import com.xworkz.userapp.entity.UserEntity;
import com.xworkz.userapp.repository.UserRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public Boolean validateAndSaveUser(UserDto userDto) {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<UserDto>> validate = validator.validate(userDto);
        if (!validate.isEmpty()) {
            validate.stream().forEach(error -> System.out.println(error.getMessage()));
        } else {
            UserEntity userEntity = new UserEntity();
            try {
                BeanUtils.copyProperties(userEntity, userDto);
                System.out.println(userEntity);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.out.println(e.getMessage());
            }
            userRepository.saveUser(userEntity);
            System.out.println("All fields are validated and saved");
        }
        return null;
    }
    @Override
    public List<UserDto> getAllUserInfo() {
        List<UserEntity> entities=userRepository.getAllUserInfo();
        List<UserDto> userDtos =new ArrayList<>();
        if (entities != null) {
            for (UserEntity entity : entities) {
                UserDto dto = new UserDto();
                try {
                    BeanUtils.copyProperties(dto, entity);
                    System.out.println(userDtos);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                userDtos.add(dto);
            }
        }
        return userDtos;

    }

    @Override
    public void deleteById(Integer id) {
            userRepository.deleteById(id);
            if (userRepository != null) {
                userRepository.deleteById(id);
                System.out.println("User Info with id " + id + " deleted successfully");
            } else {
                System.out.println("User Info with id " + id + " not found");
            }
        }


}
