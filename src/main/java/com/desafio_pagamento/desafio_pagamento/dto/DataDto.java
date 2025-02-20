package com.desafio_pagamento.desafio_pagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DataDto(
        @JsonProperty("authorization")
        Boolean authorization

) {
}
