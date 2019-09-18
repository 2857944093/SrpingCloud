package com.czk.config.connection;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by ChenZK
 */
public class ConnectionTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        //获取连接
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //声明创建队列
        channel.queueDeclare();
        //消息内容
        String message = "Hello World!";
        channel.basicPublish("",null,null,message.getBytes());
        System.out.println("发送消息：" + message);
        //关闭连接通道
        channel.close();
        connection.close();
    }
}
