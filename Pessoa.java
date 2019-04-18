package br.co.bd2hibernet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pessoas")
public class Pessoa {
	@Id
	@Column(name = "idPessoa")
	Integer pessoaId;

	@Column(name = "userName")
	String userName;

	@Column(name = "cpf", length = 13, nullable = false)
	String cpf;

	public Pessoa(String userName, String cpf) {
		super();
		this.userName = userName;
		this.cpf = cpf;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	@Column(name = "idPessoa")
	public Integer getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(Integer pessoaId) {
		this.pessoaId = pessoaId;
	}

}
