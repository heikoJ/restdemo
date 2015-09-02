package com.hj.restdemo.db;

import lombok.Data;
import org.springframework.hateoas.Identifiable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by heiko on 02.09.15.
 */
@Data
@MappedSuperclass
public abstract class AbstractEntity implements Identifiable<Long> {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String createdBy;

    private String lastUpdatedBy;

    private boolean active=true;

    private Date createdAt;

    private Date lastModifiedAt;


}
