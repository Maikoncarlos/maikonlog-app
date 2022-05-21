package com.github.maikoncarlos.maikonlogapp.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Embeddable
public class Destinatario {

    @Column(name = "destinatario_nome")
    private String nome;

    @Column(name = "destinatario_logradouro")
    private String logradouro;

    @Column(name = "destinatario_numero")
    private String numero;

    @EqualsAndHashCode.Include
    @Column(name = "destinatario_complemento")
    private String complemento;

    @Column(name = "destinatario_bairro")
    private String bairro;
}
