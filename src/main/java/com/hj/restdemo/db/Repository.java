package com.hj.restdemo.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by heiko on 02.09.15.
 */
@NoRepositoryBean
public interface Repository<T,ID extends Serializable> extends CrudRepository<T,ID> {

    Page<T> findByActive(Pageable pageable,boolean active);
    T findByIdAndActive(ID id,boolean active);
}
