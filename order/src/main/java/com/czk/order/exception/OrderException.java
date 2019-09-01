package com.czk.order.exception;


import com.czk.order.enums.ResultEnum;
import com.sun.tools.internal.xjc.generator.bean.ImplStructureStrategy;
import org.hibernate.criterion.Order;

public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
