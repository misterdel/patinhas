package pt.javeiros.patinhas.modelo;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = -5714696121125893248L;

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
