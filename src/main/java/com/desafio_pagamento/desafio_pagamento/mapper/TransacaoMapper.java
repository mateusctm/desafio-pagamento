package com.desafio_pagamento.desafio_pagamento.mapper;

import com.desafio_pagamento.desafio_pagamento.dto.TransacaoDto;
import com.desafio_pagamento.desafio_pagamento.model.Transacao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {

    TransacaoMapper TRANSACAO_MAPPER = Mappers.getMapper(TransacaoMapper.class);

    @Mapping(target = "id", ignore = true)
    Transacao toEntity(TransacaoDto transacaoDto);

    TransacaoDto toDto(Transacao transacao);

    List<TransacaoDto> toListDto(List<Transacao> all);
}
