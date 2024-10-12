package com.myplant.maintenance.controller;

import com.myplant.maintenance.entity.User;
import com.myplant.maintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //Creating a user
    @PostMapping("/create/users")
    public ResponseEntity<?> createUser(@RequestBody User user){
        try{
            User newUser=userService.createUser(user);

            return ResponseEntity.status(HttpStatus.OK).body(newUser);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/users")
    //Get all user details
    public ResponseEntity<?> getAllUsers(){
        try{

            List<User> users=userService.findAllUsers();

            return ResponseEntity.status(HttpStatus.OK).body(users);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
