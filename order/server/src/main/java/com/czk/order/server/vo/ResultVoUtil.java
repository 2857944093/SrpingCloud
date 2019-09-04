package com.czk.order.server.vo;

/**
 * FileName: ResultVoUtil
 * Author:   ChenZK
 * Date:     2019/9/1 18:48
 * Description:
 * History:
 */
public class ResultVoUtil {

    public static ResultVo success(Object object){
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo;
    }
}
