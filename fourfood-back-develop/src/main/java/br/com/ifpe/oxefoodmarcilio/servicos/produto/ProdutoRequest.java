package br.com.ifpe.oxefoodmarcilio.servicos.produto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefoodmarcilio.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

	@NotEmpty
	@NotNull
	private Long idCategoria;

	@JsonIgnore
	@NotNull
	private String chaveEmpresa;

	@Size(max = 255)
	@NotNull
	private String codigo;

	@Size(max = 255)
	@NotNull
	private String titulo;

	@NotNull
	@NotEmpty
	double valorUnitario;

	@Size(max = 1000)
	@NotNull
	@NotEmpty
	private String descricao;

	public Produto buildProduto() {
		return Produto.builder().codigo(codigo).chaveEmpresa(chaveEmpresa).descricao(descricao).titulo(titulo)
				.valorUnitario(valorUnitario).build();
	}
}
