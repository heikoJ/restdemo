package com.hj.restdemo.rest;

import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by heiko on 02.09.15.
 */
@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
public class MethodNotAllowedException extends RuntimeException {

    public MethodNotAllowedException(Class entityClass, RequestMethod method) {
        super("The method " + method.name() + " is not allowed for resource " + entityClass.getSimpleName());
    }
}
