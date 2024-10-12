package com.myplant.maintenance.service;

import com.myplant.maintenance.entity.User;
import com.myplant.maintenance.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        //Save user
        return userRepository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        //Getting available user list and return
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        //Find available user by id and return
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public Boolean deleteUser(Long id) {

        //Check if the user is existed
        boolean isExist=userRepository.existsById(id);

        if(isExist){
            userRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }
}
