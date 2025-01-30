package com.desafio_pagamento.desafio_pagamento.repository;

import com.desafio_pagamento.desafio_pagamento.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
}
