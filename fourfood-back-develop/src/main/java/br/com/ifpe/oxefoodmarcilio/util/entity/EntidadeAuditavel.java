package br.com.ifpe.oxefoodmarcilio.util.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeAuditavel extends EntidadeNegocio {
	
	private static final long serialVersionUID = -6814558667161260365L;
	
	@JsonIgnore
	@Version
	private Long versao;

	@JsonIgnore
	@CreatedDate
	private LocalDate dataCriacao;

	@JsonIgnore
	@LastModifiedDate
	private LocalDate dataUltimaModificacao;

	@JsonIgnore
	@Column
	private Long criadoPor;

	@JsonIgnore
	@Column
	private Long ultimaModificacaoPor;
}
