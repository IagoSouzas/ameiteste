package com.amei.ameifinal.domei.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Usuarios")
@Getter
@Setter

public class Usuarios {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_user;
    private int tipo_user;
    private String nome_completo;
    private String data_nascimento;
    private String cpf;
    private String rg;
    private String celular;
    private String email;
    private String genero;


}
