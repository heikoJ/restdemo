package com.hj.restdemo.rest;

import com.hj.restdemo.common.ResourceAssembler;
import com.hj.restdemo.db.Location;
import org.springframework.stereotype.Component;

/**
 * Created by heiko on 02.09.15.
 */
@Component
public class LocationResourceAssembler extends ResourceAssembler<Location,LocationResource> {

    public LocationResourceAssembler() {
        super(LocationController.class, LocationResource.class);
    }
}
