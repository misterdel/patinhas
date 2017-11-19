package pt.javeiros.patinhas.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * <b>Title:</b> UtilColecao
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe responsável por manipular objetos <code>Collection</code>
 * </p>
 * 
 * <p>
 * <b>Company:</b> ITSS Factory
 * </p>
 * 
 * @author Silvanio
 * 
 * @version 1.0.0
 */
public final class UtilColecao {

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	private UtilColecao() {

		super();
	}

	/**
	 * Método responsável por ordenar uma coleção.
	 * 
	 * @author Silvanio
	 * 
	 * @param colecao
	 * 
	 * @return <code>Collection</code>
	 */
	public static <T extends Comparable<? super T>> Collection<T> ordenar(final Collection<T> colecao) {

		List<T> resultado = null;

		if (UtilColecao.isReferencia(colecao)) {

			resultado = new ArrayList<T>(colecao);

			Collections.sort(resultado);
		}

		return resultado;
	}

	/**
	 * Método responsável por ordenar uma coleção.
	 * 
	 * @author Silvanio
	 * 
	 * @param colecao
	 * 
	 * @param comparator
	 * 
	 * @return <code>Collection</code>
	 */
	public static <T> Collection<T> ordenar(final Collection<T> colecao, final Comparator<? super T> comparator) {

		if (UtilObjeto.isNotNull(colecao) && UtilObjeto.isNotNull(comparator)) {

			Collections.sort((List<T>) colecao, comparator);
		}

		return colecao;
	}

	/**
	 * Método responsável por obter um elemento de determinado índice.
	 * 
	 * @author Silvanio
	 * 
	 * @param lista
	 * 
	 * @param indice
	 * 
	 * @return <code>T</code>
	 */
	public static <T> T getElementoDoIndice(final List<T> lista, final int indice) {

		T resultado = null;

		if (!UtilColecao.isEmpty(lista) && indice >= 0 && indice < lista.size()) {

			resultado = lista.get(indice);
		}

		return resultado;
	}

	/**
	 * Método responsável por obter um elemento de determinado índice.
	 * 
	 * @author Silvanio
	 * 
	 * @param colecao
	 * 
	 * @param indice
	 * 
	 * @return <code>T</code>
	 */
	public static <T> T getElementoDoIndice(final Collection<T> colecao, final int indice) {

		final List<T> lista = new ArrayList<T>(colecao);

		return UtilColecao.getElementoDoIndice(lista, indice);
	}

	/**
	 * Método responsável por obter um elemento da última posição.
	 * 
	 * @author Silvanio
	 * 
	 * @param colecao
	 * 
	 * @return <code>T</code>
	 */
	public static <T> T getElementoDoUltimoIndice(final Collection<T> colecao) {

		final List<T> lista = new ArrayList<T>(colecao);

		final int indice = ( lista.size() - 1 );

		return UtilColecao.getElementoDoIndice(lista, indice);
	}

	/**
	 * Método responsável por obter o tamanho da coleção.
	 * 
	 * @author Silvanio
	 * 
	 * @param colecao
	 * 
	 * @return <code>int</code>
	 */
	public static int getTamanho(final Collection<?> colecao) {

		int resultado = 0;

		if (UtilColecao.isReferencia(colecao)) {

			resultado = colecao.size();
		}

		return resultado;
	}

	/**
	 * Método responsável por verificar se a coleção está vazia.
	 * 
	 * @author Silvanio
	 * 
	 * @param colecao
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean isEmpty(final Collection<?> colecao) {

		return ( colecao == null || UtilColecao.getTamanho(colecao) == 0 );
	}

	/**
	 * Método responsável por verificar se a coleção não está vazia.
	 * 
	 * @author Silvanio
	 * 
	 * @param colecao
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean isNotEmpty(final Collection<?> colecao) {

		return !UtilColecao.isEmpty(colecao);
	}

	/**
	 * Método responsável por verificar se a coleção é diferente de null.
	 * 
	 * @author Silvanio
	 * 
	 * @param objeto
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean isReferencia(final Object objeto) {

		return !UtilObjeto.isNull(objeto);
	}
}
