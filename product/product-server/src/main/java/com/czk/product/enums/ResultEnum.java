/**
 * @program: product
 * @description:
 * @author: Mr.wjg
 * @create: 2019/9/2 22:12
 **/
package com.czk.product.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PRODUCT_NOT_EXIT(1,"商品不存在"),

    PRODUCT_STOCK_ERROR(2,"库存不足"),
    ;
    private Integer code;

    private String meg;

    ResultEnum(Integer code, String meg) {
        this.code = code;
        this.meg = meg;
    }
}
