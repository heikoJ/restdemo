package com.hj.restdemo.common;

import com.hj.restdemo.db.Country;
import com.hj.restdemo.rest.CountryController;
import com.hj.restdemo.rest.CountryResource;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

/**
 * Created by heiko on 02.09.15.
 */
public abstract  class ResourceAssembler<T extends Identifiable, D extends ResourceSupport> extends ResourceAssemblerSupport<T, D> {


    @Autowired
    MapperFacade mapper;


    public ResourceAssembler(Class<?> controllerClass, Class<D> resourceType) {
        super(controllerClass, resourceType);
    }



    public Page<D> toPage(Page<T> page) {
        return new PageImpl<D>(toResources(page.getContent()),new PageRequest(page.getNumber(),page.getSize()),page.getTotalElements());
    }




    @Override
    public D toResource(T entity) {
        D resource = createResourceWithId(entity.getId(),entity);
        mapper.map(entity,resource);
        return resource;
    }

}
