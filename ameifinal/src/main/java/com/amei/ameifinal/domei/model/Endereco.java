package com.amei.ameifinal.domei.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Enderecos")
@Getter
@Setter

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_endereco;
    private int id_user;
    private String logradouro;
    private String numero;
    private String cep;
    private String cidade;
    private String uf;
}
