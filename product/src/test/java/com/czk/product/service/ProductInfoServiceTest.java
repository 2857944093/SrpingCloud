package com.czk.product.service;

import com.czk.product.ProductApplication;
import com.czk.product.ProductApplicationTests;
import com.czk.product.enums.ProductStatusEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static org.junit.Assert.*;

@Component
public class ProductInfoServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void fingByProductInfoStatus() {
        productInfoService.fingByProductInfoStatus(0);
    }
    @Test
    public void findAllBy(){
        productInfoService.findAll();
    }
}