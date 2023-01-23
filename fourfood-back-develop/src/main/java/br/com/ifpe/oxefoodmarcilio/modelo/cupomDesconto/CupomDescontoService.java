package br.com.ifpe.oxefoodmarcilio.modelo.cupomDesconto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodmarcilio.util.entity.GenericService;

@Service
public class CupomDescontoService extends GenericService {

	@Autowired
	private CupomDescontoRepository repository;

	@Transactional
	public CupomDesconto save(CupomDesconto cupomDesconto) {
		super.validarRegistroVazio(cupomDesconto.getCodigoDesconto(), "codigoDesconto");
		super.preencherCamposAuditoria(cupomDesconto);

		return repository.save(cupomDesconto);
	}

	@Transactional
	public CupomDesconto findById(Long id) {
		return repository.findById(id).get();
	}

	@Transactional
	public List<CupomDesconto> consultarPorChaveEmpresa(String chaveEmpresa) {
		return repository.findByChaveEmpresa(chaveEmpresa);
	}

	// 	// A funcionalidade de listar todos os CupomDesconto armazenados no banco
	@Transactional
	public List<CupomDesconto> consultar() {
		return repository.findAll();
	}

	
	@Transactional
	public void update(Long id, CupomDesconto cupomDescontoAlterado) {
		CupomDesconto cupomDesconto = this.findById(id);
		cupomDesconto.updateFrom(cupomDescontoAlterado);
		super.preencherCamposAuditoria(cupomDesconto );
		repository.save(cupomDesconto );
	}

	@Transactional
	public void delete(Long id) {
		CupomDesconto cupomDesconto = this.findById(id);
		cupomDesconto.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(cupomDesconto);
		repository.save(cupomDesconto);
	}

}
