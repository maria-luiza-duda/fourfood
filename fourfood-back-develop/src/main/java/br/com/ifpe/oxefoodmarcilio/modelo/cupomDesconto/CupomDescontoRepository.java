package br.com.ifpe.oxefoodmarcilio.modelo.cupomDesconto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import br.com.ifpe.oxefoodmarcilio.modelo.cliente.Cliente;

public interface CupomDescontoRepository
			extends JpaRepository<CupomDesconto, Long>, JpaSpecificationExecutor<CupomDesconto> {
	
	// A funcionalidade de consultar um CupomDesconto por ID
	@Query(value = "SELECT c FROM CupomDesconto c WHERE c.id = :id")
	CupomDesconto findByIdAndChave(Long id);
	
	
	// A funcionalidade de listar os CupomDesconto de uma determinada chaveEmpresa
	List<CupomDesconto> findByChaveEmpresa(String chaveEmpresa);

	// A funcionalidade de listar todos os CupomDesconto armazenados no banco
	@Query(value = "SELECT c FROM CupomDesconto c")
	Cliente findByCupomDesconto();
}

