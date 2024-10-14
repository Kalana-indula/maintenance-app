package com.myplant.maintenance.controller;

import com.myplant.maintenance.entity.User;
import com.myplant.maintenance.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //Get all user details
    @GetMapping("/users")
    public ResponseEntity<?> getAllUsers(){
        try{

            List<User> users=userService.findAllUsers();

            return ResponseEntity.status(HttpStatus.OK).body(users);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //Find in individual user by id
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        try{
            User user=userService.findUserById(id);

            if(user!=null){
                return ResponseEntity.status(HttpStatus.OK).body(user);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //Updating user details
    @PutMapping("/update/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id,@RequestBody User user){
        try {
            User updatedUser=userService.updateUser(id,user);

            if(updatedUser!=null){
                return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    //Delete existing user
    @DeleteMapping("/delete/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        try {
            boolean isDeleted= userService.deleteUser(id);

            if(isDeleted){
                return ResponseEntity.status(HttpStatus.OK).body("User Deleted Successfully");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found");
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    

}
