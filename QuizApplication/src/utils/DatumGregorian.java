package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DatumGregorian implements Comparable<DatumGregorian> {

	public DatumGregorian() {
		gregDatum = (GregorianCalendar) GregorianCalendar.getInstance();
	}

	public DatumGregorian(int dag, int maand, int jaar) throws IllegalArgumentException {
		try {
			gregDatum = new GregorianCalendar(jaar, maand -1, dag);
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException("Vul een correcte jaar, maand en dag in.");
		}
	}

	public DatumGregorian(String d) throws IllegalArgumentException {
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

	public DatumGregorian(DatumGregorian d) {
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

		if (!(obj instanceof DatumGregorian)) {
			return false;
		}

		DatumGregorian d = (DatumGregorian) obj;

		return compareTo(d) == 0;
	}

	private LocalDate getLocalDate(DatumGregorian d){
		Calendar cal = Calendar.getInstance();
	    cal.setTime(d.getDatum().getTime());
	    int year = cal.get(Calendar.YEAR);
	    int month = cal.get(Calendar.MONTH);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
		return LocalDate.of(year, month + 1, day);
	}
	public int verschilInJaren(DatumGregorian d) {
		int result = Period.between(getLocalDate(d), getLocalDate(this)).getYears();
		return result > 0 ? result:result*-1;
	}
	public int verschilInMaanden(DatumGregorian d){
		int result = Period.between(getLocalDate(d), getLocalDate(this)).getMonths();
		return result > 0 ? result:result*-1;
	}
	public int verschilInDagen(DatumGregorian d){
			   
		Date d1 = this.gregDatum.getTime();
		Date d2 = d.getDatum().getTime();
		return (int)( (d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
   }
	
	public void VeranderDatum(int daysToAdd) {
	
    }
	
	public DatumGregorian veranderDatum(int daysToAdd){
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(this.gregDatum.getTime());
	     calendar.add(Calendar.DAY_OF_YEAR, daysToAdd);
	     
	     return new DatumGregorian(calendar.YEAR, calendar.MONTH + 1, calendar.DAY_OF_MONTH);
	}
	

	@Override
	public int compareTo(DatumGregorian d) {
		return d.getDatum().compareTo(this.gregDatum);
	}

	public boolean kleinerDan(DatumGregorian d) {
		return (this.compareTo(d) == -1) ? true : false;
	}

	public void setDatum(GregorianCalendar d) {
		gregDatum = d;
	}
}
