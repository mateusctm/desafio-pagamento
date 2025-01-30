package com.desafio_pagamento.desafio_pagamento.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "CARTEIRA_TB")
@Data
public class Carteira implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SALDO")
    private Double saldo;

}
