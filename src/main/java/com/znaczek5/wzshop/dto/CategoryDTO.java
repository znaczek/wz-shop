package com.znaczek5.wzshop.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.znaczek5.wzshop.model.Tree;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class CategoryDTO {

  private String name;

  private String slug;

  @Data
  @NoArgsConstructor
  @EqualsAndHashCode(callSuper = true)
  public static class CategoryTreeDTO extends CategoryDTO implements Tree<CategoryTreeDTO> {

    @JsonIgnore
    private CategoryTreeDTO parent;

    private List<CategoryTreeDTO> children = new ArrayList<>();

    @Override
    public void addChild(CategoryTreeDTO child) {
      this.children.add(child);
    }

    @JsonProperty("parent")
    public String parentSlug() {
      return !Objects.isNull(parent) ? parent.getSlug() : null;
    }
  }

}
