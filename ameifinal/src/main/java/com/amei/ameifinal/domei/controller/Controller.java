package com.amei.ameifinal.domei.controller;

import com.amei.ameifinal.domei.model.Empresa;
import com.amei.ameifinal.domei.model.Endereco;
import com.amei.ameifinal.domei.model.RespostaPadrao;
import com.amei.ameifinal.domei.model.Usuarios;
import com.amei.ameifinal.domei.service.ServicoEmpresa;
import com.amei.ameifinal.domei.service.ServicoEndereco;
import com.amei.ameifinal.domei.service.ServicoUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {


    //cadastrar Enderecos
    @Autowired
    ServicoEndereco so;
    @PostMapping("/cadastrar/endereco")
    public ResponseEntity<?> cadastrar(@RequestBody Endereco eo){
        return so.cadastrarAlterarEndereco(eo, "cadastrar");
    }
    //listar endereco
    @GetMapping("/listar/endereco")
    public Iterable<Endereco> listarEndereco(){
        return so.listarEndereco();
    }

    //cadastrar Empresas
    @Autowired
    ServicoEmpresa se;
    @PostMapping ("/cadastrar/empresa")
    public ResponseEntity<?> cadastrar(@RequestBody Empresa ea){
        return se.cadastrarAlterarEmpresa(ea, "cadastrar");
    }


    //listar empresa
    @GetMapping("/listar/empresa")
    public Iterable<Empresa> listarEmpresa(){
        return se.listar();
    }


    //cadastrar Usuarios
    @Autowired
    private ServicoUsuarios sc;
    @PostMapping("/cadastrar/usuario")
    public ResponseEntity<?> cadastrar(@RequestBody Usuarios us){
        return sc.cadastrarAlterarUsuario(us, "cadastrar");
    }

    //listar usuario
    @GetMapping("/listar/usuario")
    public Iterable<Usuarios> listarUser(){
        return sc.listar();
    }

    //Remover id dos usuarios
    @Autowired
    Usuarios us;
    @DeleteMapping("/remover/{id_user}")
    public ResponseEntity<RespostaPadrao> remover(@PathVariable long id_user){
        return sc.remover(id_user);
    }



    // teste
    @GetMapping ("/")
    public String rota(){
        return "API de user está funcionando";
    }

}
