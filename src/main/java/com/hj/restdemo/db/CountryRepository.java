package com.hj.restdemo.db;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by heiko on 02.09.15.
 */
public interface CountryRepository extends Repository <Country,Long> {

    Country findByCodeIgnoreCaseAndActive(String code, boolean active);

}
