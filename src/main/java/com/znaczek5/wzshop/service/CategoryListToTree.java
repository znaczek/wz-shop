package com.znaczek5.wzshop.service;

import com.znaczek5.wzshop.dto.CategoryDTO;
import com.znaczek5.wzshop.entity.product.Category;
import com.znaczek5.wzshop.utils.ListToTree;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.znaczek5.wzshop.dto.CategoryDTO.CategoryTreeDTO;

@Service
public class CategoryListToTree extends ListToTree<Long, Category, CategoryTreeDTO> {

  private final ModelMapper modelMapper;

  @Autowired
  public CategoryListToTree(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
    this.modelMapper.addMappings(skipModifiedFieldsMap);
  }

  PropertyMap<CategoryTreeDTO, Category> skipModifiedFieldsMap = new PropertyMap<>() {
    protected void configure() {
      skip().setChildren(null);
    }
  };

  @Override
  public CategoryTreeDTO createTreeNode(Category source) {
    return modelMapper.map(source, CategoryTreeDTO.class);
  }

}
