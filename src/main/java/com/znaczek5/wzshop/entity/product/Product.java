package com.znaczek5.wzshop.entity.product;

import com.znaczek5.wzshop.entity.WithCreationDetails;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product extends WithCreationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
}
