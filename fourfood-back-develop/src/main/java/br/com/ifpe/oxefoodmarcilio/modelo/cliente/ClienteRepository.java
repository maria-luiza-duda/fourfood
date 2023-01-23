package br.com.ifpe.oxefoodmarcilio.modelo.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository
		extends JpaRepository<Cliente, Long>, JpaSpecificationExecutor<Cliente> {

	List<Cliente> findByChaveEmpresaOrderByNomeAsc(String chaveEmpresa);

	@Query(value = "SELECT c FROM Cliente c WHERE c.chaveEmpresa = :chaveEmpresa AND c.nome = :nome")
	Cliente findByChaveAndName(String chaveEmpresa, String nome);

	@Query(value = "SELECT c FROM Cliente c WHERE c.id = :id AND c.chaveEmpresa = :chaveEmpresa")
	Cliente findByIdAndChave(Long id, String chaveEmpresa);

}
