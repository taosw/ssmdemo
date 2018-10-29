package com.tao.ssmdemo.consummer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by TAO on 2018/10/25.
 */
@Component
public class Consummer<T> {

    @RabbitListener(bindings = @QueueBinding(
            value=@Queue(value="order-queue",durable = "true"),
            exchange=@Exchange(name = "order-exchange",durable = "true",type="topic"),
            key="order.*"
    ))

    @RabbitHandler
    public void onOrderMessage(@Payload T t,
                               @Headers Map<String,Object> headers,
                               Channel channel) throws Exception{
        //消费者操作
        System.out.print("接收消息，开始消费");
        Long deliverTag=(Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        //ACK
        channel.basicAck(deliverTag,false);
    }

}
