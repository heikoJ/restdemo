package com.hj.restdemo.rest;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by heiko on 02.09.15.
 */
@Data
public class ServiceResource extends ResourceSupport {

    private String name;

}
