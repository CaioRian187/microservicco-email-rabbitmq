package com.caiorian.microservico_publisher.service;

import com.caiorian.microservico_publisher.dtos.PublisherResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PublisherService {

    @Value("${rabbitmq.queuename}")
    private String queueName;

    private final RabbitTemplate rabbitTemplate;

    public void publisherMessageQueue(String message){
        System.out.println("Mensagem enviada para a fila com sucesso: " + message);
        // Passando a mensagem e o nome da fila para o RabbitMQ
        rabbitTemplate.convertAndSend(queueName, message);
    }

    public void publisherWithJson(PublisherResponseDTO dto) {
        System.out.println("Objeto json enviado para a fila com sucesso.");
        rabbitTemplate.convertAndSend(queueName, dto);
    }
}
