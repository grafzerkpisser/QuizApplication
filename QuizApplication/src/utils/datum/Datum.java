package utils.datum;

import java.text.DateFormat;
import java.text.ParseException;
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
			gregDatum = new GregorianCalendar(jaar, maand -1, dag);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Vul een correcte jaar, maand en dag in.");
		}
	}

	public Datum(String d) throws IllegalArgumentException {
		try {
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date date = df.parse(d);
			Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(date);
			gregDatum = (GregorianCalendar)cal;
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Vul een correcte jaar, maand en dag in, in het volgende formaat: dd/mm/yyyy");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Datum(Datum d) {
		gregDatum = d.getDatum();
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

		if (!(obj instanceof Datum)) {
			return false;
		}

		Datum d = (Datum) obj;

		return compareTo(d) == 0;
	}

	private LocalDate getLocalDate(Datum d){
		Calendar cal = Calendar.getInstance();
	    cal.setTime(d.getDatum().getTime());
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
		return LocalDate.of(year, month + 1, day);
	}
	public int verschilInJaren(Datum d) {
		int result = Period.between(getLocalDate(d), getLocalDate(this)).getYears();
		return result > 0 ? result:result*-1;
	}
	public int verschilInMaanden(Datum d){
		int result = Period.between(getLocalDate(d), getLocalDate(this)).getMonths();
		return result > 0 ? result:result*-1;
	}
	public int verschilInDagen(Datum d){
			   
		Date d1 = this.gregDatum.getTime();
		Date d2 = d.getDatum().getTime();
		return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
   }
	
	public void VeranderDatum(int daysToAdd) {
		//TODO
    }
	
	public Datum veranderDatum(int daysToAdd){
		 //TODO
		return null;
	}
	

	@Override
	public int compareTo(Datum d) {
		return d.getDatum().compareTo(this.gregDatum);
	}

	public boolean kleinerDan(Datum d) {
		return (this.compareTo(d) == -1) ? true : false;
	}

	public void setDatum(GregorianCalendar d) {
		gregDatum = d;
	}
}
