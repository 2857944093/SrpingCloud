package com.czk.product.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class ProductCategoryServiceTest extends ProductInfoServiceTest{

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void findAll() {
        productCategoryService.findAll();
    }
}