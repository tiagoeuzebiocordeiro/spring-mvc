package curso.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import curso.springmvc.model.Pessoa;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public interface PessoaRepository extends CrudRepository<Pessoa, Long> {

	@Query("select p from Pessoa p where p.nome like %?1%")
	List<Pessoa> buscaPessoaPeloNome(String nome);
	
}
