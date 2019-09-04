package com.czk.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServerCtl {

    @GetMapping("/msg")
    @ResponseBody
    public String getMsg(){
        return "this is product msg2";
    }
}
