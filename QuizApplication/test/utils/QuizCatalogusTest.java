package utils;
import enums.Leerjaar;
import enums.QuizStatus;

import static org.junit.Assert.*;

import java.util.ArrayList;

import model.quiz.Quiz;

import org.junit.Test;

import enums.Leerjaar;
import enums.QuizStatus;

public class QuizCatalogusTest  {  

	private String onderwerp;
	private Leerjaar leerjaar;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private QuizStatus quizStatus;

	@Test
	public void testQuizCatalogus() {
		System.out.println("Test: Aanmaken QuizCatalugus");
		ArrayList<Quiz> quizLijst = new ArrayList<Quiz>();
		
	}

	@Test
	public void testVoegQuizToe(Quiz q) {
		System.out.println("Test: VoegQuizToe");
		Quiz quiz =  new Quiz("Aardrijkskunde", "eerste" , true, false, "AFGEWERKT");
		
		}

	@Test
	public void testVerwijderQuiz() {
		System.out.println("Test: VerwijderQuiz");
		
	}

	@Test
	public void testClone() {
		System.out.println("Test: Clone");
		//clonen om equlas te vergelijken
		
	}

	@Test
	public void testToString() {
		System.out.println("Test: ToString");
	}

	@Test
	public void testEqualsObject() {
		System.out.println("Test: EqualsObject");
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
