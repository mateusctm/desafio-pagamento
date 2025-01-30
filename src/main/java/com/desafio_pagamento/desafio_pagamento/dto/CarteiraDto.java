package com.desafio_pagamento.desafio_pagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record CarteiraDto(
        @JsonProperty("saldo")
        @NotNull
        Double saldo) {
}
