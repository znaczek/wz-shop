package com.znaczek5.wzshop.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.znaczek5.wzshop.entity.WithCreationDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Product extends WithCreationDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne()
  @JoinColumn(name = "category_id")
  private Category category;

  private String name;
  private String description;

  private Integer price;
}
