package com.hj.restdemo.rest;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by heiko on 02.09.15.
 */
@Data
public class LocationResource extends ResourceSupport {
    private String code;
    private String name;
}
