package com.caiorian.microservico_subscriber.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class SubscriberService {

    // Criando método para escutar as mensagens da fila, e printar todas as mensagens da fila
    @RabbitListener(queues = "${rabbitmq.queuename}")
    public void receiverMessage(Message message){
        System.out.println(new String(message.getBody()));
    }
}
