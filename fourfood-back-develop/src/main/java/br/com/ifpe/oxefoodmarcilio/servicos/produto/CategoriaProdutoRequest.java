package br.com.ifpe.oxefoodmarcilio.servicos.produto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.ifpe.oxefoodmarcilio.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaProdutoRequest {

	private String chaveEmpresa;

	@Size(max = 1000)
	@NotNull
	@NotEmpty
	private String descricao;

	public Produto buildCategoriaProduto() {
		return Produto.builder().chaveEmpresa(chaveEmpresa).descricao(descricao).build();
	}
}
