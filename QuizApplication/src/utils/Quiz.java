package utils;

import model.opdracht.QuizOpdracht;

public class Quiz {
	private String onderwerp;
	private int leerjaar;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private String quizStatus;

	// default constructor
	public Quiz() {
		onderwerp = "THEMA";
		leerjaar = 0;
		isTest = true;
		isUniekeDeelname = false;
		quizStatus = "Open";
	}

	// constructor met parameters
	public Quiz(String onderwerp, int leerjaar, Boolean isTest, Boolean isUniekeDeelname, String quizStatus) {
		Quiz newQuiz = new Quiz();
		onderwerp = newQuiz.onderwerp;
		leerjaar = newQuiz.leerjaar;
		isTest = newQuiz.isTest;
		isUniekeDeelname = newQuiz.isUniekeDeelname;
		quizStatus = newQuiz.quizStatus;
	}

	public void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		// TODO Auto-generated method stub

	}

}
