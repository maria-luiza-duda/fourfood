package br.com.ifpe.oxefoodmarcilio.util.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@MappedSuperclass
@EqualsAndHashCode(of = { "id" })
public abstract class EntidadeNegocio implements Serializable {

	private static final long serialVersionUID = -7435510029424995886L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonIgnore
    @NotNull
    @Column
    private Boolean habilitado;
}
