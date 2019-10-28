package com.znaczek5.wzshop.specification;

import static org.apache.commons.lang3.StringUtils.trimToEmpty;

public class SpecificationUtils {

  public static String getSlugWildcard(String text) {
    return '%' + trimToEmpty(text).toLowerCase() + '%';
  }

}
