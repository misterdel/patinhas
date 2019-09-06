/**
 * 
 */
package pt.javeiros.patinhas.view.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import pt.javeiros.patinhas.modelo.Animal;
import pt.javeiros.patinhas.modelo.Categoria;
import pt.javeiros.patinhas.modelo.Raca;
import pt.javeiros.patinhas.service.AnimalService;
import pt.javeiros.patinhas.util.UtilObjeto;
import pt.javeiros.patinhas.view.util.UtilMensagem;

/**
 * @author cahangoa
 *
 */
@ViewScoped
@ManagedBean(name = "aniBean")
public class AnimalController implements Serializable {

	private static final long serialVersionUID = 1L;

	private @Inject AnimalService animalService;
	private @Inject RacaController racaController;
	private @Inject CategoriaController categoriaController;

	private Animal animal;

	private List<Animal> animais;
	private List<Categoria> categorias;
	private List<Raca> racas;

	private List<Animal> filteredAnimais;
	private Long idCategoria;

	private boolean consulta;

	@PostConstruct
	public void init() {
		consulta = true;
		animais = getAllAnimais();
		this.categorias = categoriaController.getCategorias();
	}

	/**
	 * m�todo respons�vel por salvar o novo utilizador
	 */
	public void save() {

		if (UtilObjeto.isNotNull(this.animal)) {
			animalService.save(this.animal);
			UtilMensagem.adicionarMensagemSucesso("Animal salvo com sucesso !");

		} else {

			UtilMensagem.adicionarMensagemSucesso("Erro ao salvar o Animal !");
		}
		init();
	}

	/**
	 * remover
	 */
	public void delete() {
		if (!UtilObjeto.isNull(this.animal)) {
			try {
				animalService.remover(this.animal);
				UtilMensagem.adicionarMensagemSucesso("Animal removido com sucesso!");

			} catch (Exception e) {
				e.printStackTrace();
				UtilMensagem.adicionarMensagemErro("Erro!");
			}
		} else {
			UtilMensagem.adicionarMensagemErro("O animal não foi removido!");
		}
		init();
	}

	public void onCategoriaChange() {

		if (idCategoria != null && idCategoria != 0) {
			racas = getRacaController().getRacaForCategoria((int) (long) idCategoria);
		} else {
			racas = new ArrayList<>();
		}
	}

	/**
	 * m�todo que permite voltar a p�gina
	 */
	public void NovoAnimal() {
		this.animal = new Animal();
		setConsulta(false);
	}

	public List<Animal> getAllAnimais() {
		return animalService.getAll();
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
	public void deleteAux(Animal animal) {
		setAnimal(animal);
	}

	/**
	 * editar auxiliar
	 * 
	 * @param utilizador
	 */
	public void editarAux(Animal animal) {
		setAnimal(animal);
		setConsulta(false);
	}

	/**
	 * @return the animalService
	 */
	public AnimalService getAnimalService() {
		return animalService;
	}

	/**
	 * @param animalService
	 *            the animalService to set
	 */
	public void setAnimalService(AnimalService animalService) {
		this.animalService = animalService;
	}

	/**
	 * @return the animal
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * @param animal
	 *            the animal to set
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	/**
	 * @return the animais
	 */
	public List<Animal> getAnimais() {
		return UtilObjeto.isNull(this.animais) ? this.animais = new ArrayList<Animal>() : this.animais;
	}

	/**
	 * @param animais
	 *            the animais to set
	 */
	public void setAnimais(List<Animal> animais) {
		this.animais = animais;
	}

	/**
	 * @return the filteredAnimais
	 */
	public List<Animal> getFilteredAnimais() {
		return filteredAnimais;
	}

	/**
	 * @param filteredAnimais
	 *            the filteredAnimais to set
	 */
	public void setFilteredAnimais(List<Animal> filteredAnimais) {
		this.filteredAnimais = filteredAnimais;
	}

	public boolean isConsulta() {
		return consulta;
	}

	public void setConsulta(boolean consulta) {
		this.consulta = consulta;
	}

	/**
	 * @return the racaController
	 */
	public RacaController getRacaController() {
		return racaController;
	}

	/**
	 * @param racaController
	 *            the racaController to set
	 */
	public void setRacaController(RacaController racaController) {
		this.racaController = racaController;
	}

	/**
	 * @return the categorias
	 */
	public List<Categoria> getCategorias() {
		return UtilObjeto.isNull(this.categorias) ? this.categorias = new ArrayList<Categoria>() : this.categorias;

	}

	/**
	 * @param categorias
	 *            the categorias to set
	 */
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	/**
	 * @return the racas
	 */
	public List<Raca> getRacas() {
		return racas;
	}

	/**
	 * @param racas
	 *            the racas to set
	 */
	public void setRacas(List<Raca> racas) {
		this.racas = racas;
	}

	/**
	 * @return the idCategoria
	 */
	public Long getIdCategoria() {
		return idCategoria;
	}

	/**
	 * @param idCategoria
	 *            the idCategoria to set
	 */
	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	/**
	 * @return the categoriaController
	 */
	public CategoriaController getCategoriaController() {
		return categoriaController;
	}

	/**
	 * @param categoriaController
	 *            the categoriaController to set
	 */
	public void setCategoriaController(CategoriaController categoriaController) {
		this.categoriaController = categoriaController;
	}

}
