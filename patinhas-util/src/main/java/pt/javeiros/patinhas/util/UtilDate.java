package pt.javeiros.patinhas.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * <p>
 * <b>Title:</b> UtilDate
 * </p>
 * 
 * <p>
 * <b>Description:</b> Classe utilitária para trabalhar com Data.
 * </p>
 * 
 * <p>
 * <b>Company: </b> ITSS Soluções em Tecnologia
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
public class UtilDate {

	/** Atributo PATTERN. */
	private static final String PATTERN = "dd/MM/yyyy";

	private static final String PATTERN_HORA = "HHmmss";

	/**
	 * Método responsável por retornar a data atual.
	 * 
	 * @author Silvânio Júnior
	 * 
	 * @return <code>Date</code> Data Atual.
	 */
	public static Date hoje() {

		return new Date();
	}

	public static Date obterDataFormatoSAP(final String valor) {

		final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		sdf.setLenient(false);

		Date data = null;

		try {

			data = sdf.parse(valor);

		} catch (final ParseException e) {

		}
		return data;
	}

	/**
	 * Método responsável por verificar se é final de semana.
	 * 
	 * @author Silvânio Júnior
	 * 
	 * @param date
	 * 
	 * @return boolean.
	 */
	public static boolean isFinalDeSemana(final Date date) {

		final GregorianCalendar gc = new GregorianCalendar();

		gc.setTime(date);

		final int diaDaSemana = gc.get(Calendar.DAY_OF_WEEK);

		return ( diaDaSemana == 1 || diaDaSemana == 7 );

	}

	/**
	 * Método responsável por formatar data.
	 * 
	 * @author Silvânio Júnior
	 * 
	 * @param data
	 * 
	 * @return <code>String</code>
	 */
	public static String format(final Date data) {

		return UtilDate.format(data, UtilDate.PATTERN);
	}

	/**
	 * Método responsável por formatar data.
	 * 
	 * @author Silvânio Júnior
	 * 
	 * @param data
	 * 
	 * @return <code>String</code>
	 */
	public static String format(final Date data, final String pattern) {

		final SimpleDateFormat dt = new SimpleDateFormat(pattern);

		return dt.format(data);

	}

	/**
	 * Método responsável por obter o ano atual.
	 * 
	 * @author Silvanio
	 * 
	 * @param data
	 * 
	 * @return <code>String</code>
	 */
	public static String getYear(final Date data) {

		final Calendar calendar = Calendar.getInstance();

		calendar.setTime(data);

		return String.valueOf(calendar.get(Calendar.YEAR));
	}

	/**
	 * Método responsável por obter o ano atual.
	 * 
	 * @author Silvanio
	 * 
	 * @param data
	 * 
	 * @return <code>String</code>
	 */
	public static String getMonth(final Date data) {

		final Calendar calendar = Calendar.getInstance();

		calendar.setTime(data);

		return String.valueOf(calendar.get(Calendar.MONTH));
	}

	/**
	 * Método responsável por formatar a data no formado SAP.
	 * 
	 * @author Silvanio
	 * 
	 * @param data
	 * 
	 * @return <code>String</code>
	 */
	public static String formatToSAP(final Date data) {

		if (UtilObjeto.isNull(data)) {

			return UtilString.empty();
		}

		return new SimpleDateFormat("yyyy/MM/dd").format(data).replaceAll("/", "");
	}

	/**
	 * Método responsável por formatar a data no formado SAP.
	 * 
	 * @author Silvanio
	 * 
	 * @param data
	 * 
	 * @return <code>String</code>
	 */
	public static String formatHora(final Date data) {

		if (UtilObjeto.isNull(data)) {

			return UtilString.empty();
		}

		return new SimpleDateFormat(UtilDate.PATTERN_HORA).format(data);
	}

	/**
	 * Método responsável por obter a data e hora atual.
	 * 
	 * @author Silvanio
	 * 
	 * @return <code>String</code>
	 */
	public static String dataHoraAtual() {

		return DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, new Locale("pt", "BR")).format(UtilDate.hoje());
	}

	/**
	 * Método responsável por obter o numero de dias entre duas datas
	 * 
	 * @author Silvanio
	 * 
	 * @param data1
	 * @param data2
	 * 
	 * @return int
	 * 
	 */
	public static int obterNumeroDiasEntreData(final Date data1, final Date data2) {

		try {
			final Calendar cal1 = new GregorianCalendar();

			final Calendar cal2 = new GregorianCalendar();

			cal1.setTime(data1);

			cal2.setTime(data2);

		} catch (final Exception e) {

			return 0;
		}

		return (int) ( ( ( data2.getTime() - data1.getTime() ) + 3600000 ) / 86400000 );
	}

	/**
	 * Método responsável por
	 * 
	 * @author Silvanio
	 * 
	 * @return
	 */
	public static Date obterDataAtualHoraZerada() {

		Date data = null;

		try {

			final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			data = format.parse(format.format(new Date()));

		} catch (final ParseException e) {
			e.printStackTrace();
		}

		return data;
	}

	/**
	 * Método responsável por obter uma data com a hora zerada
	 * 
	 * @author Silvanio
	 * 
	 * @return Date
	 */
	public static Date obterDataHoraZerada(Date data) {

		try {

			final DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

			data = format.parse(format.format(data));

		} catch (final ParseException e) {
			e.printStackTrace();
		}

		return data;
	}
}
