package utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.GregorianCalendar;

public class DatumGregorian implements Comparable<DatumGregorian> {

	public DatumGregorian() {
		gregDatum = (GregorianCalendar) GregorianCalendar.getInstance();
	}

	public DatumGregorian(int dag, int maand, int jaar) throws IllegalArgumentException {
		try {
			gregDatum = new GregorianCalendar(jaar, maand, dag);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Vul een correcte jaar, maand en dag in.");
		}
	}

	public DatumGregorian(String d) throws IllegalArgumentException {
		try {
			String[] temp = d.split("/");
			gregDatum = new GregorianCalendar(Integer.parseInt(temp[2]), Integer.parseInt(temp[1]), Integer.parseInt(temp[0]));
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Vul een correcte jaar, maand en dag in, in het volgende formaat: dd/mm/yyyy");
		}
	}

	public DatumGregorian(DatumGregorian d) {
		gregDatum = d.getDatum();
	}

	private GregorianCalendar gregDatum;

	public GregorianCalendar getDatum() {
		return gregDatum;
	}

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

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof DatumGregorian)) {
			return false;
		}

		DatumGregorian d = (DatumGregorian) obj;

		return compareTo(d) == 0;
	}

	@SuppressWarnings("deprecation")
	public int verschilInJaren(DatumGregorian d) {
		Date d1 = (Date) d.getDatum().getTime();
		Date d2 = (Date) this.gregDatum.getTime();
		LocalDate date1 = LocalDate.of(d1.getYear(), d1.getMonth(), d1.getDay());
		LocalDate date2 = LocalDate.of(d2.getYear(), d2.getMonth(), d2.getDay());
		return Period.between(date1, date2).getYears();

	}

	@Override
	public int compareTo(DatumGregorian d) {
		return this.gregDatum.compareTo(d.getDatum());

	}

	public boolean kleinerDan(DatumGregorian d) {
		return (this.compareTo(d) == -1) ? true : false;
	}

	public void setDatum(GregorianCalendar d) {
		gregDatum = d;
	}
}
