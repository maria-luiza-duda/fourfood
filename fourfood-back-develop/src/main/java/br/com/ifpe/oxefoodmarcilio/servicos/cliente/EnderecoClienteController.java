package br.com.ifpe.oxefoodmarcilio.servicos.cliente;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefoodmarcilio.modelo.cliente.EnderecoCliente;
import br.com.ifpe.oxefoodmarcilio.modelo.cliente.EnderecoClienteService;
import br.com.ifpe.oxefoodmarcilio.util.entity.GenericController;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoClienteController extends GenericController {

	@Autowired
	private EnderecoClienteService enderecoService;

	@ApiOperation(value = "Rota responsável por adicionar um endereço a um cliente já existente.")
	@PostMapping("/{clienteId}")
	public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(@RequestBody @Valid EnderecoClienteRequest request,
			@PathVariable("clienteId") Long clienteId) {
		System.out.println(request);

		EnderecoCliente endereco = enderecoService.save(clienteId, request.buildEndereco());
		return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.CREATED);
	}

	@ApiOperation(value = "Rota responsável por atualizar o endereço de um determinado cliente")
	@PutMapping("/{id}")
	public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("id") Long id,
			@RequestBody EnderecoClienteRequest request) {

		EnderecoCliente endereco = enderecoService.atualizarEnderecoCliente(id, request.buildEndereco());
		return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.OK);
	}

	@ApiOperation(value = "Rota responsável por remover um endereço de um determinado cliente")
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> removerEnderecoCliente(@PathVariable Long id) {

		enderecoService.removerEnderecoCliente(id);
		return ResponseEntity.noContent().build();
	}

}
