package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class DatumTest {
	
	private Calendar systeemDatum;
	private DateFormat dateformat;

	@Before
	public void setUp()
	{
		dateformat = new SimpleDateFormat("dd/MM/yyyy");
		systeemDatum = Calendar.getInstance(); 
	}
	
	@Test
	public void datum_Datum_geldige_constructor_met_datumObject_Aanvaard() {
		String temp = dateformat.format(systeemDatum.getTime());
		Datum d1 = new Datum(temp);
		Datum d2 = new Datum(d1);
		assertEquals(true,d1.equals(d2));
	}
	@Test
	public void datum_DatumGregorian_geldige_constructor_met_datumGregorianObject_Aanvaard() {
		String temp = dateformat.format(systeemDatum.getTime());
		DatumGregorian d1 = new DatumGregorian(temp);
		DatumGregorian d2 = new DatumGregorian(d1);
		assertEquals(true,d1.equals(d2));
	}
	@Test
	public void datum_Geldige_constructor_met_string_naar_Amerikaans_Aanvaard() {
		String temp = dateformat.format(systeemDatum.getTime());
		Datum d1 = new Datum(temp);
		DatumGregorian d2 = new DatumGregorian(temp);
		assertEquals(d1.getDatumInAmerikaansFormaat(), d2.getDatumInAmerikaansFormaat());
	}
	@Test
	public void datum_Geldige_constructor_met_string_naar_europees_Aanvaard() {
		String temp = dateformat.format(systeemDatum.getTime());
		Datum d1 = new Datum(temp);
		DatumGregorian d2 = new DatumGregorian(temp);
		assertEquals(d1.getDatumInEuropeesFormaat(), d2.getDatumInEuropeesFormaat());
	}
	@Test
	public void datum_Geldige_constructor_met_intwaardes_naar_europees_Aanvaard() {
		Datum d1 = new Datum(10, 11, 2014);
		DatumGregorian d2 = new DatumGregorian(10,11,2014);
		assertEquals(d1.getDatumInAmerikaansFormaat(), d2.getDatumInAmerikaansFormaat());
	}
	@Test
	public void datum_Datum_en_DatumGregorian_compareTo_gelijk_Aanvaard() {
		Datum d1 = new Datum(10, 11, 2014);
		Datum d2 = new Datum(10, 11, 2014);
		DatumGregorian d3 = new DatumGregorian(10,11,2014);
		DatumGregorian d4 = new DatumGregorian(10,11,2014);
		assertEquals(d1.compareTo(d2), d3.compareTo(d4));
	}
	@Test
	public void datum_Datum_en_DatumGregorian_compareTo_kleiner_Aanvaard() {
		Datum d1 = new Datum(10, 11, 2014);
		Datum d2 = new Datum(9, 11, 2014);
		DatumGregorian d3 = new DatumGregorian(10,11,2014);
		DatumGregorian d4 = new DatumGregorian(9,11,2014);
		assertEquals(d1.compareTo(d2), d3.compareTo(d4));
	}
	@Test
	public void datum_Datum_en_DatumGregorian_compareTo_groter_Aanvaard() {
		Datum d1 = new Datum(8, 11, 2014);
		Datum d2 = new Datum(9, 11, 2014);
		DatumGregorian d3 = new DatumGregorian(8,11,2014);
		DatumGregorian d4 = new DatumGregorian(9,11,2014);
		assertEquals(d1.compareTo(d2), d3.compareTo(d4));
	}
	@Test
	public void datum_Equals_gelijke_waardes_verschillend_object_Aanvaard(){
		Datum d1 = new Datum(8, 11, 2014);
		Datum d2 = new Datum(8, 11, 2014);
		assertEquals(true, d1.equals(d2));
	}
	@Test
	public void datum_Equals_gelijke_waardes_zelfde_object_Aanvaard(){
		Datum d1 = new Datum(8, 11, 2014);
		Datum d2 = d1;
		assertEquals(true, d1.equals(d2));
	}
	@Test
	public void datum_Equals_verschillende_waardes_Aanvaard(){
		Datum d1 = new Datum(9, 11, 2014);
		Datum d2 = new Datum(8, 11, 2014);
		assertEquals(false, d1.equals(d2));
	}
	@Test
	public void datumGregorian_Equals_gelijke_waardes_verschillend_object_Aanvaard(){
		DatumGregorian d1 = new DatumGregorian(8, 11, 2014);
		DatumGregorian d2 = new DatumGregorian(8, 11, 2014);
		assertEquals(true, d1.equals(d2));
	}
	@Test
	public void datumGregorian_Equals_gelijke_waardes_zelfde_object_Aanvaard(){
		DatumGregorian d1 = new DatumGregorian(8, 11, 2014);
		DatumGregorian d2 = d1;
		assertEquals(true, d1.equals(d2));
	}
	@Test
	public void datumGregorian_Equals_verschillende_waardes_Aanvaard(){
		DatumGregorian d1 = new DatumGregorian(9, 11, 2014);
		DatumGregorian d2 = new DatumGregorian(8, 11, 2014);
		assertEquals(false, d1.equals(d2));
	}
	@Test
	public void datumGregorian_verschilInJaren_Aanvaard(){
		DatumGregorian d1 = new DatumGregorian(1, 3, 2007);
		DatumGregorian d2 = new DatumGregorian(3, 1, 2009);
		assertEquals(1, d1.verschilInJaren(d2));
	}
	@Test
	public void datum_verschilInJaren_Aanvaard(){
		Datum d1 = new Datum(1, 3, 2007);
		Datum d2 = new Datum(3, 1, 2009);
		assertEquals(1, d1.verschilInJaren(d2));
	}
	@Test
	public void datumGregorian_verschilInMaanden_Aanvaard(){
		DatumGregorian d1 = new DatumGregorian(1, 3, 2007);
		DatumGregorian d2 = new DatumGregorian(3, 1, 2009);
		assertEquals(10, d1.verschilInMaanden(d2));
	}
	@Test
	public void datumGregorian_verschilInDagen_Aanvaard(){
		DatumGregorian d1 = new DatumGregorian(1, 3, 2007);
		DatumGregorian d2 = new DatumGregorian(3, 1, 2014);
		assertEquals(2500, d1.verschilInDagen(d2));
	}
	
	@Test
	public void datumGregorian_veranderDatum_object_Aanvaard(){
		DatumGregorian d1 = new DatumGregorian(1, 3, 2007);
		DatumGregorian d2 = d1.veranderDatum(2500);
		assertEquals("2014/1/3", d2.getDatumInAmerikaansFormaat());
	}
	
}
