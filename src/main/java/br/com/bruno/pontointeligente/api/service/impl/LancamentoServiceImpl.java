package br.com.bruno.pontointeligente.api.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.bruno.pontointeligente.api.domain.Lancamento;
import br.com.bruno.pontointeligente.api.repository.LancamentoRepository;
import br.com.bruno.pontointeligente.api.service.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService{
	
	private static final Logger log = LoggerFactory.getLogger(LancamentoServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Override
	public Page<Lancamento> buscaPorFuncionario(Long funcionarioId, PageRequest pageRequest) {
		return lancamentoRepository.findByFuncionario_id(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscaPorId(Long id) {
		log.info("Retorna Lancamento pelo id: {}", id);
		return lancamentoRepository.findById(id);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		log.info("Persiste Lancamento: {}", lancamento);
		return lancamentoRepository.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		log.info("Remove um lancamento pelo id: {}", id);
		lancamentoRepository.deleteById(id);
		
	}

	
}
