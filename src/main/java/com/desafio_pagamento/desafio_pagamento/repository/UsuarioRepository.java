package com.desafio_pagamento.desafio_pagamento.repository;

import com.desafio_pagamento.desafio_pagamento.model.Documento;
import com.desafio_pagamento.desafio_pagamento.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByDocumento(Documento documento);
}
