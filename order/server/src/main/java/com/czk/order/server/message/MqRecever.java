package com.czk.order.server.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 接收mq消息
 * Created by ChenZK
 */
@Slf4j
@Component
public class MqRecever {

    //1.手动创建队列
    //@RabbitListener(queues = "myQueue")
    //2.自动创建队列
    //@RabbitListener(queuesToDeclare = @Queue("myQueue"))
    //3.Exchanges和队列绑定
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("myQueue"),
            exchange = @Exchange("myExchange")
    ))
    public void process(String message){
        log.info("MqRecever: {}", message);
    }

    /**
     * 数码供应商 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            value = @Queue("computerOrder"),
            key = "computer"
    ))
    public void processComputer(String message){
        log.info("computer MqRecever: {}", message);
    }

    /**
     * 水果供应商 接收消息
     * @param message
     */
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myOrder"),
            value = @Queue("fruitOrder"),
            key = "fruit"
    ))
    public void processFruit(String message){
        log.info("fruit MqRecever: {}", message);
    }
}
