package br.com.ifpe.oxefoodmarcilio.servicos.cliente;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.ifpe.oxefoodmarcilio.modelo.cliente.EnderecoCliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoClienteRequest {

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 255)
	private String rua;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 8)
	private String numero;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 50)
	private String bairro;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 10)
	private String cep;

	@NotNull
	@NotEmpty
	@Length(min = 1, max = 50)
	private String cidade;

	@NotNull
	@NotEmpty
	@Length(min = 2, max = 2, message = "Insira a sigla do seu estado")
	private String estado;

	@Length(max = 255)
	private String complemento;

	public EnderecoCliente buildEndereco() {

		return EnderecoCliente.builder().rua(rua).numero(numero).cep(cep).bairro(bairro).cidade(cidade).estado(estado)
				.complemento(complemento).build();
	}
}
