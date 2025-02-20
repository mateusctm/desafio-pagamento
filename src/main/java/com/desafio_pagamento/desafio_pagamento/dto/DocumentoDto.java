package com.desafio_pagamento.desafio_pagamento.dto;

import com.desafio_pagamento.desafio_pagamento.model.TipoDocumento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record DocumentoDto(
        @JsonProperty("tipoDocumento")
        @NotNull
        TipoDocumento tipoDocumento,
        @JsonProperty("numero")
        @NotNull
        Long numero
) {
}
