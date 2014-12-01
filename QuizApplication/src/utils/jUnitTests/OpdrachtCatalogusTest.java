package utils.jUnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import enums.*;
import model.opdracht.*;
import model.quiz.*;

public class OpdrachtCatalogusTest {

	private OpdrachtCatalogus a;
	private OpdrachtCatalogus b;
	private Opdracht o1;
	private QuizOpdracht qo;
	private Quiz q;

	@Before
	public void setUp() {
		a = new OpdrachtCatalogus();
		b = new OpdrachtCatalogus();
		ArrayList<String> antwoordhints = new ArrayList<String>();
		antwoordhints.add("Manneke Pis");
		o1 = new Opdracht("Hoofdstad van Belgi�", "Brussel", 3, antwoordhints,
				30, Leeraar.Brecht, OpdrachtCategorie.AlgemeneKennis);
		q = new Quiz("Hoofdsteden", Leerjaar.eerste, true, false,
				Leeraar.Brecht);
		qo = new QuizOpdracht(q, o1, 5);

	}

	@Test
	public void test_OpdrachtCatalogus_voeg_Opdracht_toe_Aanvaard() {
		a.voegOpdrachtToe(o1);
		assertTrue(a.opdrachtenLijst.size() != 0);
	}

	@Test
	public void test_OpdrachtCatalogus_verwijder_Opdracht_Aanvaard() {
		b.voegOpdrachtToe(o1);
		try {
			b.verwijderOpdracht(o1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(b.opdrachtenLijst.size() == 0);

	}

	@Test
	public void test_OpdrachtCatalogus_verwijder_Opdracht_niet_wanneer_reeds_in_quiz() {
		b.voegOpdrachtToe(o1);
		o1.voegQuizOpdrachtToe(qo);
		try {
			b.verwijderOpdracht(o1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertTrue(b.opdrachtenLijst.size() == 1);
	}

	@Test
	public void test_OpdrachtCatalogus_pas_vraag_aan_Aanvaard() {
		a.voegOpdrachtToe(o1);
		o1.voegQuizOpdrachtToe(qo);
		try {
			a.wijzigVraag(o1, "Wat is de hoofdstad van Belgi�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Hoofdstad van Belgi�", o1.getVraag());
	}

	@Test
	public void test_OpdrachtCatalogus_pas_vraag_aan_wanneer_in_quiz_Aanvaard() {
		a.voegOpdrachtToe(o1);
		o1.voegQuizOpdrachtToe(qo);
		try {
			a.wijzigVraag(o1, "Wat is de hoofdstad van Belgi�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Hoofdstad van Belgi�", o1.getVraag());
	}

	@Test
	public void test_OpdrachtCatalogus_pas_antwoord_aan_Aanvaard() {

		a.voegOpdrachtToe(o1);
		try {
			a.wijzigAntwoord(o1, "BXL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("BXL", o1.getJuisteAntwoord());
	}

	@Test
	public void test_OpdrachtCatalogus_pas_antwoord_niet_aan_wanner_in_quiz_Aanvaard() {

		a.voegOpdrachtToe(o1);
		o1.voegQuizOpdrachtToe(qo);
		try {
			a.wijzigAntwoord(o1, "BXL");
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertEquals("Brussel", o1.getJuisteAntwoord());
	}

	@Test
	public void test_Equals_Hash_Aanvaard() {
		OpdrachtCatalogus oc1 = new OpdrachtCatalogus();
		OpdrachtCatalogus oc2 = new OpdrachtCatalogus();
		assertTrue(oc1.equals(oc2) && oc2.equals(oc1));
		assertTrue(oc1.hashCode() == oc2.hashCode());
		
	}

	@Test
	public void test_toString_Aanvaard() {
		a.voegOpdrachtToe(o1);
		assertEquals("Vraag: " + "Hoofdstad van Belgi�" + " & Categorie: "
				+ "AlgemeneKennis/n", a.toString());
	}
	/*@Test 
	public void test_compareTo_OpdrachtCatalogus_Aanvaard()
	{
		OpdrachtCatalogus oc1 = new OpdrachtCatalogus();
		OpdrachtCatalogus oc2 = new OpdrachtCatalogus();
		oc1.voegOpdrachtToe(o1);
		oc2.voegOpdrachtToe(o1);
		assertEquals("comparable", 0, oc1.compareTo(oc2));
	}
	*/

}
