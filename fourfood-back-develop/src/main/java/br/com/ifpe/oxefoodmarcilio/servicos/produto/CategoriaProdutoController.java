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

import br.com.ifpe.oxefoodmarcilio.modelo.produto.Produto;
import br.com.ifpe.oxefoodmarcilio.modelo.produto.ProdutoService;
import br.com.ifpe.oxefoodmarcilio.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/categoriaproduto")
public class CategoriaProdutoController extends GenericController {

	@Autowired
	private ProdutoService categoriaProdutoService;

	@ApiOperation(value = "Serviço responsável por salvar uma categoria de produto no sistema.")
	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody @Valid CategoriaProdutoRequest request) {
		super.validarPreenchimentoChave(request.getChaveEmpresa());
		Produto categoriaProduto = categoriaProdutoService.save(request.buildCategoriaProduto());
		return new ResponseEntity<Produto>(categoriaProduto, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Serviço responsável por obter uma categoria de produto referente ao Id passado na URL.")
	@GetMapping("/{id}")
	public Produto get(@PathVariable Long id) {
		return categoriaProdutoService.findById(id);
	}

	@ApiOperation(value = "Serviço responsável por obter uma lista de categorias de produto da empresa passado na URL.")
	@GetMapping("/porempresa/{chaveEmpresa}")
	public List<Produto> consultarPorChaveEmpresa(@PathVariable String chaveEmpresa) {
		return categoriaProdutoService.consultarPorChaveEmpresa(chaveEmpresa);
	}

	@ApiOperation(value = "Serviço responsável por atualizar as informações da categoria de produto no sistema.")
	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable("id") Long id,
			@RequestBody CategoriaProdutoRequest request) {
		categoriaProdutoService.update(id, request.buildCategoriaProduto());
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Rota responsável por remover(exclusão lógica) uma categoria de produto do sistema.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		categoriaProdutoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
