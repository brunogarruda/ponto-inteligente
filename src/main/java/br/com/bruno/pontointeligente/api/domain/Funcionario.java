package br.com.bruno.pontointeligente.api.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import br.com.bruno.pontointeligente.api.enums.PerfilEnum;
import lombok.Data;

@Entity
@Table(name = "funcionario")
@Data
public class Funcionario implements Serializable {

	private static final long serialVersionUID = -8367096884728955187L;

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	private String nome;
	
	@NotNull
	private String email;
	
	@NotNull
	private String senha;
	
	@NotNull
	private String cpf;
	
	@Column(name = "valor_hora", nullable = true)
	private BigDecimal valorHora;
	
	@Column(name = "qtd_horas_trabalho_dia", nullable = true)
	private Double qtdHorasTrabalhoDia;
	
	@Column(name = "qtd_horas_almocao", nullable = true)
	private Double qtdHorasAlmoco;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	private PerfilEnum perfil;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	
	@OneToMany(mappedBy = "funcionario", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;
	
	
	public Funcionario() {
	}
	
	@Transient
	public Optional<BigDecimal> getValorHoraOpt() {
		return Optional.ofNullable(valorHora);
	}
	
	@Transient
	public Optional<Double> getQtdHorasTrabalhoDiaOpt() {
		return Optional.ofNullable(qtdHorasTrabalhoDia);
	}
	
	@Transient
	public Optional<Double> getQtdHorasAlmocoOpt() {
		return Optional.ofNullable(qtdHorasAlmoco);
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
