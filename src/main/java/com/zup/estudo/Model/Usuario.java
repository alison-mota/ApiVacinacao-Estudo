package com.zup.estudo.Model;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @Email
    @Column(unique = true)
    private String email;
    @CPF
    @Column(unique = true)
    private String cpf;
    private Date dataNascimento;

    public Usuario(){
    }

    public Usuario(String nome, String email, String cpf, Date dataNascimento){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

}
