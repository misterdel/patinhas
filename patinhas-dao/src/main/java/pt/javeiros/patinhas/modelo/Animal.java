/**
 * 
 */
package pt.javeiros.patinhas.modelo;

import java.util.Date;

import javax.persistence.*;

import pt.javeiros.patinhas.dao.persistence.AbstractEntity;
import pt.javeiros.patinhas.modelo.enums.*;

/**
 * @author cahangoa
 *
 */
@Entity
@Table(name = "tb_animal")
public class Animal extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "ani_nome", nullable = true)
	private String nome;
	
	/**@Column(name = "ani_idade", nullable = true)
	@Enumerated(EnumType.STRING)
	private Idade idade;
	
	@Column(name = "ani_porte", nullable = true) // tamanho
	@Enumerated(EnumType.STRING)
	private Porte porte;*/
	
	@ManyToOne
	@JoinColumn(name = "id_raca")
	private Raca raca;

	@Column(name = "ani_cor", nullable = true)
	private String cor;
	
	@Column(name = "ani_situacaoClinica", nullable = true)
	private String situacaoClinica;

	@Column(name = "ani_comentario", nullable = true)
	private String comentario;

	@Column(name = "ani_obs", nullable = false)
	private String obs;

	@Temporal(TemporalType.DATE)
	@Column(name = "ani_dataRegisto", length = 15)
	private Date dataNascimento;
	
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the raca
	 */
	public Raca getRaca() {
		return raca;
	}

	/**
	 * @param raca the raca to set
	 */
	public void setRaca(Raca raca) {
		this.raca = raca;
	}

	/**
	 * @return the cor
	 */
	public String getCor() {
		return cor;
	}

	/**
	 * @param cor the cor to set
	 */
	public void setCor(String cor) {
		this.cor = cor;
	}

	/**
	 * @return the situacaoClinica
	 */
	public String getSituacaoClinica() {
		return situacaoClinica;
	}

	/**
	 * @param situacaoClinica the situacaoClinica to set
	 */
	public void setSituacaoClinica(String situacaoClinica) {
		this.situacaoClinica = situacaoClinica;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
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
	 * @return the dataNascimento
	 */
	public Date getDataNascimento() {
		return dataNascimento;
	}

	/**
	 * @param dataNascimento the dataNascimento to set
	 */
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
