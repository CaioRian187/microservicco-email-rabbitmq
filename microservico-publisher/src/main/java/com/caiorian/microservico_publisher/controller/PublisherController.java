package com.caiorian.microservico_publisher.controller;

import com.caiorian.microservico_publisher.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {

    @Value("${rabbitmq.queuename}")
    private String queueName;

    private final PublisherService publisherService;

    @PostMapping("/message")
    public void publisherMessage(@RequestBody String message){
        System.out.println("Message: " + message);

        this.publisherService.publisherMessageQueue(message, queueName);
    }
}
