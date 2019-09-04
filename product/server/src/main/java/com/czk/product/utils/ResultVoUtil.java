package com.czk.product.utils;

import com.czk.product.vo.ResultVO;

/**
 * FileName: ResultVoUtil
 * Author:   ChenZK
 * Date:     2019/9/1 17:15
 * Description:
 * History:
 */
public class ResultVoUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO<>();
        resultVO.setCode(1);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
