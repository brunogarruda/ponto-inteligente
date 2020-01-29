package br.com.bruno.pontointeligente.api.repository;

import javax.transaction.Transactional;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.pontointeligente.api.domain.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	@Transactional
	@ReadOnlyProperty
	Empresa findByCnpj(String cnpj);

}
