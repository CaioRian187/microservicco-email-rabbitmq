package com.caiorian.microservico_subscriber.service;

import com.caiorian.microservico_subscriber.dtos.PublisherResponseDTO;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "${rabbitmq.queuename}")
public class SubscriberService {

    @RabbitHandler
    public void receiverMessage(String message){
        System.out.println("------------Consumindo a fila (String)------------");
        System.out.println("==================================================");
        System.out.println(message);
        System.out.println("==================================================\n");
    }

    @RabbitHandler
    public void receiverJson(PublisherResponseDTO dto){
        System.out.println("-------------Consumindo a fila (JSON)-------------");
        System.out.println("==================================================");
        System.out.println("VendaId: " + dto.vendaId());
        System.out.println("UsuarioId: " + dto.usuarioId());
        System.out.println("EmailUsuario: " + dto.emailUsuario());
        System.out.println("================================================\n");
    }
}
