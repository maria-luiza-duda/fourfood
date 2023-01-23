package br.com.ifpe.oxefoodmarcilio.modelo.produto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefoodmarcilio.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Produto")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Produto extends EntidadeAuditavel {

	private static final long serialVersionUID = -9200344334923335616L;
	public static final String LABEL = "Produto";

	@ManyToOne
	@JoinColumn
	private CategoriaProduto categoria;

	@JsonIgnore
	@NotNull
	@Column(nullable = false)
	private String chaveEmpresa;

	@NotNull
	@Column(nullable = false, length = 100)
	private String codigo;

	@NotNull
	@Column(nullable = false, length = 100)
	private String titulo;

	@NotNull
	@Column(nullable = false, length = 100)
	private String descricao;

	@NotNull
	@Column(nullable = false)
	double valorUnitario;

	public void updateFrom(Produto param) {
		this.setCategoria(param.getCategoria());
		this.setChaveEmpresa(param.getChaveEmpresa());
		this.setCodigo(param.getCodigo());
		this.setTitulo(param.getTitulo());
		this.setDescricao(param.getDescricao());
		this.setValorUnitario(param.getValorUnitario());
	}
}
