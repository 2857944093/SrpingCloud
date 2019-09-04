package com.czk.order.server.enums;

import lombok.Getter;

/**
 * FileName: PayStatusEnum
 * Author:   ChenZK
 * Date:     2019/9/1 17:51
 * Description:
 * History:
 */
@Getter
public enum PayStatusEnum {
    WAIT(0,"等待支付"),
    SUCCESS(1,"支付成功"),
    ;

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
