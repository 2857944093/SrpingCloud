package com.czk.config.bean;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by ChenZK
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitmqTemplate;

    public void send() {
        String content = "hello" + new Date();
        System.out.println("Sender:" + content);
        this.rabbitmqTemplate.convertAndSend("hello", content);
    }
}