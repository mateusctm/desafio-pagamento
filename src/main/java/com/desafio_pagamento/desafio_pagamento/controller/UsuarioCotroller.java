package com.desafio_pagamento.desafio_pagamento.controller;

import com.desafio_pagamento.desafio_pagamento.dto.UsuarioDto;
import com.desafio_pagamento.desafio_pagamento.services.UsuarioService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioCotroller {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDto>> getUsuarios() {
        return ResponseEntity.ok(usuarioService.getAllUsuario());

    }

    @GetMapping("/{numero}")
    public ResponseEntity<UsuarioDto> getUsuarioById(@PathVariable Long numero) {
        try {
            UsuarioDto usuarioDto = usuarioService.getUsuario(numero);
            return ResponseEntity.ok(usuarioDto);

        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

    }

    @PostMapping
    public ResponseEntity<UsuarioDto> createUsuario(@RequestBody @Valid UsuarioDto usuarioDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.criarUsuario(usuarioDto));
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        }

    }

    @PutMapping
    public ResponseEntity<UsuarioDto> updateUsuario(@RequestParam Long numero, @RequestBody @Valid UsuarioDto usuarioDto) {
        try {
            UsuarioDto usuarioDto1 = usuarioService.updateUsuarios(numero, usuarioDto);
            return ResponseEntity.ok(usuarioDto1);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }

    }

    @DeleteMapping("/{numero}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long numero){
        try {
            usuarioService.deleteUsuario(numero);
            return ResponseEntity.ok().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();

        }

    }




}
