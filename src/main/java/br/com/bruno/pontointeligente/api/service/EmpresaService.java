package br.com.bruno.pontointeligente.api.service;

import org.springframework.stereotype.Service;

import br.com.bruno.pontointeligente.api.domain.Empresa;

@Service
public interface EmpresaService {
	
	Empresa buscaPorCnpj (String cnpj);
	
	Empresa persistir (Empresa empresa);

}
