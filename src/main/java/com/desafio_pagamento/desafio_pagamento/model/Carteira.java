package com.desafio_pagamento.desafio_pagamento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "CARTEIRA_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Carteira implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "SALDO")
    private Double saldo;

}
