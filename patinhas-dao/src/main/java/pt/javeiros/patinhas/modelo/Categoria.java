package pt.javeiros.patinhas.modelo;

import java.io.Serializable;
import java.util.Date;

public class Categoria implements Serializable {

	private static final long serialVersionUID = -5714696121125893248L;

	private Long id;

	private String codigo;

	private String descricao;

	private String observacao;

	public String getDescricao() {		return descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
