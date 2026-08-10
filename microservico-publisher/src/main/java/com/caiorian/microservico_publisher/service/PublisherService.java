package com.caiorian.microservico_publisher.service;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final RabbitTemplate rabbitTemplate;

    public void publisherMessageQueue(String queueName, String message){
        System.out.println(message);
        // Passando a mensagem e o nome da fila para o RabbitMQ
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
