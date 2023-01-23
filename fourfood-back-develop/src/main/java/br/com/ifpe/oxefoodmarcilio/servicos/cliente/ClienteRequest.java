package br.com.ifpe.oxefoodmarcilio.servicos.cliente;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import br.com.ifpe.oxefoodmarcilio.modelo.cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    @NotNull(message = "O Chave Empresa é de preenchimento obrigatório")
    @NotBlank(message = "O Chave Empresa é de preenchimento obrigatório")
    private String chaveEmpresa;

    @NotNull(message = "O Nome é de preenchimento obrigatório")
    @NotBlank(message = "O Nome é de preenchimento obrigatório")
    @Length(max = 100, message = "O Nome deverá ter no máximo {max} caracteres")
    private String nome;

    
    @NotNull(message = "O CPF é de preenchimento obrigatório")
    @NotBlank(message = "O CPF é de preenchimento obrigatório")
    @CPF
    private String cpf;

    @Length(min = 8, max = 20, message = "O campo Fone tem que ter entre {min} e {max} caracteres")
    private String fone;

    private String foneAlternativo;


	public Cliente buildCliente() {
		return Cliente.builder().chaveEmpresa(chaveEmpresa).nome(nome).cpf(cpf).fone(fone)
				.foneAlternativo(foneAlternativo).build();
	}

}
