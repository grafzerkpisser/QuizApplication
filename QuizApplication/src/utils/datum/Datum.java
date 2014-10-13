package utils.datum;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Datum implements Comparable<Datum> {

	public Datum() {
		gregDatum = (GregorianCalendar) GregorianCalendar.getInstance();
	}

	public Datum(int dag, int maand, int jaar) throws IllegalArgumentException {
		try {
			Calendar cal = GregorianCalendar.getInstance();
			cal.setLenient(false);
			cal.set(jaar, maand - 1, dag);
			cal.set(Calendar.HOUR_OF_DAY, 0);
			//With setLenient the calendar will only accept real dates.
			//example: 32/02/2014 will not be accepted. 
			// The setLenient function will only be checked by get methods.
			cal.getTime();
			gregDatum = (GregorianCalendar)cal;
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Vul een correcte jaar, maand en dag in.");
		}
	}

	public Datum(String d) throws IllegalArgumentException {
		try {
			String[] parts = d.split("/");
			if(parts.length != 3)
				throw new IllegalArgumentException("Vul een correcte jaar, maand en dag in, in het volgende formaat: dd/mm/yyyy");
			Calendar cal = GregorianCalendar.getInstance();
			cal.setLenient(false);
			cal.set(Integer.parseInt(parts[2]), Integer.parseInt(parts[1]) - 1,
					Integer.parseInt(parts[0]));
			cal.set(Calendar.HOUR_OF_DAY, 0);
			
			cal.getTime();
			gregDatum = (GregorianCalendar) cal;
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Vul een correcte jaar, maand en dag in, in het volgende formaat: dd/mm/yyyy");
		}
	}

	public Datum(Datum d) {
		this.setDatum(d.getDatum());
	}

	private GregorianCalendar gregDatum;

	public GregorianCalendar getDatum() {
		return gregDatum;
	}

	public String getDatumInAmerikaansFormaat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/M/d");
		return sdf.format(gregDatum.getTime());
	}

	public String getDatumInEuropeesFormaat() {
		SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
		return sdf.format(gregDatum.getTime());
	}

	public boolean setDatum(int jaar, int maand, int dag) {
		try {
			this.setDatum(new GregorianCalendar(jaar, maand, dag));
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

		if (!(obj instanceof Datum)) {
			return false;
		}

		Datum d = (Datum) obj;

		return compareTo(d) == 0;
	}

	private LocalDate getLocalDate(Datum d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d.getDatum().getTime());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		return LocalDate.of(year, month + 1, day);
	}

	public int verschilInJaren(Datum d) {
		int result = Period.between(getLocalDate(d), getLocalDate(this)).getYears();
		return result > 0 ? result : result * -1;
	}

	public int verschilInMaanden(Datum d) {
		int result = Period.between(getLocalDate(d), getLocalDate(this)).getMonths() + (Period.between(getLocalDate(d), getLocalDate(this)).getYears() *12) ;
		return result > 0 ? result : result * -1;
	}

	public int verschilInDagen(Datum d) {

		Date d1 = this.gregDatum.getTime();
		Date d2 = d.getDatum().getTime();
		return (int) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
	}

	public void veranderDatum(int daysToAdd) {
		this.gregDatum.add(GregorianCalendar.DAY_OF_MONTH, daysToAdd);
	}

	public Datum veranderDatumInNieuwObject(int daysToAdd) {
		Datum d1 = this;
		d1.gregDatum.add(GregorianCalendar.DAY_OF_MONTH, daysToAdd);
		return d1;
	}

	@Override
	public int compareTo(Datum d) {
		return d.getDatum().compareTo(this.gregDatum);
	}

	public boolean kleinerDan(Datum d) {
		return (this.compareTo(d) == -1) ? true : false;
	}

	private void setDatum(GregorianCalendar d) {
		gregDatum = d;
	}
	@Override
	public String toString() {
		return String.format("%s", this.gregDatum.getTime());
	}
}
