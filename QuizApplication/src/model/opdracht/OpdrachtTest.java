package model.opdracht;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import enums.Leeraar;
import enums.OpdrachtCategorie;

public class OpdrachtTest {

	private Opdracht meerkeuzeOpdracht;
	
	@Before
	public void setUp()
	{
		ArrayList<String> antwoordhints = new ArrayList<String>();
		antwoordhints.add("Twee");
		ArrayList<String> keuzes = new ArrayList<String>();
		keuzes.add("1");
		keuzes.add("2");
		keuzes.add("3");
		meerkeuzeOpdracht = new Meerkeuze("Hoeveel is 1+1", "2", 1, antwoordhints,
				60, keuzes, Leeraar.Bart, OpdrachtCategorie.Rekenen);
	}

	@Test
	public void test_Maak_meerkeuze_opdracht_Success() {
		assertNotNull(meerkeuzeOpdracht);
	}
	
	@Test
	public void test_Check_meerkeuze_clone_opdracht_Success()
	{
		try {
			Opdracht mk2 = meerkeuzeOpdracht.clone();
			mk2.setLeeraar(Leeraar.Brecht);
			assertTrue(meerkeuzeOpdracht.getLeeraar() == Leeraar.Bart && mk2.getLeeraar() == Leeraar.Brecht);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test_Meerkeuze_equals_Success()
	{
		Opdracht mk2;
		try {
			mk2 = meerkeuzeOpdracht.clone();
			assertTrue(mk2.equals(meerkeuzeOpdracht));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	@Test
	public void test_Meerkeuze_not_Equals_Success()
	{
		Opdracht mk2;
		try {
			mk2 = meerkeuzeOpdracht.clone();
			mk2.setLeeraar(Leeraar.Brecht);
			assertFalse(mk2.equals(meerkeuzeOpdracht));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Test
	public void test_Method_is_juiste_antwoord_Success()
	{
		assertTrue(meerkeuzeOpdracht.isJuisteAntwoord("2"));
	}
	@Test
	public void test_Method_is_juiste_antwoord_fout_antwoord_Success()
	{
		assertFalse(meerkeuzeOpdracht.isJuisteAntwoord("3"));
	}
	@Test
	public void test_Meerkeuze_valide_ok_Success()
	{
		assertTrue(((Meerkeuze)meerkeuzeOpdracht).valide("2"));
	}
	@Test
	public void test_Meerkeuze_valide_nok_Success()
	{
		assertFalse(((Meerkeuze)meerkeuzeOpdracht).valide("55"));
	}
	@Test
	public void test_Meerkeuze_verwijder_alle_keuze_Success()
	{
		((Meerkeuze)meerkeuzeOpdracht).verwijderKeuze(1);
		((Meerkeuze)meerkeuzeOpdracht).verwijderKeuze(2);
		((Meerkeuze)meerkeuzeOpdracht).verwijderKeuze(3);
		assertTrue(((Meerkeuze)meerkeuzeOpdracht).getKeuzes().size() == 0);
	}
	

}
