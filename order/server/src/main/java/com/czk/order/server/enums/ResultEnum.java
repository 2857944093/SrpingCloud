package com.czk.order.server.enums;

import lombok.Getter;

/**
 * FileName: ResultEnum
 * Author:   ChenZK
 * Date:     2019/9/1 18:28
 * Description:
 * History:
 */
@Getter
public enum ResultEnum {
    PARAM_ERROR(1,"参数错误"),
    CART_EMPTY(2,"购物车为空"),
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
