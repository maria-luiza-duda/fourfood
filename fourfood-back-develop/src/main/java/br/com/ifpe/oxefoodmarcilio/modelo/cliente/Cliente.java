package br.com.ifpe.oxefoodmarcilio.modelo.cliente;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
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
@Table(name = "Cliente")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cliente extends EntidadeAuditavel {

	private static final long serialVersionUID = -2168789211116655513L;
	public static final String LABEL = "Cliente";

    @OneToMany(mappedBy = "cliente", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<EnderecoCliente> enderecos;

	@JsonIgnore
	@NotNull
	@Column(nullable = false)
	private String chaveEmpresa;

    @Column
    private String email;
	
	@NotNull
	@Column(nullable = false, length = 100)
	private String nome;

	@NotNull
	@Column(nullable = false, length = 20)
	private String cpf;

	@NotNull
	@Column(nullable = false, length = 20)
	private String fone;

	@NotNull
	@Column(nullable = false, length = 20)
	private String foneAlternativo;

	public void updateFrom(Cliente params) {
		this.setEnderecos(params.getEnderecos());
		this.setChaveEmpresa(params.getChaveEmpresa());
		this.setNome(params.getNome());
		this.setCpf(params.getCpf());
		this.setFone(params.getFone());
		this.setFoneAlternativo(params.getFoneAlternativo());
	}
}
