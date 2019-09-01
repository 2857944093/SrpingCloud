package com.czk.order.VO;

import lombok.Data;

/**
 * FileName: ResultVo
 * Author:   ChenZK
 * Date:     2019/9/1 18:47
 * Description:
 * History:
 */
@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;
}
