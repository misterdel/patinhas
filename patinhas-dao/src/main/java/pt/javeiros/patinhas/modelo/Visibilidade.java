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
@Table(name="tb_visibilidade")
public class Visibilidade extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	
	@Column(name = "vis_descricao", nullable = true, unique=true)
	private String descricao;

	@Column(name = "vis_obs", nullable = false)
	private String obs;
	
	@OneToMany(mappedBy = "visibilidade", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Perfil> perfil;

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
	 * @return the obs
	 */
	public String getObs() {
		return obs;
	}

	/**
	 * @param obs the obs to set
	 */
	public void setObs(String obs) {
		this.obs = obs;
	}

	/**
	 * @return the perfil
	 */
	public Collection<Perfil> getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(Collection<Perfil> perfil) {
		this.perfil = perfil;
	}


}
