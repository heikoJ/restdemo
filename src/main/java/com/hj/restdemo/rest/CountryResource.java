package com.hj.restdemo.rest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by heiko on 02.09.15.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class CountryResource extends ResourceSupport {


    private String code;
    private String name;


}
