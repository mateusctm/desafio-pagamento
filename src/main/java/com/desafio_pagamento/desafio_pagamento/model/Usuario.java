package com.desafio_pagamento.desafio_pagamento.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_USUARIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NOME", nullable = false)
    private String nome;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "DOCUMENTO_ID", referencedColumnName = "ID")
    private Documento documento;
    @Column(name = "EMAIL", unique = true, nullable = false)
    @Email
    private String email;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CARTEIRA_ID", referencedColumnName = "ID")
    private Carteira carteira;
    @OneToMany(mappedBy = "idDepositario")
    private List<Transacao> transacoes = new ArrayList<>();


}
