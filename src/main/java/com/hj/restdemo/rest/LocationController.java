package com.hj.restdemo.rest;

import com.hj.restdemo.common.ResourceAssembler;
import com.hj.restdemo.db.Location;
import com.hj.restdemo.db.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by heiko on 02.09.15.
 */
@RestController
@RequestMapping("/rest/locations")
public class LocationController extends AbstractController<Location,LocationResource,LocationRepository> {

    @Autowired
    public LocationController(LocationResourceAssembler assembler, LocationRepository repository) {
        super(assembler, repository, Location.class);
    }
}
