package com.znaczek5.wzshop.entity.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.znaczek5.wzshop.entity.WithCreationDetails;
import com.znaczek5.wzshop.model.Treeable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "category")
@SecondaryTable(name = "category_path")
@EntityListeners(AuditingEntityListener.class)
public class Category extends WithCreationDetails implements Treeable<Long, Category> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "parent_id")
  private Category parent;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
  private List<Category> children;

  @Column(table = "category_path", updatable = false)
  private String path;

  @Column(unique = true)
  private String slug;

  @Override
  public Long getKey() {
    return this.getId();
  }

  @JsonIgnore
  @Override
  public Long getParentKey() {
    if (this.getParent() != null)
      return this.getParent().getId();
    else
      return null;
  }

  @Override
  public String toString() {
    return "Category{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", parent=" + (!Objects.isNull(parent) ? parent.getSlug() : "null") +
      ", path='" + path + '\'' +
      ", slug='" + slug + '\'' +
      '}';
  }
}







