package com.czk.product.VO;

import lombok.Data;

/**
 * FileName: ResultVO
 * Author:   ChenZK
 * Date:     2019/9/1 16:41
 * Description:
 * History:
 */
@Data
public class ResultVO<T> {
    private Integer code;

    private String msg;

    private T data;


}
