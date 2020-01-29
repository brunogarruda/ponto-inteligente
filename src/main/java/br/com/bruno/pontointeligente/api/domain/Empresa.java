package br.com.bruno.pontointeligente.api.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;

import lombok.Data;

@Entity
@Table(name = "empresa")
@Data
public class Empresa implements Serializable{

	private static final long serialVersionUID = -61931481282858591L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name = "razao_social", nullable = false)
	private String razaoSocial;
	
	@NotNull
	private String cnpj;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	@OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	private List<Funcionario> funcionarios;
	
	
	public Empresa() {
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}
}
