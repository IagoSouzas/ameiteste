package com.amei.ameifinal.domei.repository;

import com.amei.ameifinal.domei.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface RepositorioEndereco extends CrudRepository<Endereco, Long> {
}
