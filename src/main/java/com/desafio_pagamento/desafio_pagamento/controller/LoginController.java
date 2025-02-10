package com.desafio_pagamento.desafio_pagamento.controller;

import com.desafio_pagamento.desafio_pagamento.dto.TokenDto;
import com.desafio_pagamento.desafio_pagamento.dto.UsuarioDto;
import com.desafio_pagamento.desafio_pagamento.dto.UsuarioLoginDto;
import com.desafio_pagamento.desafio_pagamento.services.TokenService;
import com.desafio_pagamento.desafio_pagamento.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenDto> login(@RequestBody UsuarioLoginDto loginDto){
        UsuarioDto usuarioDto = usuarioService.getUsuario(loginDto.numeroDocumento());
        if(bCryptPasswordEncoder.matches(loginDto.password(), usuarioDto.password())){
            throw new RuntimeException();
        }

        return ResponseEntity.ok(tokenService.gerarToken(usuarioDto));

    }
}
