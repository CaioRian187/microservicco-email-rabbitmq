package com.caiorian.microservico_subscriber.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queuename}")
    private String queueName;

    @Bean
    public Queue queue(){
        return new Queue(queueName, true);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        JacksonJsonMessageConverter converter = new JacksonJsonMessageConverter();

        DefaultClassMapper classMapper = new DefaultClassMapper();

        // Mapeia o __TypeId__ do publisher para a classe local do subscriber
        classMapper.setIdClassMapping(Map.of(
                "com.caiorian.microservico_publisher.dtos.PublisherResponseDTO",
                com.caiorian.microservico_subscriber.dtos.PublisherResponseDTO.class
        ));

        converter.setClassMapper(classMapper);

        return converter;
    }
}
