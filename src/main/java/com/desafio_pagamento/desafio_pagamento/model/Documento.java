package com.desafio_pagamento.desafio_pagamento.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DOCUMENTO_TB")
@Data
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TIPO_DOCUMENTO")
    private TipoDocumento tipoDocumento;
    @Column(name = "NUMERO", unique = true)
    private Long numero;
}
