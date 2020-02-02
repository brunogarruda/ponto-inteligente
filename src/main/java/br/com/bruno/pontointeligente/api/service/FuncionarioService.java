package br.com.bruno.pontointeligente.api.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.bruno.pontointeligente.api.domain.Funcionario;

@Service
public interface FuncionarioService {
	
	Funcionario persistir(Funcionario funcionario);
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	Optional<Funcionario> buscarPorEmail(String email);
	
	Optional<Funcionario> buscarPorId(Long id);
}
