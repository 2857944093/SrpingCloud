package com.czk.order.server.controller;

import com.czk.order.server.dto.OrderDTO;
import com.czk.order.server.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by ChenZK
 */
@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    /*@GetMapping("/sendMessage")
    public void process(){
        streamClient.input().send(MessageBuilder.withPayload("now " + new Date()).build());
    }*/

    /**
     * 发送OrderDTO对象
     */
    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        streamClient.input().send(MessageBuilder.withPayload(orderDTO).build());
    }
}
