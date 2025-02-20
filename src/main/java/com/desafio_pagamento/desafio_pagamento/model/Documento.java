package com.desafio_pagamento.desafio_pagamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DOCUMENTO_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
