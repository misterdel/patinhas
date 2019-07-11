/**
 * 
 */
package pt.javeiros.patinhas.modelo;

import javax.persistence.*;

import pt.javeiros.patinhas.dao.persistence.AbstractEntity;
import java.util.Collection;

/**
 * @author cahangoa
 *
 */
@Entity
@Table(name = "tb_raca")
public class Raca  extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "rac_descricao", nullable = true)
	private String descricao;

	@OneToMany(mappedBy = "raca", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Animal> animais;

	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @return the animais
	 */
	public Collection<Animal> getAnimais() {
		return animais;
	}

	/**
	 * @param animais the animais to set
	 */
	public void setAnimais(Collection<Animal> animais) {
		this.animais = animais;
	}

	/**
	 * @return the categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	
	
}
