package utils;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DatumGregorian {

	public DatumGregorian() {
		gregorianDatum = (GregorianCalendar) GregorianCalendar.getInstance();
	}

	public DatumGregorian(int dag, int maand, int jaar) {
		gregorianDatum = new GregorianCalendar(jaar, maand, dag);
	}

	public DatumGregorian(String inputDatum) {
		String[] temp = inputDatum.split("/");
		gregorianDatum = new GregorianCalendar(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
	}

	private GregorianCalendar gregorianDatum;

	public String getDatumInAmerikaansFormaat() {
		return new SimpleDateFormat("yyyy/mm/dd").format(gregorianDatum);
	}

	public String getDatumInEuropeesFormaat() {
		return new SimpleDateFormat("dd/mm/yyyy").format(gregorianDatum);
	}

	public boolean setDatum(int jaar, int maand, int dag) {
		try {
			gregorianDatum = new GregorianCalendar(jaar, maand, dag);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		return true;

	}

}
