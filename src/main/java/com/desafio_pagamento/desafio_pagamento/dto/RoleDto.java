package com.desafio_pagamento.desafio_pagamento.dto;

import com.desafio_pagamento.desafio_pagamento.model.RoleEnun;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record RoleDto(
        @JsonProperty("id")
        @NotNull
        Long id,
        @JsonProperty("roleEnun")
        @NotNull
        RoleEnun roleEnun
) {
}
