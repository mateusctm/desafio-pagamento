package com.desafio_pagamento.desafio_pagamento.mapper;

import com.desafio_pagamento.desafio_pagamento.dto.CarteiraDto;
import com.desafio_pagamento.desafio_pagamento.model.Carteira;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarteiraMapper {

    CarteiraMapper CARTEIRA_MAPPER = Mappers.getMapper(CarteiraMapper.class);

    Carteira toEntity(CarteiraDto carteiraDto);

}
