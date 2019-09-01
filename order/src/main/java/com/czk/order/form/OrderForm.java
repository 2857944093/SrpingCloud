package com.czk.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * FileName: OrderForm
 * Author:   ChenZK
 * Date:     2019/9/1 18:19
 * Description:
 * History:
 */
@Data
public class OrderForm {
    @NotEmpty(message = "姓名必填")
    private String name;

    @NotEmpty(message = "手机号必")
    private String phone;

    @NotEmpty(message = "地址必填")
    private String address;

    @NotEmpty(message = "openid必填")
    private String openid;

    @NotEmpty(message = "购物车不能为空")
    private String items;
}
