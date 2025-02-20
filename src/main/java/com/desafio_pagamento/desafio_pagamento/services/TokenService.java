package com.desafio_pagamento.desafio_pagamento.services;

import com.desafio_pagamento.desafio_pagamento.dto.RoleDto;
import com.desafio_pagamento.desafio_pagamento.dto.TokenDto;
import com.desafio_pagamento.desafio_pagamento.dto.UsuarioDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
public class TokenService {
    @Autowired
    private final JwtEncoder jwtEncoder;

    public TokenDto gerarToken(UsuarioDto usuarioDto) {

        var scope = usuarioDto.roles().stream().map(RoleDto::roleEnun).toArray();

        var claims = JwtClaimsSet.builder()
                .issuer("desafio-pagamento")
                .subject(usuarioDto.nome())
                .expiresAt(Instant.now().plusSeconds(300L))
                .claim("scope", scope)
                .build();
        String jwt = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return new TokenDto(jwt);
    }
}
