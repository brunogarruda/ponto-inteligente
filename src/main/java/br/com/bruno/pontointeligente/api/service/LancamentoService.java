package br.com.bruno.pontointeligente.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.bruno.pontointeligente.api.domain.Lancamento;

@Service
public interface LancamentoService {
	
	Page<Lancamento> buscaPorFuncionario(Long funcionarioId, PageRequest pageRequest);

	Optional<Lancamento> buscaPorId(Long id);
	
	Lancamento persistir(Lancamento lancamento);
	
	void remover(Long id);
}
