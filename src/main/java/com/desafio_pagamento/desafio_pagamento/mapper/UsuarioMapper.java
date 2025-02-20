package com.desafio_pagamento.desafio_pagamento.mapper;

import com.desafio_pagamento.desafio_pagamento.dto.UsuarioDto;
import com.desafio_pagamento.desafio_pagamento.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioMapper USUARIO_MAPPER = Mappers.getMapper(UsuarioMapper.class);


    @Mapping(target = "transacoesDestinatario", ignore = true)
    @Mapping(target = "transacoesDepositario", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    Usuario toEntity(UsuarioDto usuarioDto);

    @Mapping(target = "roles", source = "roles")
    @Mapping(target = "roles.", source = "roles")
    UsuarioDto toDto(Usuario usuario);

    List<UsuarioDto> toListDto(List<Usuario> usuarios);
}
