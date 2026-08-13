package com.caiorian.microservico_publisher.controller;

import com.caiorian.microservico_publisher.dtos.PublisherResponseDTO;
import com.caiorian.microservico_publisher.service.PublisherService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Publisher")
@RestController
@RequestMapping("/publisher")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService publisherService;

    @PostMapping("/message")
    public ResponseEntity<String> publisherMessage(@RequestParam("message") String message){
        this.publisherService.publisherMessageQueue(message);
        return ResponseEntity.status(HttpStatus.OK).body("Mensagem enviada com sucesso: " + message);
    }

    @PostMapping("/json")
    public ResponseEntity<String> publisherWithJson(@RequestBody PublisherResponseDTO dto){
        this.publisherService.publisherWithJson(dto);
        return ResponseEntity.status(HttpStatus.OK).body("Json Enviado com sucesso: " + dto);
    }
}
