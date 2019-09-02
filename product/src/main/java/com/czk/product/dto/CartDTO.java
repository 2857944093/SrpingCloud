package com.czk.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * FileName: CartDTO
 * Author:   ChenZK
 * Date:     2019/9/2 22:04
 * Description:
 * History:
 */
@Data
@AllArgsConstructor
public class CartDTO {
    /**
     * 商品id
     */
    private String productId;
    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(){

    }
}
