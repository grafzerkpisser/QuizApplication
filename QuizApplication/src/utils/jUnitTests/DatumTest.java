package utils.jUnitTests;

//import datumScratch.Datum;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import utils.datum.Datum;

public class DatumTest {

	private Calendar systeemDatum;
	private DateFormat dateformat;

	@Before
	public void setUp() {
		dateformat = new SimpleDateFormat("dd/MM/yyyy");
		systeemDatum = Calendar.getInstance();
	}

	@Test
	public void test_datum_geldige_constructor_met_datumObject_Aanvaard() {
		String temp = dateformat.format(systeemDatum.getTime());
		Datum d1 = new Datum(temp);
		Datum d2 = new Datum(d1);
		assertEquals(d1, d2);
	}

	@Test
	public void test_Datum_geldige_constructor_met_string_Aanvaard() {
		String temp = dateformat.format(systeemDatum.getTime());
		Datum d1 = new Datum(temp);
		assertTrue(d1 != null);
	}

	@Test
	public void test_Datum_geldige_constructor_met_intwaardes_Aanvaard() {
		Datum d1 = new Datum(10, 11, 2014);
		assertTrue(d1 != null);
	}

	@Test
	public void test_Datum_AmerikaansFormaat_Aanvaard() {
		Datum d1 = new Datum(10, 11, 2014);
		assertEquals("2014/11/10", d1.getDatumInAmerikaansFormaat());
	}

	@Test
	public void test_Datum_europeesFormaat_Aanvaard() {
		Datum d1 = new Datum(10, 11, 2014);
		assertEquals("10/11/2014", d1.getDatumInAmerikaansFormaat());
	}

	@Test
	public void test_Datum_compareTo_gelijk_Aanvaard() {
		Datum d1 = new Datum(10, 11, 2014);
		Datum d2 = new Datum(10, 11, 2014);
		assertEquals(d1, d2);
	}

	@Test
	public void test_Datum_compareTo_kleiner_Aanvaard() {
		Datum d1 = new Datum(10, 11, 2014);
		Datum d2 = new Datum(9, 11, 2014);
		assertEquals(-1, d1.compareTo(d2));
	}

	@Test
	public void test_Datum_compareTo_groter_Aanvaard() {
		Datum d1 = new Datum(8, 11, 2014);
		Datum d2 = new Datum(9, 11, 2014);
		assertEquals(1, d1.compareTo(d2));
	}

	@Test
	public void test_Datum_equals_gelijke_waardes_verschillend_object_Aanvaard() {
		Datum d1 = new Datum(8, 11, 2014);
		Datum d2 = new Datum(8, 11, 2014);
		assertEquals(true, d1.equals(d2));
	}

	@Test
	public void test_Datum_equals_gelijke_waardes_zelfde_object_Aanvaard() {
		Datum d1 = new Datum(8, 11, 2014);
		Datum d2 = d1;
		assertEquals(true, d1.equals(d2));
	}

	@Test
	public void testDatum_equals_verschillende_waardes_Aanvaard() {
		Datum d1 = new Datum(9, 11, 2014);
		Datum d2 = new Datum(8, 11, 2014);
		assertEquals(false, d1.equals(d2));
	}

	@Test
	public void test_Datum_verschilInJaren_Aanvaard() {
		Datum d1 = new Datum(1, 3, 2007);
		Datum d2 = new Datum(3, 1, 2009);
		assertEquals(1, d1.verschilInJaren(d2));
	}

	@Test
	public void test_Datum_verschilInDagen_Aanvaard() {
		Datum d1 = new Datum(1, 3, 2007);
		Datum d2 = new Datum(3, 1, 2014);
		assertEquals(2500, d1.verschilInDagen(d2));
	}

	@Test
	public void test_Datum_verschilInMaanden_Aanvaard() {
		Datum d1 = new Datum(1, 3, 2007);
		Datum d2 = new Datum(3, 1, 2014);
		assertEquals(82, d1.verschilInMaanden(d2));
	}

	@Test
	public void test_datum_veranderDatum_object_Aanvaard() {
		Datum d1 = new Datum(1, 3, 2007);
		Datum d2 = d1.veranderDatum(2500);
		assertEquals("2014/1/3", d2.getDatumInAmerikaansFormaat());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_datum_constructor_int_maanden_Negatief() {
		Datum d1 = new Datum(1, 13, 2007);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_datum_constructor_int_dagen_Negatief() {
		Datum d1 = new Datum(-1, 12, 2007);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Datum_constructor_int_jaren_Negatief() {
		Datum d1 = new Datum(1, 12, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Datum_constructor_string_niet_numeriek() {
		Datum d1 = new Datum("ditIsEenTest");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Datum_constructor_string_foute_maand_Negatief() {
		Datum d1 = new Datum("01/13/2007");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Datum_constructor_string_foute_dag_Negatief() {
		Datum d1 = new Datum("32/01/2007");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Datum_constructor_string_fout_jaar_Negatief() {
		Datum d1 = new Datum("01/12/-1");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Datum_constructor_string_fout_dag_niet_schrikkeljaar_Negatief() {
		Datum d1 = new Datum("29/02/2011");
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_Datum_constructor_int_fout_dag_niet_schrikkeljaar_Negatief() {
		Datum d1 = new Datum(29, 02, 2011);
	}

}
