package com.hutech.bai_1.Services;


import com.hutech.bai_1.Entities.User;
import com.hutech.bai_1.Repositories.UserRepository;
import com.hutech.bai_1.RequestEntities.UserCreate;
import com.hutech.bai_1.RequestEntities.UserUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        return userRepository.findById(id).orElseThrow(
                () -> {
                    throw  new RuntimeException("Khong tim thay ID");
                }
        );
    }

    public User createUser(UserCreate userCreate){
        try{
            User user = new User();
            user.setUsername(userCreate.getUsername());
            user.setFirstName(userCreate.getFirstName());
            user.setLastName(userCreate.getLastName());
            user.setEmail(userCreate.getEmail());
            user.setPassword(userCreate.getPassword());//yyyy-MM-dd
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthDay(dateFormat.parse(userCreate.getBirthDay()));
            user.setRole(userCreate.getRole());
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }

    public User Updateuser(UserUpdate userUpdate){
        try{
            User user = getUserById(userUpdate.getID());
            user.setUsername(userUpdate.getUsername());
            user.setFirstName(userUpdate.getFirstName());
            user.setLastName(userUpdate.getLastName());
            user.setEmail(userUpdate.getEmail());
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthDay(dateFormat.parse(userUpdate.getBirthDay()));
            userRepository.save(user);
            return user;
        }catch (Exception e){
            throw  new RuntimeException(e.getMessage());
        }
    }
}
