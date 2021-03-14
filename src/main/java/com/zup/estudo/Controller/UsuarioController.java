package com.zup.estudo.Controller;

import com.zup.estudo.Controller.Form.UsuarioForm;
import com.zup.estudo.Model.Usuario;
import com.zup.estudo.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")

public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody UsuarioForm form){
        ResponseEntity<Usuario> usuario = form.converter(usuarioRepository);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
