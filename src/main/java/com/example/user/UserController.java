package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UserController {

    @Autowired
    UserService service;
    ArrayList<UserDetails> users=new ArrayList<>();

    @PostMapping (value = "/updateuser" )
    public ResponseEntity UpdateUser(@RequestBody UserDetails user) throws Exception {
        return service.updateExistingUser(user);
    }
    @PostMapping("/createuser")
    public ResponseEntity createUser(@RequestBody UserDetails user) throws Exception{
        return service.creatingUser(user);
    }


    @GetMapping(value = "/view/{id}")
    public ResponseEntity findUserById(@PathVariable int id){
        return service.getUserById(id);
    }

}
