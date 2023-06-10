package com.amei.ameifinal.domei.service;

import com.amei.ameifinal.domei.model.Empresa;
import com.amei.ameifinal.domei.model.RespostaPadrao;
import com.amei.ameifinal.domei.model.Usuarios;
import com.amei.ameifinal.domei.repository.RepositorioEmpresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicoEmpresa {
    @Autowired
    RepositorioEmpresa re;

    @Autowired RespostaPadrao rp;

    // Metodo para listar todos dados da Empresa
    public Iterable<Empresa> listar(){
        return re.findAll();
    }

    // Metodo para cadastar ou alterar dados da Empresa

    public ResponseEntity<?> cadastrarAlterarEmpresa(Empresa ea, String acao){
        if(ea.getNome_empresa().equals("") && ea.getCnpj().equals("") && ea.getEndereco().equals("")){
            rp.setMensagem("Todos os dados da empresa são obrigatório");
            return new ResponseEntity<RespostaPadrao>(rp, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")){
                return new ResponseEntity<Empresa>(re.save(ea), HttpStatus.CREATED);
            } else{
                return new ResponseEntity<Empresa>(re.save(ea),HttpStatus.OK);
            }

        }
    }

}
