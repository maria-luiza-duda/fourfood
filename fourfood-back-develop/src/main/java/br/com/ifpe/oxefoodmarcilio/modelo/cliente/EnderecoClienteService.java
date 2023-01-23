package br.com.ifpe.oxefoodmarcilio.modelo.cliente;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodmarcilio.util.entity.GenericService;

@Service
public class EnderecoClienteService extends GenericService {

	@Autowired
	private EnderecoClienteRepository repository;

	@Autowired
	private ClienteService clienteService;

	@Transactional
	public EnderecoCliente save(Long clienteId, EnderecoCliente endereco) {
		Cliente cliente = clienteService.obterClientePorID(clienteId);

		endereco.setCliente(cliente);
		endereco.setHabilitado(Boolean.TRUE);
		repository.save(endereco);

		List<EnderecoCliente> listaEnderecoCliente = cliente.getEnderecos();

		if (listaEnderecoCliente == null) {
			listaEnderecoCliente = new ArrayList<EnderecoCliente>();
		}

		listaEnderecoCliente.add(endereco);
		cliente.setEnderecos(listaEnderecoCliente);
		clienteService.save(cliente);

		return endereco;
	}

	@Transactional
	public EnderecoCliente obterEnderecoPorClienteId(Long id) {
		return repository.findById(id).get();
	}

	@Transactional
	public EnderecoCliente atualizarEnderecoCliente(Long id, EnderecoCliente enderecoAlterado) {

		EnderecoCliente endereco = this.obterEnderecoPorClienteId(id);
		endereco.updateFrom(enderecoAlterado);
		return repository.save(endereco);
	}

	@Transactional
	public void removerEnderecoCliente(Long id) {

		EnderecoCliente endereco = this.obterEnderecoPorClienteId(id);
		endereco.setHabilitado(Boolean.FALSE);
		repository.save(endereco);

		Cliente cliente = clienteService.obterClientePorID(endereco.getId());
		cliente.getEnderecos().remove(endereco);
		clienteService.save(cliente);
	}

}
