package com.hj.restdemo.rest;

import com.hj.restdemo.db.Country;
import com.hj.restdemo.db.Location;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by heiko on 02.09.15.
 */
@Component
public class Permissions {

    private Map<Class,List<Permission>> permissionMap;

    public Permissions() {
        this.permissionMap = new HashMap<>();
        //permissionMap.put(Country.class, Collections.singletonList(Permission.READ));
        permissionMap.put(Location.class, Arrays.asList(Permission.values()));
    }

    public boolean hasPermission(Class entity,Permission permission) {
        List<Permission> permissions = permissionMap.get(entity);
        if(permissions==null) return false;
        return permissions.contains(permission);
    }


}
