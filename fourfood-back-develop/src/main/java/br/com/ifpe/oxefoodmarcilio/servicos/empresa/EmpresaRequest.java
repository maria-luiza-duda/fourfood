package br.com.ifpe.oxefoodmarcilio.servicos.empresa;

import br.com.ifpe.oxefoodmarcilio.modelo.empresa.Empresa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaRequest {

	private String chave;

	private String site;

	private String cnpj;

	private String inscricaoEstadual;

	private String nomeEmpresarial;

	private String nomeFantasia;

	private String fone;

	private String foneAlternativo;

	public Empresa buildEmpresa() {
		return Empresa.builder().chave(chave).site(site).cnpj(cnpj).inscricaoEstadual(inscricaoEstadual)
				.nomeEmpresarial(nomeEmpresarial).nomeFantasia(nomeFantasia).fone(fone).foneAlternativo(foneAlternativo)
				.build();
	}

}
