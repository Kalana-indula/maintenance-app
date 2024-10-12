package com.myplant.maintenance.service;

import com.myplant.maintenance.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    //Create a new user
    User createUser(User user);

    //Get a list of all available users in the database
    List<User> findAllUsers();

    //Get a user by its id
    User findUserById(Long id);

    //Delete an available user
    Boolean deleteUser(Long id);
}
