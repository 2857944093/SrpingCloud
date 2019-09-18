package com.czk.order.server.controller;

import com.czk.order.server.config.GirlConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ChenZK
 */
@RestController
public class GirlController {

    @Autowired
    private GirlConfig girlConfig;

    @RequestMapping("/girl/print")
    public String print(){
        return "name:" + girlConfig.getName() + "age:" + girlConfig.getAge();
    }
}