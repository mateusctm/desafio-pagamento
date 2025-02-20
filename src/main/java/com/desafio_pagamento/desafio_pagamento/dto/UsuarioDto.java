package com.desafio_pagamento.desafio_pagamento.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public record UsuarioDto(
        @JsonProperty("nome")
        @NotNull
        String nome,
        @JsonProperty("documento")
        @NotNull
        DocumentoDto documento,
        @JsonProperty("email")
        @Email
        @NotNull
        String email,
        @JsonProperty("password")
        @NotNull
        String password,
        @JsonProperty("carteira")
        @NotNull
        CarteiraDto carteira,
        @JsonProperty("roles")
        Set<RoleDto> roles) {
}
