package br.com.ifpe.oxefoodmarcilio.modelo.empresa;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefoodmarcilio.util.entity.GenericService;
import br.com.ifpe.oxefoodmarcilio.util.exception.EntityAlreadyExistsException;

@Service
public class EmpresaService extends GenericService {
	@Autowired
	private EmpresaRepository repository;

	@Transactional
	public Empresa save(Empresa empresa) {
		super.validarRegistroVazio(empresa.getNomeEmpresarial(), "nomeEmpresarial");
		this.validarEmpresaExistente(empresa, null);
		super.preencherCamposAuditoria(empresa);
		return repository.save(empresa);
	}

	@Transactional
	public Empresa findById(Long id) {
		return repository.findById(id).get();
	}

	@Transactional
	public List<Empresa> consultarPorChave(String chave) {
		return repository.findByChaveOrderByNomeEmpresarialAsc(chave);
	}

	@Transactional
	public void update(Long id, Empresa empresaAlterada) {
		validarEmpresaExistente(empresaAlterada, id);
		Empresa empresa = this.findById(id);
		empresa.updateFrom(empresaAlterada);
		super.preencherCamposAuditoria(empresa);
		repository.save(empresa);
	}

	@Transactional
	public void delete(Long id) {
		Empresa empresa = this.findById(id);
		empresa.setHabilitado(Boolean.FALSE);
		super.preencherCamposAuditoria(empresa);
		repository.save(empresa);
	}

	private void validarEmpresaExistente(Empresa empresaParam, Long id) {
		if (StringUtils.isNotBlank(empresaParam.getNomeEmpresarial())) {
			Empresa empresa = repository.findByChaveAndName(empresaParam.getChave(), empresaParam.getNomeEmpresarial());
			if (id == null) {
				if (empresa != null) {
					throw new EntityAlreadyExistsException(Empresa.LABEL, "NomeEmpresarial");
				}
			} else {
				if (empresa != null && empresa.getId() != id) {
					throw new EntityAlreadyExistsException(Empresa.LABEL, "NomeEmpresarial");
				}
			}
		}
	}
}
