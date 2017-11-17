package pt.javeiros.patinhas.modelo;

import java.io.Serializable;
import java.util.Date;

public class Utilizador implements Serializable {

	private static final long serialVersionUID = -5714696121125893248L;

	private String nome;
	private String nif;
	private String email;
	private Date dataNascimento;
	private String sexo;
	private String password;
	private String endereco;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getEndereco() {
		return password;
	}

	public void setEndereco(String password) {
		this.password = password;
	}
}
