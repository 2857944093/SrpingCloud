package com.czk.product.service;

import com.czk.product.dto.CartDTO;
import com.czk.product.ProductApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

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
    @Test
    public void findList(){
        productInfoService.findList(Arrays.asList("1","2"));
    }
    @Test
    public void decreaseStock(){
        CartDTO cartDTO =  new CartDTO("1",2);
        productInfoService.decreaseStock(Arrays.asList(cartDTO));
    }
}