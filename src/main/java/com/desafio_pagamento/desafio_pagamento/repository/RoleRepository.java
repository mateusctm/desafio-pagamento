package com.desafio_pagamento.desafio_pagamento.repository;

import com.desafio_pagamento.desafio_pagamento.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
