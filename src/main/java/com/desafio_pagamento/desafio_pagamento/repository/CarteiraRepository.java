package com.desafio_pagamento.desafio_pagamento.repository;

import com.desafio_pagamento.desafio_pagamento.model.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
