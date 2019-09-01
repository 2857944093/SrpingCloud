package com.czk.product.service.impl;

import com.czk.product.dataobject.ProductCategory;
import com.czk.product.repository.ProductCategoryRepository;
import com.czk.product.repository.ProductInfoRepository;
import com.czk.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName: ProductCategoryServiceImpl
 * Author:   ChenZK
 * Date:     2019/9/1 16:35
 * Description:
 * History:
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAllBy();
    }

    @Override
    public List<ProductCategory> findByType(List<Integer> type) {
        return productCategoryRepository.findByCategoryTypeIn(type);
    }
}
