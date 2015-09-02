package com.hj.restdemo.rest;

import com.hj.restdemo.db.AbstractEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by heiko on 02.09.15.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {


    public ResourceNotFoundException(Class entityClass, Long id) {
        super("The resoource " + entityClass.getSimpleName() + " was not found for id " + id);
    }



}
