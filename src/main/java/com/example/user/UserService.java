package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {



    static ArrayList<UserDetails> list_of_users=new ArrayList<>();
    ResponseEntity<UserDetails> getUserById(int userid){
        System.out.println("user");
        for(UserDetails user : list_of_users){
            if(user.id==userid){
                return new ResponseEntity(user,HttpStatus.OK);
            }
        }
        return new ResponseEntity(null,HttpStatus.NOT_FOUND);
    }
    boolean validateName(String name) {
        Pattern p=Pattern.compile("^[\\p{L} .'-]+$");
        Matcher m=p.matcher(name);
        return m.matches();
    }

    boolean validateEmail(String email){
        Pattern p=Pattern.compile("^(.+)@(.+)$");
        Matcher m=p.matcher(email);
        return m.matches();
    }

    ResponseEntity<UserDetails> creatingUser(UserDetails user) throws Exception {
            if (!validateName(user.name)|| !validateEmail(user.user_name)) {
                throw new Exception("name or user_name is invalid");
            }
            return new ResponseEntity(user, HttpStatus.OK);
    }
    ResponseEntity<UserDetails> updateExistingUser(UserDetails user) throws Exception {
        if(validateName(user.name)==false){
            //System.out.println("exception throwm");
            throw new Exception("name is invalid");
        }
        for(UserDetails users: list_of_users){
            if(users.id==user.id){
                users.name=user.name;
                return new ResponseEntity(users, HttpStatus.OK);
            }
        }
        return new ResponseEntity(null,HttpStatus.NOT_FOUND);
    }

    void addUser(UserDetails user){
        list_of_users.add(user);
    }



}
