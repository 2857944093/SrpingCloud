package com.czk.product.service.impl;

import com.czk.product.dataobject.ProductInfo;
import com.czk.product.enums.ProductStatusEnum;
import com.czk.product.repository.ProductInfoRepository;
import com.czk.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * FileName: ProductInfoServiceImpl
 * Author:   ChenZK
 * Date:     2019/9/1 16:23
 * Description:
 * History:
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> fingByProductInfoStatus(Integer saatus) {
        return productInfoRepository.findAllBy();
    }

    @Override
    public List<ProductInfo> findAll() {
        return productInfoRepository.findAllBy();
    }
}
