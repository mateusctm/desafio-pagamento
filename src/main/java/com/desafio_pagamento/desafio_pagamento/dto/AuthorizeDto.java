package com.desafio_pagamento.desafio_pagamento.dto;

import com.desafio_pagamento.desafio_pagamento.model.StatusAuthorize;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AuthorizeDto(
        @JsonProperty("status")
        StatusAuthorize status,
        @JsonProperty("data")
        DataDto dataDto

) {
}
