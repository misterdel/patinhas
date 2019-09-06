package pt.javeiros.patinhas.view.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.*;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import pt.javeiros.patinhas.modelo.Perfil;
import pt.javeiros.patinhas.modelo.Utilizador;
import pt.javeiros.patinhas.service.UtilizadorService;
import pt.javeiros.patinhas.util.UtilObjeto;
import pt.javeiros.patinhas.view.util.UtilConverter;
import pt.javeiros.patinhas.view.util.UtilMensagem;

@ViewScoped
@ManagedBean(name = "utilBean")
/**
 * @Named(value = "utilBean")
 * @SessionScoped
 */
public class UtilizadorController implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject UtilizadorService utilizadorService;
	private @Inject PerfilController perfilController;

	private Utilizador utilizador;

	private Utilizador utilSelect;

	private List<Utilizador> utilizadores;
	private List<Perfil> perfis;
	private List<Utilizador> filteredUtilizadores;
	
	private UploadedFile sfcFotoFile;

	private boolean consulta;

	@PostConstruct
	public void init() {
		consulta = true;
		utilizadores = new LinkedList<Utilizador>();
		utilizadores = getAllUtilizadores();
		perfis = perfilController.getAllPerfis();
	}

	/**
	 * método para obter o utilizador pelo nif
	 * 
	 * @param nif
	 * @return
	 */
	public Utilizador getUtilizadorPorNif(Long nif) {

		if (UtilObjeto.isNotNull(nif)) {
			if (UtilConverter.validaNif(nif)) {
				Utilizador util = utilizadorService.findByNif(nif);
				return UtilObjeto.isNotNull(util) ? util : null;
			} else {
				return null;
			}
		} else {
			return null;
		}

	}

	/**
	 * método responsável por salvar o novo utilizador
	 */
	public void save() {

		if (UtilObjeto.isNotNull(this.utilizador)) {

			if (UtilConverter.validaNif(this.utilizador.getNif())) {

				if (UtilObjeto.isNull(getUtilizadorPorNif(this.utilizador.getNif()))) {
					// converter a password em MD5
					String passIncriptada = UtilConverter.convertStringToMd5(this.utilizador.getPassword());

					if (UtilObjeto.isNotNull(passIncriptada)) {
						this.utilizador.setPassword(passIncriptada);
						this.utilizador.setSrcFoto(this.utilizador.getNif()+"/"+sfcFotoFile.getFileName());
						utilizadorService.save(utilizador);
						UtilMensagem.adicionarMensagemSucesso("Utilizador salvo com sucesso !");

					} else {
						UtilMensagem.adicionarMensagemErro("Erro ao incriptar a password!");
					}

				} else {
					utilizadorService.update(utilizador);
					UtilMensagem.adicionarMensagemSucesso("Utilizador actualizado com sucesso !");
				}
			} else {

				UtilMensagem.adicionarMensagemErro("Nif inválido!");
			}

		} else {
			UtilMensagem.adicionarMensagemErro("Erro, o utilizador com dados incorretos!");
		}
		init();
	}

	/**
	 * remover
	 */
	public void delete() {
		if (!UtilObjeto.isNull(this.utilSelect)) {
			try {
				utilizadorService.remover(this.utilSelect);
				UtilMensagem.adicionarMensagemSucesso("Utilizador removido com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
				UtilMensagem.adicionarMensagemErro("Erro!");
			}
		} else {
			UtilMensagem.adicionarMensagemErro("O utilizador não foi removido!");
		}
		init();
	}

	/**
	 * remover
	 */
	public void editar() {
		if (!UtilObjeto.isNull(this.utilizador)) {

			try {
				// utilizadorService.update(this.utilizador);
				UtilMensagem.adicionarMensagemSucesso("Utilizador atualizado com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
				UtilMensagem.adicionarMensagemErro("Erro!");
			}
		} else {
			UtilMensagem.adicionarMensagemErro("O utilizador não foi atuaizado!");
		}
		init();
	}

	
	
	public void handleFileUpload(FileUploadEvent event) {
		this.sfcFotoFile = event.getFile();		
	}
	
	
	/**
	 * m�todo que permite voltar a p�gina
	 */
	public void NovoUtilizaodr() {
		this.utilizador = new Utilizador();
		setConsulta(false);
	}

	/**
	 * m�todo respons�vel por obter todos os utilizaodres.
	 * 
	 * @return
	 */
	public List<Utilizador> getAllUtilizadores() {
		return utilizadorService.getAll();
	}

	/**
	 * m�todo que permite voltar a p�gina
	 */
	public void voltar() {
		setConsulta(true);
	}

	/**
	 * apagar auxiliar
	 * 
	 * @param utilizador
	 */
	public void deleteAux(Utilizador utilizador) {
		setUtilSelect(utilizador);
	}

	/**
	 * editar auxiliar
	 * 
	 * @param utilizador
	 */
	public void editarAux(Utilizador utilizador) {
		setUtilizador(utilizador);
		setConsulta(false);
	}

	/**
	 * M�todo que obtem a data e hora atual
	 * 
	 * @return
	 */
	public String getNow() {
		return new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(new Date());
	}

	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		Object otherValue = component.getAttributes().get("otherValue");

		if (value == null || otherValue == null) {
			return;
		}

		if (!value.equals(otherValue)) {
			throw new ValidatorException(new FacesMessage("Values are not equal."));
		}
	}

	public Utilizador getUtilizador() {
		return UtilObjeto.isNull(utilizador) ? this.utilizador = new Utilizador() : this.utilizador;
	}

	public void setUtilizador(Utilizador utilizador) {
		if (!UtilObjeto.isNull(utilizador)) {
			this.utilizador = utilizador;
		}
	}

	public Utilizador getUtilSelect() {
		return UtilObjeto.isNull(utilSelect) ? this.utilSelect = new Utilizador() : this.utilSelect;
	}

	public void setUtilSelect(Utilizador utilSelect) {
		if (!UtilObjeto.isNull(utilSelect)) {
			this.utilSelect = utilSelect;
		}

	}

	public List<Utilizador> getUtilizadores() {
		return utilizadores;
	}

	public void setUtilizadores(List<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}

	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	/**
	 * @return the filteredUtilizadores
	 */
	public List<Utilizador> getFilteredUtilizadores() {
		return filteredUtilizadores;
	}

	/**
	 * @param filteredUtilizadores
	 *            the filteredUtilizadores to set
	 */
	public void setFilteredUtilizadores(List<Utilizador> filteredUtilizadores) {
		this.filteredUtilizadores = filteredUtilizadores;
	}

	/**
	 * @return the perfis
	 */
	public List<Perfil> getPerfis() {
		return UtilObjeto.isNull(perfis) ? this.perfis = new LinkedList<Perfil>() : this.perfis;
	}

	/**
	 * @param perfis
	 *            the perfis to set
	 */
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}

	
	/**
	 * @return the sfcFotoFile
	 */
	public UploadedFile getSfcFotoFile() {
		return sfcFotoFile;
	}

	/**
	 * @param sfcFotoFile the sfcFotoFile to set
	 */
	public void setSfcFotoFile(UploadedFile sfcFotoFile) {
		this.sfcFotoFile = sfcFotoFile;
	}

	/**
	 * @return the utilizadorService
	 */
	public UtilizadorService getUtilizadorService() {
		return utilizadorService;
	}

	/**
	 * @param utilizadorService the utilizadorService to set
	 */
	public void setUtilizadorService(UtilizadorService utilizadorService) {
		this.utilizadorService = utilizadorService;
	}

	/**
	 * @return the perfilController
	 */
	public PerfilController getPerfilController() {
		return perfilController;
	}

	/**
	 * @param perfilController the perfilController to set
	 */
	public void setPerfilController(PerfilController perfilController) {
		this.perfilController = perfilController;
	}

	/**
	 * 
	 * @param nif
	 * @param password
	 * @return
	 */
	public Utilizador login(Long nif, String password) {

		Utilizador util = utilizadorService.findByNif(nif);
		
		if (UtilObjeto.isNotNull(util)) {
			return (util.getPassword().equals(password)) ? util : null;
		} else {
			return null;
		}
	}

	/**
	 * método que permite validar o nif do utilizador
	 * 
	 * @param nif
	 * @return
	 */
	public boolean validarNif(Long nif) {
		if (UtilObjeto.isNotNull(nif)) {
			return UtilConverter.validaNif(nif) ? true : false;
		} else {
			return false;
		}

	}
	
	
}
