package com.hj.restdemo.rest;

import com.hj.restdemo.common.ResourceAssembler;
import com.hj.restdemo.db.AbstractEntity;
import com.hj.restdemo.db.Country;
import com.hj.restdemo.db.Repository;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by heiko on 02.09.15.
 */
public abstract class AbstractController<T extends AbstractEntity,D extends ResourceSupport,R extends Repository> {

    private ResourceAssembler<T,D> assembler;

    private R repository;

    private Class<T> entityClass;

    @Autowired
    Permissions permissions;

    @Autowired
    MapperFacade mapper;

    AbstractController(ResourceAssembler<T,D> assembler, R repository, Class<T> entityClass) {
        this.assembler = assembler;
        this.repository = repository;
        this.entityClass = entityClass;
    }


    @RequestMapping(method = RequestMethod.OPTIONS)
    public void getListOptions(HttpServletResponse response) {
        String options = "";
        if(permissions.hasPermission(entityClass,Permission.READ)) {
            options += RequestMethod.GET.name();
        }
        if(permissions.hasPermission(entityClass,Permission.INSERT)) {
            options += "," + RequestMethod.PUT.name();
        }
        response.setHeader(HttpHeaders.ALLOW,options);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<D> getResources(
            @RequestParam(defaultValue="0") Integer page,
            @RequestParam(defaultValue="10") Integer pageSize) {

        if(!permissions.hasPermission(entityClass,Permission.READ)) {
            throw new MethodNotAllowedException(entityClass,RequestMethod.GET);
        }


        Pageable pageable = new PageRequest(page,pageSize);

        return assembler.toPage(repository.findByActive(pageable, true));
    }



    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public void createResource(@RequestBody @Valid D  resource, HttpServletResponse response) {
        if(!permissions.hasPermission(entityClass,Permission.INSERT)) {
            throw new MethodNotAllowedException(entityClass,RequestMethod.PUT);
        }

        T entity = mapper.map(resource,entityClass);
        repository.save(entity);


        Link selfLink = ControllerLinkBuilder.linkTo(CountryController.class).slash(entity.getId()).withSelfRel();

        response.setHeader(HttpHeaders.LOCATION, selfLink.getHref());
    }



    @RequestMapping(value="/{id}", method=RequestMethod.OPTIONS)
    public void getEntityOptions(@PathVariable Long id, HttpServletResponse response) {
        String options = "";

        T entity = (T)repository.findByIdAndActive(id, true);
        if(entity!=null) {

            if (permissions.hasPermission(entityClass, Permission.READ)) {
                options += RequestMethod.GET.name();
            }
            if (permissions.hasPermission(entityClass, Permission.UPDATE)) {
                options += "," + RequestMethod.POST.name();
            }
            if (permissions.hasPermission(entityClass, Permission.DELETE)) {
                options += "," + RequestMethod.DELETE.name();
            }
        }

        response.setHeader(HttpHeaders.ALLOW,options);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public D getResourceById(@PathVariable Long id) {
        if(!permissions.hasPermission(entityClass,Permission.READ)) {
            throw new MethodNotAllowedException(entityClass,RequestMethod.GET);
        }
        T entity = (T)repository.findByIdAndActive(id, true);
        if(entity==null) {
            throw new ResourceNotFoundException(entityClass,id);
        }

        return assembler.toResource(entity);
    }


    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    @Transactional
    public void deleteResource(@PathVariable Long id) {
        if(!permissions.hasPermission(entityClass,Permission.DELETE)) {
            throw new MethodNotAllowedException(entityClass,RequestMethod.DELETE);
        }
        T entity = (T)repository.findByIdAndActive(id, true);
        if(entity==null) {
            throw new ResourceNotFoundException(entityClass,id);
        }

        entity.setActive(false);
    }


}
