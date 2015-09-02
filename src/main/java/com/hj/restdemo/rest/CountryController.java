package com.hj.restdemo.rest;

import com.hj.restdemo.common.ResourceAssembler;
import com.hj.restdemo.db.Country;
import com.hj.restdemo.db.CountryRepository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by heiko on 02.09.15.
 */
@RestController
@RequestMapping("/rest/countries")
public class CountryController extends AbstractController {

    @Autowired
    public CountryController(CountryResourceAssembler assembler, CountryRepository repository) {
        super(assembler, repository, Country.class);
    }

}
