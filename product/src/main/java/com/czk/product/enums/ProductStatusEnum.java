/**
 * @program: product
 * @description:
 * @author: Mr.wjg
 * @create: 2019/9/1 16:25
 **/
package com.czk.product.enums;

import lombok.Getter;

@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),
    DOWN(1,"下架"),
    ;
    private Integer code;

    private String msg;

    ProductStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
