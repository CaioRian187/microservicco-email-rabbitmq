package com.caiorian.microservico_publisher.dtos;

import java.io.Serializable;

public record PublisherResponseDTO(
        Long vendaId,
        Long usuarioId,
        String emailUsuario

) implements Serializable {
}
