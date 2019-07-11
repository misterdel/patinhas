/**
 * 
 */
package pt.javeiros.patinhas.modelo;

import java.util.Collection;

import javax.persistence.*;

import pt.javeiros.patinhas.dao.persistence.AbstractEntity;

/**
 * @author cahangoa
 *
 */
@Entity
@Table(name = "tb_perfil")
public class Perfil  extends AbstractEntity {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "per_descricao", nullable = true)
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "id_visibilidade")
	private Visibilidade visibilidade;
	
	@Column(name = "per_obs", nullable = true)
	private String obs;


	@OneToMany(mappedBy = "perfil", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
	private Collection<Utilizador> utilizadores;
	
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
	 * @return the visibilidade
	 */
	public Visibilidade getVisibilidade() {
		return visibilidade;
	}


	/**
	 * @param visibilidade the visibilidade to set
	 */
	public void setVisibilidade(Visibilidade visibilidade) {
		this.visibilidade = visibilidade;
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
	 * @return the utilizadores
	 */
	public Collection<Utilizador> getUtilizadores() {
		return utilizadores;
	}


	/**
	 * @param utilizadores the utilizadores to set
	 */
	public void setUtilizadores(Collection<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}
	


}
