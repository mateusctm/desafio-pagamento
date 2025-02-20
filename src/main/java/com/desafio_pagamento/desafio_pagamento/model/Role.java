package com.desafio_pagamento.desafio_pagamento.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ROLE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @Column(name = "ROLE_ID")
    private Long id;
    @Column(name = "ROLE_ENUN")
    private RoleEnun roleEnun;
}
