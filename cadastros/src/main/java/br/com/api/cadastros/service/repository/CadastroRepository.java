package br.com.api.cadastros.service.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.cadastros.model.CadastroModel;

@Repository
public interface CadastroRepository extends CrudRepository<CadastroModel,Long> {
    
}
