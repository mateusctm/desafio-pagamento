package com.desafio_pagamento.desafio_pagamento.mapper;

import com.desafio_pagamento.desafio_pagamento.dto.RoleDto;
import com.desafio_pagamento.desafio_pagamento.model.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {


    RoleDto toDto(Role role);
}
