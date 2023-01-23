package br.com.ifpe.oxefoodmarcilio.servicos.cupomDesconto;

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

import br.com.ifpe.oxefoodmarcilio.modelo.cupomDesconto.CupomDesconto;
import br.com.ifpe.oxefoodmarcilio.modelo.cupomDesconto.CupomDescontoService;
import br.com.ifpe.oxefoodmarcilio.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/cupom")
public class CupomDescontoController extends GenericController {
	
	@Autowired
	private CupomDescontoService service;
	
	@ApiOperation(value = "Serviço responsável por salvar um cupom de desconto no sistema.")
	@PostMapping
	public ResponseEntity<CupomDesconto> save(@RequestBody @Valid CupomDescontoRequest request) {
		System.out.println(request);
		super.validarPreenchimentoChave(request.getChaveEmpresa());
		CupomDesconto cupomDesconto = service.save(request.buildCupomDesconto());
		return new ResponseEntity<CupomDesconto>(cupomDesconto, HttpStatus.CREATED);
	}
	
	@ApiOperation(value = "Serviço responsável por obter um cupom de desconto referente ao Id passado na URL.")
	@GetMapping("/{id}")
	public CupomDesconto get(@PathVariable Long id) {
		return service.findById(id);
	}
	
	@ApiOperation(value = "Serviço responsável por obter um cupom de desconto referente a chave passada na URL.")
	@GetMapping
	public List<CupomDesconto> consultar() {
		return service.consultar();
	}

	@ApiOperation(value = "Serviço responsável por obter um cupom de desconto referente a chave passada na URL.")
	@GetMapping("/porchave/{chaveEmpresa}")
	public List<CupomDesconto> consultarPorChaveEmpresa(@PathVariable String chaveEmpresa) {
		return service.consultarPorChaveEmpresa(chaveEmpresa);
	}
	
	@ApiOperation(value = "Serviço responsável por atualizar as informações de um cupom de desconto no sistema.")
	@PutMapping("/{id}")
	public ResponseEntity<CupomDesconto> update(@PathVariable("id") Long id, @RequestBody CupomDescontoRequest request) {
		service.update(id, request.buildCupomDesconto());
		return ResponseEntity.ok().build();
	}

	@ApiOperation(value = "Rota responsável por remover(exclusão lógica) de um cupom de desconto do sistema.")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
