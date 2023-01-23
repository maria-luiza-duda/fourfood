package br.com.ifpe.oxefoodmarcilio.modelo.empresa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>, JpaSpecificationExecutor<Empresa> {

	List<Empresa> findByChaveOrderByNomeEmpresarialAsc(String chave);

	@Query(value = "SELECT e FROM Empresa e WHERE e.chave= :chave AND e.nomeEmpresarial = :nomeEmpresarial")
	Empresa findByChaveAndName(String chave, String nomeEmpresarial);

	@Query(value = "SELECT e FROM Empresa e WHERE e.id = :id AND e.chave = :chave")
	Empresa findByIdAndChave(Long id, String chave);
}
