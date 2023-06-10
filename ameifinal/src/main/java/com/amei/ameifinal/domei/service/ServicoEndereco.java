package com.amei.ameifinal.domei.service;

import com.amei.ameifinal.domei.model.Endereco;
import com.amei.ameifinal.domei.model.RespostaPadrao;
import com.amei.ameifinal.domei.repository.RepositorioEndereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicoEndereco {

    @Autowired
    RepositorioEndereco ro;
    @Autowired
    RespostaPadrao rp;

    //Metodo para listar todos os enderecos
    public Iterable<Endereco> listarEndereco(){
        return ro.findAll();
    }

    // Metodo para cadastrar ou alterar dados da empresa

    public ResponseEntity<?> cadastrarAlterarEndereco(Endereco eo, String acao) {
        if (eo.getCidade().equals("")
                && eo.getLogradouro().equals("") && eo.getNumero().equals("") && eo.getCep().equals("") && eo.getUf().equals("")) {
            rp.setMensagem("Todos os dados de endereço são obrigatório");
            return new ResponseEntity<RespostaPadrao>(rp, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<Endereco>(ro.save(eo), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<Endereco>(ro.save(eo), HttpStatus.OK);
            }
        }
    }
}