package br.com.bruno.pontointeligente.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bruno.pontointeligente.api.domain.Empresa;
import br.com.bruno.pontointeligente.api.repository.EmpresaRepository;
import br.com.bruno.pontointeligente.api.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{
	
	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Empresa buscaPorCnpj(String cnpj) {
		log.info("Buscando empresa por cnpj: {}", cnpj);
		Empresa empresa = empresaRepository.findByCnpj(cnpj);
		return empresa;
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		log.info("Persistindo uma empresa na base: {}", empresa);
		return empresaRepository.save(empresa);
	}

}
