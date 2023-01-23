package br.com.ifpe.oxefoodmarcilio.servicos.produto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodmarcilio.modelo.produto.CategoriaProdutoService;
import br.com.ifpe.oxefoodmarcilio.modelo.produto.Produto;
import br.com.ifpe.oxefoodmarcilio.modelo.produto.ProdutoService;
import br.com.ifpe.oxefoodmarcilio.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController extends GenericController {

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private CategoriaProdutoService categoriaProdutoService;

	@ApiOperation(value = "Serviço responsável por salvar um produto no sistema.")
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {
		super.validarPreenchimentoChave(request.getChaveEmpresa());
		Produto produto = request.buildProduto();
		produto.setCategoria(categoriaProdutoService.obterPorCategoriaProdutoId(request.getIdCategoria()));
		Produto produtoInserido = produtoService.save(produto);
		return new ResponseEntity<Produto>(produtoInserido, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Serviço responsável por obter um produto referente ao Id passado na URL.")
	@GetMapping("/{id}")
	public Produto get(@PathVariable Long id) {
		return produtoService.findById(id);
	}

	@ApiOperation(value = "Serviço responsável por obter uma lista de produto da empresa passado na URL.")
	@GetMapping("/porempresa/{chaveEmpresa}")
	public List<Produto> consultarPorChaveEmpresa(@PathVariable String chaveEmpresa) {
		return produtoService.consultarPorChaveEmpresa(chaveEmpresa);
	}

	@ApiOperation(value = "Serviço responsável por atualizar as informações do produto no sistema.")
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

	   Produto produto = request.buildProduto();
	   produto.setCategoria(categoriaProdutoService.obterPorCategoriaProdutoId(request.getIdCategoria()));
	   Produto produtoAtualizado = produtoService.update(id, produto);
		
	   return new ResponseEntity<Produto>(produtoAtualizado, HttpStatus.OK);
	}


	@ApiOperation(value = "Rota responsável por remover(exclusão lógica) de um produto do sistema.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		produtoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
