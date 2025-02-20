package com.desafio_pagamento.desafio_pagamento.controller;

import com.desafio_pagamento.desafio_pagamento.dto.TransacaoDto;
import com.desafio_pagamento.desafio_pagamento.services.TransacaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoCotroller {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    @Operation(summary = "cria uma transação", description = "metodo que realiza uma transação")
    @ApiResponse(responseCode = "201", description = "transação realizada")
    @ApiResponse(responseCode = "401", description = "não autorizado")
    public ResponseEntity<TransacaoDto> createTransacao(@RequestBody TransacaoDto transacaoDto, JwtAuthenticationToken token) {
        try {
            return ResponseEntity.ok(transacaoService.criarTransacao(transacaoDto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }

    }

    @GetMapping
    @Operation(summary = "busca transações", description = "metodo que busca transações")
    @ApiResponse(responseCode = "201", description = "transação realizada")
    @ApiResponse(responseCode = "401", description = "não autorizado")
    public ResponseEntity<List<TransacaoDto>> getAllTransacao(JwtAuthenticationToken token) {
        return ResponseEntity.ok(transacaoService.getAllTransacao());
    }
}
