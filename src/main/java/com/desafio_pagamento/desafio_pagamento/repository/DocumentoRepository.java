package com.desafio_pagamento.desafio_pagamento.repository;

import com.desafio_pagamento.desafio_pagamento.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    Optional<Documento> findByNumero(Long numero);
}
