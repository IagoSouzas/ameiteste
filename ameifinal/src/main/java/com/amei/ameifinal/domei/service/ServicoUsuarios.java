package com.amei.ameifinal.domei.service;

import com.amei.ameifinal.domei.model.RespostaPadrao;
import com.amei.ameifinal.domei.model.Usuarios;
import com.amei.ameifinal.domei.repository.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ServicoUsuarios {

    @Autowired
    private RepositorioUsuario ro;

    @Autowired
    private RespostaPadrao rp;

    // Metodo para listar todos dados do usuarios
    public Iterable<Usuarios> listar(){
        return ro.findAll();
    }

    // Metodo para cadastar ou alterar dados do usuarios

    public ResponseEntity<?> cadastrarAlterarUsuario(Usuarios us, String acao){
        if(us.getNome_completo().equals("") && us.getData_nascimento().equals("") && us.getRg().equals("")
                && us.getEmail().equals("") && us.getCpf().equals("") && us.getCelular().equals("") && us.getGenero().equals("")){
            rp.setMensagem("Todos os dados são obrigatório");
            return new ResponseEntity<RespostaPadrao>(rp, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")){
                return new ResponseEntity<Usuarios>(ro.save(us), HttpStatus.CREATED);
            } else{
                return new ResponseEntity<Usuarios>(ro.save(us),HttpStatus.OK);
            }

        }
    }
    public ResponseEntity<RespostaPadrao> remover(long id_user) {

        ro.deleteById(id_user);
        rp.setMensagem("O usuario foi removido com sucesso");
        return new ResponseEntity<RespostaPadrao>(rp, HttpStatus.OK);
    }
}
