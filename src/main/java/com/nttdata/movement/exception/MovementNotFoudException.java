package com.nttdata.movement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovementNotFoudException extends RuntimeException{

    public  MovementNotFoudException(String id){
        super(String.format("Movement with %s not foud.",id));
    }
}
