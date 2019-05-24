package pt.javeiros.patinhas.modelo;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name="tb_categoria")
public class Categoria implements Serializable {

	private static final long serialVersionUID = -5714696121125893248L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "cat_codigo", nullable = true)
	private String codigo;

	@Column(name = "cat_descricao", nullable = true)
	private String descricao;

	@Column(name = "cat_observacao", nullable = true)
	private String observacao;
	
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Raca> racas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Collection<Raca> getRacas() {
		return racas;
	}

	public void setRacas(Collection<Raca> racas) {
		this.racas = racas;
	}

}
