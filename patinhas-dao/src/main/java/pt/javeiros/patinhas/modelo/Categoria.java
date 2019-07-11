/**
 * 
 */
package pt.javeiros.patinhas.modelo;

/**
 * @author cahangoa
 *
 */
import java.util.Collection;

import javax.persistence.*;

import pt.javeiros.patinhas.dao.persistence.AbstractEntity;

@Entity
@Table(name="tb_categoria")
//@SequenceGenerator(name = "CAT_SEQ_ID", sequenceName = "CAT_SEQ_ID", allocationSize = 1)
public class Categoria extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	
	@Column(name = "cat_codigo", nullable = true, unique=true)
	private String codigo;

	@Column(name = "cat_descricao", nullable = true)
	private String descricao;
	
	@OneToMany(mappedBy = "categoria", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Raca> racas;

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

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
	 * @return the racas
	 */
	public Collection<Raca> getRacas() {
		return racas;
	}

	/**
	 * @param racas the racas to set
	 */
	public void setRacas(Collection<Raca> racas) {
		this.racas = racas;
	}
	

}
