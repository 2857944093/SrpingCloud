package com.czk.order.server.utils;

import java.util.Random;

/**
 * FileName: KeyUtil
 * Author:   ChenZK
 * Date:     2019/9/1 18:12
 * Description:
 * History:
 */
public class KeyUtil {

    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
