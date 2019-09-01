package com.czk.product.service;

import com.czk.product.dataobject.ProductInfo;

import java.util.List;

/**
 * FileName: ProductInfoService
 * Author:   ChenZK
 * Date:     2019/9/1 16:20
 * Description:
 * History:
 */
public interface ProductInfoService {

    List<ProductInfo> fingByProductInfoStatus(Integer status);

    List<ProductInfo> findAll();
}
