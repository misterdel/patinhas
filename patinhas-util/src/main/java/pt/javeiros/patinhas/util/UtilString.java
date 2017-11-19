package pt.javeiros.patinhas.util;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;

/**
 * <p>
 * <b>Title:</b> UtilString
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe utilitária responsável por manipular objetos <code>String</code>.
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
public final class UtilString {

	/** Atributo equalsBuilder. */
	private static final EqualsBuilder equalsBuilder;

	static {

		equalsBuilder = new EqualsBuilder();
	}

	/**
	 * Responsável pela criação de novas instâncias desta classe.
	 */
	private UtilString() {

		super();
	}

	/**
	 * Método responsável por verificar se existe referencia armazenada na variável.
	 * 
	 * @param string
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean isEmpty(final String string) {

		final boolean isEmpty = StringUtils.isBlank(string);

		return isEmpty;
	}

	/**
	 * Método responsável por verificar se existe referencia armazenada na variável.
	 * 
	 * @param string
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean isEmptyNull(final String string) {

		return UtilString.isEmpty(string) || UtilString.isEquals(string, "null");
	}

	/**
	 * Método responsável por verificar se existe referencia armazenada na variável.
	 * 
	 * @param string
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean isNotEmptyNull(final String string) {

		return !UtilString.isEmptyNull(string);
	}

	/**
	 * Método responsável por verificar se existe referencia armazenadas nas variáveis.
	 * 
	 * @author Silvanio
	 * 
	 * @param strings
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean isEmpty(final String... strings) {

		if (UtilObjeto.isNull((Object[]) strings)) {

			return Boolean.TRUE;
		}

		for (final String string : strings) {

			if (UtilString.isEmpty(string)) {

				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	/**
	 * Método responsável por verificar se os valores são iguais.
	 * 
	 * @author Silvanio
	 * 
	 * @param principal
	 * 
	 * @param texto
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean isEquals(final String principal, final String texto) {

		final boolean isEquals = UtilString.equalsBuilder.append(principal.trim(), texto.trim()).isEquals();

		UtilString.equalsBuilder.reset();

		return isEquals;
	}

	/**
	 * Método responsável por transformar um valor em caixa alta.
	 * 
	 * @author Silvanio
	 * 
	 * @param string
	 * 
	 * @return <code>String</code>
	 */
	public static String maiuscula(final String string) {

		String strMaiuscula = string;

		if (!UtilString.isEmpty(string)) {

			strMaiuscula = string.toUpperCase();
		}

		return strMaiuscula;
	}

	/**
	 * Método responsável por transformar um valor em caixa baixa.
	 * 
	 * @author Silvanio
	 * 
	 * @param string
	 * 
	 * @return <code>String</code>
	 */
	public static String minuscula(final String string) {

		String strMinuscula = string;

		if (!UtilString.isEmpty(string)) {

			strMinuscula = string.toLowerCase();
		}

		return strMinuscula;
	}

	/**
	 * Método responsável por separar uma string de acordo com o delimitador informado.
	 * 
	 * @author Silvanio
	 * 
	 * @param string
	 * 
	 * @param delimitador
	 * 
	 * @return <code>List</code>
	 */
	public static List<String> split(final String string, final String delimitador) {

		final List<String> result = new ArrayList<String>();

		if (!UtilString.isEmpty(string, delimitador)) {

			final StringTokenizer st = new StringTokenizer(string, delimitador);

			while (st.hasMoreTokens()) {

				result.add(st.nextToken());
			}
		}

		return result;
	}

	/**
	 * Método responsável por remover acentuação de uma string.
	 * 
	 * @author Silvanio
	 * 
	 * @param string
	 * 
	 * @return <code>String</code>
	 */
	public static String removerAcentuacao(final String string) {

		String result = string;

		if (!UtilString.isEmpty(string)) {

			result = UtilString.substituir(result, "[ÁÀÂÃ]", "A");
			result = UtilString.substituir(result, "[áàâãª]", "a");
			result = UtilString.substituir(result, "[ÉÈÊ]", "E");
			result = UtilString.substituir(result, "[éèê]", "e");
			result = UtilString.substituir(result, "[ÍÌÎÏ]", "I");
			result = UtilString.substituir(result, "[íìîï]", "i");
			result = UtilString.substituir(result, "[ÓÒÔÕÖ]", "O");
			result = UtilString.substituir(result, "[óòôõºö]", "o");
			result = UtilString.substituir(result, "[ÚÙÛÜ]", "U");
			result = UtilString.substituir(result, "[úùûü]", "u");
			result = UtilString.substituir(result, "[Ç]", "C");
			result = UtilString.substituir(result, "[ç]", "c");
			result = UtilString.substituir(result, "[~\\d^Ž`]", "");
			result = UtilString.substituir(result, "[\\dš]", "");
		}

		return string;
	}

	/**
	 * Método responsável por remover caracteres de uma string, deixando apenas digitos.
	 * 
	 * @author Silvanio
	 * 
	 * @param string
	 * 
	 * @return <code>String</code>
	 */
	public static String removerCaracteres(final String string) {

		String result = string;

		if (!UtilString.isEmpty(string)) {

			result = UtilString.remover(string, "[^0-9]");
		}

		return result;
	}

	/**
	 * Método responsável por remover valores de uma string.
	 * 
	 * @author Silvanio
	 * 
	 * @param srcString
	 * 
	 * @param localizar
	 * 
	 * @return <code>String</code>
	 */
	public static String remover(final String srcString, final String localizar) {

		String result = srcString;

		if (!UtilString.isEmpty(srcString, localizar)) {

			result = srcString.replaceAll(localizar, "");
		}

		return result;
	}

	/**
	 * Método responsável por substituir um valor da string.
	 * 
	 * @author Silvanio
	 * 
	 * @param srcString
	 * 
	 * @param localizar
	 * 
	 * @param novaString
	 * 
	 * @return <code>String</code>
	 */
	public static String substituir(final String srcString, final String localizar, final String novaString) {

		String result = srcString;

		if (!UtilString.isEmpty(srcString, localizar)) {

			result = srcString.replaceAll(localizar, novaString);
		}

		return result;
	}

	/**
	 * Método responsável por substituir uma valor da string de acordo as condições informadas.
	 * 
	 * @author Silvanio
	 * 
	 * @param condicao
	 * 
	 * @param srcString
	 * 
	 * @param localizar
	 * 
	 * @param seVerdadeiro
	 * 
	 * @param seFalso
	 * 
	 * @return <code>String</code>
	 */
	public static String substituirSe(final boolean condicao, final String srcString, final String localizar, final String seVerdadeiro, final String seFalso) {

		String result = srcString;

		if (condicao) {

			result = UtilString.substituir(srcString, localizar, seVerdadeiro);

		} else {

			result = UtilString.substituir(srcString, localizar, seFalso);
		}

		return result;
	}

	/**
	 * Método responsável por obter a quantidade de caracteres da string.
	 * 
	 * @author Silvanio
	 * 
	 * @param string
	 * 
	 * @return <code>int</code>
	 */
	public static int getTamanho(final String string) {

		return !UtilString.isEmpty(string) ? string.length() : 0;
	}

	/**
	 * Método responsável por obter uma string vazia.
	 * 
	 * @author Silvanio
	 * 
	 * @return <code>String</code>
	 */
	public static String empty() {

		return StringUtils.EMPTY;
	}

	/**
	 * Método responsável por obter uma string representando uma nova linha.
	 * 
	 * @author Silvanio
	 * 
	 * @return <code>String</code>
	 */
	public static String newLine() {

		return "\n";
	}

	/**
	 * Método responsável por por verificar se a String contém digito.
	 * 
	 * @author Silvânio Júnior
	 * 
	 * @param valor
	 * 
	 * @return <code>boolean</code>
	 */
	public static boolean soContemNumero(final String valor) {

		final char[] dados = valor.toCharArray();

		for (final char item : dados) {

			if (!Character.isDigit(item)) {

				return false;
			}
		}

		return true;
	}

	/**
	 * Método responsável por formatar log de informação.
	 * 
	 * @author Silvanio
	 * 
	 * @param texto
	 * 
	 * @return <code>String</code>
	 */
	public static String log(final String texto) {

		return MessageFormat.format("\n\n********\n\n{0}\n\n********\n", texto);
	}

	/**
	 * Método responsável por completar zero a esqueda
	 * 
	 * @author Silvânio Júnior
	 * 
	 * @param completar
	 * 
	 * @param valor
	 * 
	 * @return String
	 */
	public static String completarZeroAEsquerda(int completar, String valor) {

		int size = valor.length();

		int total = completar - size;

		String zero = "";

		for (int i = 0; i < total; i++) {

			zero = zero + 0;

		}

		String ultima = zero + valor;

		return ultima.toString();
	}

	/**
	 * Método responsável por testar se a string é só contem letras e numeros
	 * 
	 * @author Ezequiel Bispo
	 * 
	 * @param s
	 * 
	 * @return <code>Boolean</code>
	 */
	public static boolean isAlphaNumerico(String s) {

		String pattern = "^[a-zA-Z0-9]*$";

		if (s.matches(pattern)) {

			return true;
		}

		return false;
	}

	/**
	 * Método responsável por testar se a string é só contem letras e numeros
	 * 
	 * @author Ezequiel Bispo
	 * 
	 * @param s
	 * 
	 * @return <code>Boolean</code>
	 */
	public static boolean isNumerico(String s) {

		String pattern = "^[0-9]*$";

		if (s.matches(pattern)) {

			return true;
		}

		return false;
	}

	/**
	 * Método responsável por concatenar String para campos autoComplete
	 * 
	 * @author Wilker Machado
	 * @author Ezequiel
	 * 
	 * @param str1
	 * @param str2
	 * 
	 * @return String
	 */
	public static String concatenarStrings(final String str1, final String str2) {

		String result = "";

		if (!UtilString.isEmpty(str1)) {

			result = result + str1;
		}

		if (!UtilString.isEmpty(str1) && !UtilString.isEmpty(str2)) {

			result = result + " - ";
		}

		if (!UtilString.isEmpty(str2)) {

			result = result + str2;
		}

		return result;

	}
}
