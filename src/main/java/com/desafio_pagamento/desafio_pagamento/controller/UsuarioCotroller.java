package com.desafio_pagamento.desafio_pagamento.controller;

import com.desafio_pagamento.desafio_pagamento.config.SecurityFilter;
import com.desafio_pagamento.desafio_pagamento.dto.UsuarioDto;
import com.desafio_pagamento.desafio_pagamento.services.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
@Tag(name = "usuario")
@SecurityRequirement(name = SecurityFilter.SECURYTY)
public class UsuarioCotroller {

    @Autowired
    UsuarioService usuarioService;


    @GetMapping("/usuarios")
    @Operation(summary = "busca de usuarios", description = "metodo que busca usuarios")
    @ApiResponse(responseCode = "200", description = "busca realizada")
    @ApiResponse(responseCode = "401", description = "não autorizado")
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuario());

    }

    @GetMapping("/{numero}")
    @Operation(summary = "busca de usuarios", description = "metodo que busca usuario")
    @ApiResponse(responseCode = "200", description = "busca realizada")
    @ApiResponse(responseCode = "401", description = "não autorizado")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Long numero) {
        try {
            UsuarioDto usuarioDto = usuarioService.getUsuario(numero);
            return ResponseEntity.ok(usuarioDto);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

    }

    @PostMapping
    @Operation(summary = "cria usuario", description = "metodo que cadrastra usuario")
    @ApiResponse(responseCode = "201", description = "usuario criado")
    @ApiResponse(responseCode = "401", description = "não autorizado")
    public ResponseEntity<UsuarioDto> createUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(usuarioDto));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }

    }

    @PutMapping
    @Operation(summary = "atualiza usuario", description = "metodo que atualiza usuario")
    @ApiResponse(responseCode = "200", description = "usuario atualizado")
    @ApiResponse(responseCode = "401", description = "não autorizado")
    public ResponseEntity<UsuarioDto> updateUsuario(@RequestParam Long numero, @RequestBody @Valid UsuarioDto usuarioDto, JwtAuthenticationToken token) {
        try {
            UsuarioDto usuarioDto1 = usuarioService.updateUsuarios(numero, usuarioDto);
            return ResponseEntity.ok(usuarioDto1);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }

    }

    @DeleteMapping("/{numero}")
    @Operation(summary = "deleta usuario", description = "metodo que deleta usuario")
    @ApiResponse(responseCode = "200", description = "usuario deletado")
    @ApiResponse(responseCode = "401", description = "não autorizado")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long numero, JwtAuthenticationToken token) {
        try {
            usuarioService.deleteUsuario(numero);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }

    }


}
