package pt.javeiros.patinhas.modelo;

import java.util.Date;

import javax.persistence.*;
import pt.javeiros.patinhas.dao.persistence.AbstractEntity;

@Entity
@Table(name = "tb_utilizador")
public class Utilizador extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Column(name = "util_nome", nullable = true)
	private String nome;

	@Column(name = "util_foto", nullable = false)
	private String srcFoto;

	@Column(name = "util_apelido", nullable = true)
	private String apelido;

	@Column(name = "util_nif", nullable = true, unique = true)
	private Long nif;

	@Column(name = "util_password", nullable = true)
	private String password;

	@Column(name = "util_email", nullable = true)
	private String email;

	@Column(name = "util_dataNascimento", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "util_sexo", nullable = true)
	private String sexo;

	@Column(name = "util_localidade", nullable = true)
	private String localidade;

	@Column(name = "util_codigoPostal", nullable = true)
	private String codigoPostal;

	@Column(name = "util_freguesia", nullable = true) // tabela
	private String freguesia;

	@Column(name = "util_conselho", nullable = true) // tabela
	private String conselho;

	@Column(name = "util_destrito", nullable = true) // tabela
	private String destrito;

	@Column(name = "util_endereco", nullable = true)
	private String endereco;

	@ManyToOne
	@JoinColumn(name = "id_perfil")
	private Perfil perfil;

	@Column(name = "util_dataRegisto", nullable = true, length = 19)
	@Temporal(TemporalType.TIMESTAMP) // private Date ultimoAcesso;
	private Date util_dataRegisto = new java.sql.Date(System.currentTimeMillis());

	@Column(name = "util_ultimoAcesso", length = 19)
	@Temporal(TemporalType.TIMESTAMP) // private Date ultimoAcesso;
	private Date util_ultimoAcesso;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public Long getNif() {
		return nif;
	}

	public void setNif(Long nif) {
		this.nif = nif;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getFreguesia() {
		return freguesia;
	}

	public void setFreguesia(String freguesia) {
		this.freguesia = freguesia;
	}

	public String getConselho() {
		return conselho;
	}

	public void setConselho(String conselho) {
		this.conselho = conselho;
	}

	public String getDestrito() {
		return destrito;
	}

	public void setDestrito(String destrito) {
		this.destrito = destrito;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Date getUtil_dataRegisto() {
		return util_dataRegisto;
	}

	public void setUtil_dataRegisto(Date util_dataRegisto) {
		this.util_dataRegisto = util_dataRegisto;
	}

	public Date getUtil_ultimoAcesso() {
		return util_ultimoAcesso;
	}

	public void setUtil_ultimoAcesso(Date util_ultimoAcesso) {
		this.util_ultimoAcesso = util_ultimoAcesso;
	}

	/**
	 * @return the perfil
	 */
	public Perfil getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil
	 *            the perfil to set
	 */
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getSrcFoto() {
		return srcFoto;
	}

	public void setSrcFoto(String srcFoto) {
		this.srcFoto = srcFoto;
	}
}
