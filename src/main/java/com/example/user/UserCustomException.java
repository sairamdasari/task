package com.example.user;

public class UserCustomException extends RuntimeException{
    UserCustomException(){

    }
    UserCustomException(String message){
        super(message);
    }
}
