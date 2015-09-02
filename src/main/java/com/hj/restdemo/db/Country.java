package com.hj.restdemo.db;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.Identifiable;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by heiko on 02.09.15.
 */
@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = "code")
)
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Country extends AbstractEntity {


    @NonNull
    private String code;

    @NonNull
    private String name;

}
