package br.com.bruno.pontointeligente.api.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.pontointeligente.api.domain.Lancamento;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{
	
	List<Lancamento> findByFuncionario_id(Long id);
	
	Page<Lancamento> findByFuncionario_id(Long id, Pageable pageable);

}
