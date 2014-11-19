package persistentie;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Set;

import model.opdracht.Meerkeuze;
import model.opdracht.Opdracht;
import model.opdracht.OpdrachtCatalogus;
import model.opdracht.QuizCatalogus;
import model.opdracht.QuizOpdracht;
import model.quiz.Quiz;

import org.junit.Before;
import org.junit.Test;

import enums.Leeraar;
import enums.Leerjaar;
import enums.OpdrachtCategorie;

public class PersistentieTest {

	OpdrachtCatalogus opdrachtCatalogus;
	QuizCatalogus quizCatalogus;
	@Before
	public void setUp() {
		opdrachtCatalogus = new OpdrachtCatalogus();
		ArrayList<String> antwoordHints = new ArrayList<String>();
		antwoordHints.add("Manneke Pis");
		antwoordHints.add("Atomium");
		ArrayList<String> keuzes = new ArrayList<String>();
		keuzes.add("Brussel");
		keuzes.add("Antwerpen");
		keuzes.add("Gent");
		Opdracht o1 = new Opdracht("Hoofdstad van Belgie", "Brussel", 1, antwoordHints, 60, Leeraar.Bart, 
				OpdrachtCategorie.AlgemeneKennis);
		Opdracht o2 = new Meerkeuze("Hoofdstad van Belgie", "Brussel", 1, antwoordHints, 
				60, keuzes, Leeraar.Bart, OpdrachtCategorie.AlgemeneKennis);
		opdrachtCatalogus.voegOpdrachtToe(o1);
		opdrachtCatalogus.voegOpdrachtToe(o2);
		
		quizCatalogus = new QuizCatalogus();
		Quiz q1 = new Quiz("Hoofdsteden", Leerjaar.derde, false, false, Leeraar.Bart);
		Quiz q2 = new Quiz("Hoofdsteden2", Leerjaar.eerste, false, false, Leeraar.Brecht);
		QuizOpdracht.koppelOpdrachtAanQuiz(q1, o1, 5);
		QuizOpdracht.koppelOpdrachtAanQuiz(q2, o1, 2);
		QuizOpdracht.koppelOpdrachtAanQuiz(q2, o2, 7);
		quizCatalogus.voegQuizToe(q1);
		quizCatalogus.voegQuizToe(q2);
	}

	@Test
	public void test_Wegschrijven_OpdrachtCatalogus_Aanvaard() throws IOException {
		DbStrategy dbStrategy = new CsvFileProcess();
		dbStrategy.bewaarOpdrachten(opdrachtCatalogus);
		assertTrue(Files.exists(Paths.get("opdrachten.ser")));
	}
	@Test
	public void test_Wegschrijven_QuizCatalogus_Aanvaard() throws IOException {
		DbStrategy dbStrategy = new CsvFileProcess();
		dbStrategy.bewaarQuizen(quizCatalogus);
		assertTrue(Files.exists(Paths.get("quizen.ser")));
	}
	
	@Test
	public void test_Ophalen_Quizen_Aanvaard() throws ClassNotFoundException, IOException{
		DbStrategy dbStrategy = new CsvFileProcess();
		Set<QuizCatalogus> quizen = dbStrategy.leesQuizen();
		quizCatalogus = (QuizCatalogus)quizen.iterator().next();
		assertTrue(quizCatalogus != null);
	}
	@Test
	public void test_Ophalen_Opdrachten_Aanvaard() throws ClassNotFoundException, IOException{
		DbStrategy dbStrategy = new CsvFileProcess();
		Set<OpdrachtCatalogus> opdrachten = dbStrategy.leesOpdrachten();
		opdrachtCatalogus = (OpdrachtCatalogus)opdrachten.iterator().next();
		assertTrue(opdrachtCatalogus != null);
	}
	@Test
	public void test_Controleer_link_tussen_quiz_opdracht_Aanvaard() throws ClassNotFoundException, IOException{
		
		OpdrachtCatalogus oc = new OpdrachtCatalogus();
		QuizCatalogus qc = new QuizCatalogus();
		DbStrategy dbStrategy = new CsvFileProcess();
		Set<OpdrachtCatalogus> opdrachten = dbStrategy.leesOpdrachten();
		oc = (OpdrachtCatalogus)opdrachten.iterator().next();
		
		Set<QuizCatalogus> quizen = dbStrategy.leesQuizen();
		qc = (QuizCatalogus)quizen.iterator().next();
		
		boolean isLinked1 = false;
		boolean isLinked2 = false;
		for(Quiz quiz:qc.quizLijst){
			for(QuizOpdracht quizOpdracht:quiz.getEenQuizOpdrachtLijst()){
				if(quizOpdracht.getMaxscore() > 0 ){
					isLinked1 = true;
				}
			}
		}
		
		for(Opdracht opdracht:oc.opdrachtenLijst){
			for(QuizOpdracht quizOpdracht:opdracht.getEenQuizOPdrachtLijst()){
				if(quizOpdracht.getMaxscore() > 0 ){
					isLinked2 = true;
				}
			}
		}
		assertTrue(isLinked1 && isLinked2);
	}
	
	

}
