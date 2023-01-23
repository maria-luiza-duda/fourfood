package br.com.ifpe.oxefoodmarcilio.modelo.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EnderecoClienteRepository
		extends JpaRepository<EnderecoCliente, Long>, JpaSpecificationExecutor<EnderecoCliente> {

}
