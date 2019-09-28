package com.czk.order.server.message;

import com.czk.order.server.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by ChenZK
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

  /*  @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public Object processInput(Object message){
        log.info("inMessage {} ", message);
        return message;
    }*/

    /**
     * 接收OrderDTO对象
     * @param message
     * @return
     */
    @StreamListener(value = StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public Object processInput(OrderDTO message){
        log.info("inMessage {} ", message);
        return message;
    }


    @StreamListener(value = StreamClient.OUTPUT)
    public void processOutput(OrderDTO message){
        log.info("outMessage {} ", message);
    }
}
