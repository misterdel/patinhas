package pt.javeiros.patinhas.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_utilizador")
public class Utilizador implements Serializable {

	private static final long serialVersionUID = -5714696121125893248L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = true)
	private Integer id;

	@Lob
	@Column(name = "util_foto", nullable = true)
	private byte[] foto;

	@Column(name = "util_nif", nullable = true, unique = true)
	private String nif;

	@Column(name = "util_email", nullable = true)
	private String email;

	@Column(name = "util_nome", nullable = true)
	private String nome;

	@Column(name = "util_apelido", nullable = true)
	private String apelido;

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

	@Column(name = "util_dataNascimento", nullable = true)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column(name = "util_sexo", nullable = true)
	private String sexo;

	@Column(name = "util_password", nullable = true)
	private String password;

	@Column(name = "util_endereco", nullable = true)
	private String endereco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}


}
