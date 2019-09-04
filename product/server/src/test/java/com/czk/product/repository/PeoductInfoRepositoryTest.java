package com.czk.product.repository;

import com.czk.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PeoductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository repository;

    @Test
    public void findAllBy() {
        List<ProductInfo> productInfoList = repository.findAllBy();
    }

    @Test
    public void findByProductIdIn() {
        List<ProductInfo> productInfos = repository.findByProductIdIn(Arrays.asList("1","2"));
        Assert.assertTrue(productInfos.size() > 0);
    }

}