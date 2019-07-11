/**
 * 
 */
package pt.javeiros.patinhas.view.util;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import pt.javeiros.patinhas.util.UtilObjeto;

/**
 * @author cahangoa
 *
 */
public class UtilConverter implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * método que permite converter uma string em um arry de bytes md5
	 * 
	 * @param valor
	 * @return
	 */
	public static String convertStringToMd5(String valor) {
		MessageDigest mDigest;
		try {
			
			// verificar se o valor é null
			if (UtilObjeto.isNull(valor)) {
				return null;
			}
			// Instanciamos o nosso HASH MD5, poderíamos usar outro como
			// SHA, por exemplo, mas optamos por MD5.
			mDigest = MessageDigest.getInstance("MD5");

			// Convert a String valor para um array de bytes em MD5
			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));

			// Convertemos os bytes para hexadecimal, assim podemos salvar
			// no banco para posterior comparação se senhas
			StringBuffer sb = new StringBuffer();
			for (byte b : valorMD5) {
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1, 3));
			}

			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 *  Método que permite validar se um nif é válido
	 * @param nif
	 * @return
	 */
	public static boolean validaNif(Long nifPT) {	
		
		if(UtilObjeto.isNotNull(nifPT)) {
			
			String nif = Long.toString(nifPT);
			try {
				final int max = 9;
				if (!nif.matches("[0-9]+") || nif.length() != max)
					return false;
				int checkSum = 0;
				// calcula a soma de controlo
				for (int i = 0; i < max - 1; i++) {
					checkSum += (nif.charAt(i) - '0') * (max - i);
				}
				int checkDigit = 11 - (checkSum % 11);
				if (checkDigit >= 10)
					checkDigit = 0;
				return checkDigit == nif.charAt(max - 1) - '0';
			} catch (Exception e) {
				return false;
			} finally {
			}
		}else {
			return false;
		}
	}	
		
}
