package com.desafio_pagamento.desafio_pagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record TransacaoDto(
        @JsonProperty("valor")
        @NotNull
        Double valor,
        @JsonProperty("depositario")
        @NotNull
        UsuarioDto depositario,
        @JsonProperty("destinatario")
        @NotNull
        UsuarioDto destinatario

) {
}
