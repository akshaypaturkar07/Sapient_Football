package com.sapient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class EntityNotExistException extends Exception{
    public EntityNotExistException(String s){
        super(s);
    }
}
