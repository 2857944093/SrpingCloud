package com.czk.product.execption;


import com.czk.product.enums.ResultEnum;

public class ProductExecption extends RuntimeException{

    private Integer code;

    public ProductExecption(Integer code, String msg){
        super(msg);
        this.code = code;
    }

    public ProductExecption(ResultEnum resultEnum){
        super(resultEnum.getMeg());
        this.code = resultEnum.getCode();
    }
}
