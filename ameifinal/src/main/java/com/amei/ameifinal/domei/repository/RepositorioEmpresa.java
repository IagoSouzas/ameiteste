package com.amei.ameifinal.domei.repository;

import com.amei.ameifinal.domei.model.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioEmpresa extends CrudRepository<Empresa, Long> {

}
