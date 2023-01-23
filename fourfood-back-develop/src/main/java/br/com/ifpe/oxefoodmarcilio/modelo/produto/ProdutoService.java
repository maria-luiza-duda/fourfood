package br.com.ifpe.oxefoodmarcilio.modelo.produto;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodmarcilio.util.entity.GenericService;
import br.com.ifpe.oxefoodmarcilio.util.exception.EntityAlreadyExistsException;
import br.com.ifpe.oxefoodmarcilio.util.exception.produto.ProdutoException;

@Service
public class ProdutoService extends GenericService {

	@Autowired
	private ProdutoRepository repository;

	@Transactional
	public Produto save(Produto produto) {
		if (produto.getValorUnitario() < 10) {
		    throw new ProdutoException(ProdutoException.MSG_VALOR_MINIMO_PRODUTO);
		}
		
		super.preencherCamposAuditoria(produto);
		return repository.save(produto);
	}

	@Transactional
	public Produto findById(Long id) {
		return repository.findById(id).get();
	}

	@Transactional
	public List<Produto> consultarPorChaveEmpresa(String chaveEmpresa) {
		return repository.findByChaveEmpresaOrderByDescricaoAsc(chaveEmpresa);
	}

	@Transactional
	public Produto update(Long id, Produto produtoAlterado) {
		this.validarProdutoExistente(produtoAlterado, id);
		Produto produto = this.findById(id);
		produto.updateFrom(produtoAlterado);
		super.preencherCamposAuditoria(produto);

		repository.save(produto);
		
		return produto;
	}

	@Transactional
	public void delete(Long id) {
		Produto produto = this.findById(id);
		produto.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(produto);
		repository.save(produto);
	}

	private void validarProdutoExistente(Produto produtoParam, Long id) {
		if (StringUtils.isNotBlank(produtoParam.getDescricao())) {
			Produto produto = repository.findByChaveAndDescricao(produtoParam.getChaveEmpresa(),
					produtoParam.getDescricao());
			if (id == null) {
				if (produto != null) {
					throw new EntityAlreadyExistsException(Produto.LABEL, "Descrição");
				}
			} else {
				if (produto != null && produto.getId() != id) {
					throw new EntityAlreadyExistsException(Produto.LABEL, "Descrição");
				}
			}
		}
	}
}
