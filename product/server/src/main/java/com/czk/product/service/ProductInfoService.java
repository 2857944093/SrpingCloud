package com.czk.product.service;

import com.czk.product.dataobject.ProductInfo;
import com.czk.product.dto.CartDTO;

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

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     * @param cartDTOList
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
