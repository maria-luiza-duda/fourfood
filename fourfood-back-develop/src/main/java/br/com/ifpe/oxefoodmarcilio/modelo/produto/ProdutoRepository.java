package br.com.ifpe.oxefoodmarcilio.modelo.produto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository
		extends JpaRepository<Produto, Long>, JpaSpecificationExecutor<Produto> {

	List<Produto> findByChaveEmpresaOrderByDescricaoAsc(String chaveEmpresa);

	@Query(value = "SELECT c FROM Produto c WHERE c.chaveEmpresa = :chaveEmpresa AND c.descricao = :descricao")
	Produto findByChaveAndDescricao(String chaveEmpresa, String descricao);

	@Query(value = "SELECT c FROM Produto c WHERE c.id = :id AND c.chaveEmpresa = :chaveEmpresa")
	Produto findByIdAndChave(Long id, String chaveEmpresa);

}
