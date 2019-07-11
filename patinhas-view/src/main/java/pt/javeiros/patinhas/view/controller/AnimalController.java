/**
 * 
 */
package pt.javeiros.patinhas.view.controller;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import pt.javeiros.patinhas.modelo.Animal;
import pt.javeiros.patinhas.modelo.Utilizador;
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
	private Animal animal;

	// private Animal utilSelect;

	private List<Animal> animais;
	private List<Animal> filteredAnimais;
	private boolean consulta;

	@PostConstruct
	public void init() {
		consulta = true;
		animais = new LinkedList<Animal>();
		animais = getAllAnimais();
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
		return animais;
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

}
