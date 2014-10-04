package utils;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class DatumGregorian {

	public DatumGregorian() {
		gregDatum = (GregorianCalendar) GregorianCalendar.getInstance();
	}

	public DatumGregorian(int dag, int maand, int jaar) {
		gregDatum = new GregorianCalendar(jaar, maand, dag);
	}

	public DatumGregorian(String inputDatum) {
		String[] temp = inputDatum.split("/");
		gregDatum = new GregorianCalendar(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
	}

	private GregorianCalendar gregDatum;

	public String getDatumInAmerikaansFormaat() {
		return new SimpleDateFormat("yyyy/mm/dd").format(gregDatum);
	}

	public String getDatumInEuropeesFormaat() {
		return new SimpleDateFormat("dd/mm/yyyy").format(gregDatum);
	}

	public boolean setDatum(int jaar, int maand, int dag) {
		try {
			gregDatum = new GregorianCalendar(jaar, maand, dag);
		} catch (IllegalArgumentException ex) {
			return false;
		}
		return true;

	}

}
