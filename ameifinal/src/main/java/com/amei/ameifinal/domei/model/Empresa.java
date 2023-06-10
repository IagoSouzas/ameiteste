package com.amei.ameifinal.domei.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table (name = "Empresas")
@Getter
@Setter

public class Empresa {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_empresas;
    private int id_endereco;
    private String nome_empresa;
    private String cnpj;
    private String endereco;


}
