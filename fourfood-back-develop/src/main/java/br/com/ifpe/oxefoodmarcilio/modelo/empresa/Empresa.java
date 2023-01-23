package br.com.ifpe.oxefoodmarcilio.modelo.empresa;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "Empresa")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Empresa extends EntidadeAuditavel {

	private static final long serialVersionUID = -1391900242151423745L;
	public static final String LABEL = "Empresa";

	@JsonIgnore
	@NotNull
	@Column(nullable = false)
	private String chave;
	
	@NotNull
	@Column(nullable = false, length = 100)
	private String site;
	
	@NotNull
	@Column(nullable = false, length = 18)
	private String cnpj;
	
	
	@NotNull
	@Column(nullable = false, length = 10)
	private String inscricaoEstadual;
	
	@NotNull
	@Column(nullable = false, length = 50)
	private String nomeEmpresarial;
	
	@NotNull
	@Column(nullable = false, length = 100)
	private String nomeFantasia;
	
	@NotNull
	@Column(nullable = false, length = 20)
	private String fone;
	
	@NotNull
	@Column(nullable = false, length = 20)
	private String foneAlternativo;	
	
	public void updateFrom(Empresa params) {
		this.setSite(params.getSite());
		this.setCnpj(params.getCnpj());
		this.setInscricaoEstadual(params.getInscricaoEstadual());
		this.setNomeEmpresarial(params.getNomeEmpresarial());
		this.setNomeFantasia(params.getNomeFantasia());
		this.setFone(params.getFone());
		this.setFoneAlternativo(params.getFoneAlternativo());
	}
}
