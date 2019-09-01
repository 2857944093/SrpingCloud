/**
 * @program: product
 * @description:
 * @author: Mr.wjg
 * @create: 2019/9/1 16:35
 **/
package com.czk.product.service;

import com.czk.product.dataobject.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> findAll();

    List<ProductCategory> findByType(List<Integer> type);
}
