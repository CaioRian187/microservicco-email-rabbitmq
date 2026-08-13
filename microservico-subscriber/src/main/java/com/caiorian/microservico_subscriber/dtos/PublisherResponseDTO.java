package com.caiorian.microservico_subscriber.dtos;

public record PublisherResponseDTO(
        Long vendaId,
        Long usuarioId,
        String emailUsuario
) {
}
