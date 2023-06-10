package com.amei.ameifinal.domei.repository;

import com.amei.ameifinal.domei.model.Usuarios;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuarios, Long> {

}
