package br.com.ifpe.oxefoodmarcilio.modelo.cupomDesconto;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import br.com.ifpe.oxefoodmarcilio.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CupomDesconto")
@Where(clause = "habilitado = true")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CupomDesconto extends EntidadeAuditavel {

	private static final long serialVersionUID = -506482202180118761L;
	public static final String LABEL = "CupomDesconto";
	
	String chaveEmpresa;
	String codigoDesconto;
	Double percentualDesconto;
	Double valorDesconto;
	Double valorMinimoPedidoPermitido;
	int quantidadeUso;
	
	public void updateFrom(CupomDesconto params) {
		this.setChaveEmpresa(params.getChaveEmpresa());
		this.setCodigoDesconto(params.getCodigoDesconto());
		this.setPercentualDesconto(params.getPercentualDesconto());
		this.setValorDesconto(params.getValorDesconto());
		this.setValorMinimoPedidoPermitido(params.getValorMinimoPedidoPermitido());
		this.setQuantidadeUso(params.getQuantidadeUso());
	}
	
}
