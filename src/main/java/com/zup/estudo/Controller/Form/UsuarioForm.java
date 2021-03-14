package com.zup.estudo.Controller.Form;

import com.zup.estudo.Model.Usuario;
import com.zup.estudo.Repository.UsuarioRepository;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class UsuarioForm {

    @NotBlank
    private String nome;
    @Email
    private String email;
    @CPF
    private String cpf;
    @NotNull
    private Date dataNascimento;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public ResponseEntity<Usuario> converter(UsuarioRepository usuarioRepository) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        usuarioRepository.save(new Usuario(nome, email, cpf, dataNascimento));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
