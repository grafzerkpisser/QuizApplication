package utils.jUnitTests;

import enums.Leerjaar;
import enums.Leeraar;
import enums.OpdrachtCategorie; 
import model.opdracht.Opdracht;
import model.opdracht.QuizOpdracht;
import model.opdracht.OpdrachtCatalogus;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import model.quiz.Quiz;

public class QuizCatalogusTest {
	
	
	private OpdrachtCatalogus opdrachtCatalogus;
	private Opdracht vraag;
	//private QuizOpdracht qo;
	private Quiz quiz;
	
	public ArrayList<Quiz> quizLijst = new ArrayList<Quiz>();
	private ArrayList<QuizOpdracht> eenQuizOpdrachtLijst;
	Quiz quiz2 = new Quiz("Aardrijkskunde", Leerjaar.eerste , true, false, Leeraar.Bart);
	
	@Test
	public void testQuizCatalogus() {
		System.out.println("Test: Aanmaken QuizCatalugus");
		//quizLijst = new ArrayList<Quiz>();		
	}
	

	@Test
	public void testVoegQuizToe() {
		System.out.println("Test: VoegQuizToe");
		quiz =  new Quiz("Aardrijkskunde", Leerjaar.eerste , true, false, Leeraar.Bart);
		quizLijst.add(quiz);
		System.out.println("Quizcatalogus bevat " + quizLijst.size() + " quiz(zen)");
		
		
		}
	

	@Test
	public void test_VerwijderQuiz() {
		System.out.println("Test: VerwijderQuiz");
<<<<<<< HEAD
		//eerst een vraag creëren
=======
		//eerst een vraag creÃ«ren
>>>>>>> refs/remotes/origin/master
		
		ArrayList<String> antwoordhints = new ArrayList<String>();
		antwoordhints.add("Eifeloren");
		vraag = new Opdracht("Hoofdstad_Frankrijk_?", "Parijs",3,antwoordhints , 30, Leeraar.Eli, OpdrachtCategorie.AlgemeneKennis);
		
		
		//vraag toevoegen aan quizopdracht
		QuizOpdracht quizOpdracht = new QuizOpdracht (quiz,vraag, 5); 
		ArrayList<QuizOpdracht> toeTeVoegenQuizOpdrachten = new ArrayList<QuizOpdracht>();

		for (QuizOpdracht qO : eenQuizOpdrachtLijst) {
			if (qO.equals(quizOpdracht)) {
				toeTeVoegenQuizOpdrachten.add(qO);
			}
		}
		//controle
		
		quiz.voegQuizOpdrachtToe(quizOpdracht);
		System.out.println("Aantal vragen in quiz" +  opdrachtCatalogus.opdrachtenLijst.size() );
		
		if (opdrachtCatalogus.opdrachtenLijst.size() > 0){
			System.out.println(
					"Quiz kan niet verwijderd worden wanneer er reeds opdrachten zijn aan toegevoegd");}
		else
		{	quizLijst.remove(quiz);}
	}
		
	
	@Test
	public void testClone() {
		System.out.println("Test: Clone");
		//clonen om equals te vergelijken
		
	}

	@Test
	public void testToString() {
		System.out.println("Test: ToString");
		
		
	}

	@Test
	public void testEqualsObject() {
		System.out.println("Test: EqualsObject");
		
		assertEquals( quiz, quiz2);
	}

	@Test
	public void testCompareTo() {
		System.out.println("Test: CompareTo");
	}

	@Test
	public void testIterator() {
		System.out.println("Test: Iterator");
	}

}
