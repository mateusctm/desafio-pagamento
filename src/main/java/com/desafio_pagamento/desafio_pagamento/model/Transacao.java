package com.desafio_pagamento.desafio_pagamento.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TRANSACAO_TB")
@Data
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "VALOR")
    private Double valor;
    @ManyToOne()
    @JoinColumn(name = "USUARIO_DEPOSITARIO_ID", referencedColumnName = "USUARIO_ID")
    private Usuario depositario;
    @ManyToOne
    @JoinColumn(name = "USUARIO_DESTINATARIO_ID", referencedColumnName = "USUARIO_ID")
    private Usuario destinatario;
}
