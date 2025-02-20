package com.desafio_pagamento.desafio_pagamento.mapper;

import com.desafio_pagamento.desafio_pagamento.dto.DocumentoDto;
import com.desafio_pagamento.desafio_pagamento.model.Documento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentoMapper {

    DocumentoMapper DOCUMENTO_MAPPER = Mappers.getMapper(DocumentoMapper.class);

    @Mapping(target = "id", ignore = true)
    Documento toEntity(DocumentoDto documentoDto);
    DocumentoDto toDto(Documento documento);

}
