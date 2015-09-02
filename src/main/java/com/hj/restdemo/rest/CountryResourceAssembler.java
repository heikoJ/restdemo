package com.hj.restdemo.rest;

import com.hj.restdemo.common.ResourceAssembler;
import com.hj.restdemo.db.Country;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * Created by heiko on 02.09.15.
 */
@Component
public class CountryResourceAssembler extends ResourceAssembler<Country, CountryResource> {

    public CountryResourceAssembler() {
        super(CountryController.class,CountryResource.class);
    }





}
