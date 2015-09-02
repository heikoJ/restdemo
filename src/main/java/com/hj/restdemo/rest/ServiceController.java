package com.hj.restdemo.rest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by heiko on 02.09.15.
 */
@RestController
@RequestMapping("/rest/services")
public class ServiceController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @RequestMapping(method = RequestMethod.GET)
    private List<ServiceResource> getServices() {
        List<ServiceResource> services = new ArrayList<>();
        Map<String,Object> controllers = applicationContext.getBeansWithAnnotation(RestController.class);
        for(String controllerId : controllers.keySet()) {
            Object controller = controllers.get(controllerId);
            ServiceResource serviceResource = new ServiceResource();
            serviceResource.setName(controllerId.replaceFirst("Controller", ""));
            serviceResource.add(ControllerLinkBuilder.linkTo(controller.getClass()).withRel(Link.REL_SELF));
            services.add(serviceResource);
        }

        return services;
    }










}
