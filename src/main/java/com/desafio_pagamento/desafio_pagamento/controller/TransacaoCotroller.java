package com.desafio_pagamento.desafio_pagamento.controller;

import com.desafio_pagamento.desafio_pagamento.dto.TransacaoDto;
import com.desafio_pagamento.desafio_pagamento.services.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoCotroller {

    @Autowired
    TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDto> createTransacao(@RequestBody TransacaoDto transacaoDto) {
        try {
            return ResponseEntity.ok(transacaoService.criarTransacao(transacaoDto));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }

    }

    @GetMapping
    public ResponseEntity<List<TransacaoDto>> getAllTransacao() {
        return ResponseEntity.ok(transacaoService.getAllTransacao());
    }
}
