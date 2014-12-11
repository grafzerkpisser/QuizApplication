package QuizStates;

import java.util.ArrayList;
import java.util.UUID;

import model.opdracht.QuizOpdracht;
import model.quiz.Quiz;

public class QuizInConstructionState implements QuizState {

	@Override
	public void verwijderQuizOpdracht(Quiz quiz, QuizOpdracht quizOpdracht) throws IllegalStateException {
		ArrayList<QuizOpdracht> teVerwijderenQuizOpdrachten = new ArrayList<QuizOpdracht>();
		for (QuizOpdracht qO : quiz.getEenQuizOpdrachtLijst()) {
			if (qO.equals(quizOpdracht)) {

				teVerwijderenQuizOpdrachten.add(quizOpdracht);
			}
		}

		for (QuizOpdracht qO : teVerwijderenQuizOpdrachten) {
			quiz.getEenQuizOpdrachtLijst().remove(qO);
		}		
	}

	@Override
	public void voegQuizOpdrachtToe(Quiz quiz, QuizOpdracht quizOpdracht) throws IllegalStateException {
		ArrayList<QuizOpdracht> toeTeVoegenQuizOpdrachten = new ArrayList<QuizOpdracht>();
		for (QuizOpdracht qO : quiz.getEenQuizOpdrachtLijst()) {
			if (qO.equals(quizOpdracht)) {

				toeTeVoegenQuizOpdrachten.add(qO);
			}
		}

		if (toeTeVoegenQuizOpdrachten.size() != 0) {
			for (QuizOpdracht qO : toeTeVoegenQuizOpdrachten) {
				quiz.getEenQuizOpdrachtLijst().add(qO);
			}
		}
	}

	@Override
	public void verwijderQuiz(Quiz quiz) throws IllegalStateException {
		for(QuizOpdracht quizOpdracht : quiz.getEenQuizOpdrachtLijst())
		{
			quizOpdracht.ontkoppelOpdrachtVanQuiz();
		}
		System.out.printf("Quiz %s is nog niet gekoppeld aan de QuizCatalogus.", quiz);
	}

	@Override
	public void neemDeelAanQuiz(Quiz quiz) throws IllegalStateException {
		// TODO Auto-generated method stub
		
	}

}
