package com.tao.ssmdemo.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.Correlation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Created by TAO on 2018/10/25.
 */
@Component
public class OrderSender<T> {
    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendOrder(T t) throws Exception {
       CorrelationData correlationData = new CorrelationData();
       correlationData.setId((UUID.randomUUID().toString()));

        rabbitTemplate.convertAndSend("order-exchange",//exchange
                "order.abcd", //routingKey
                t, //消息内容
                correlationData   ///消息唯一ID
        );

    }
}
