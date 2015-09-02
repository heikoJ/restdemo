package com.hj.restdemo.db;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by heiko on 02.09.15.
 */
public interface LocationRepository extends Repository<Location,Long> {

    public Location findByCodeAndActive(String code,boolean active);
}
