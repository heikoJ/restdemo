package com.hj.restdemo.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Identifiable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by heiko on 02.09.15.
 */
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Location extends AbstractEntity {



    @NonNull
    private String code;

    @NonNull
    private String name;


}
