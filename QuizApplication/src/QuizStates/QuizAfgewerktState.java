package QuizStates;

import utils.QuizCatalogus;
import model.opdracht.QuizOpdracht;
import model.quiz.Quiz;

public class QuizAfgewerktState implements QuizState {

	@Override
	public void verwijderQuizOpdracht(Quiz quiz, QuizOpdracht quizOpdracht) {
		System.out.printf("QuizOpdracht %s kan niet verwijderd worden uit Quiz %s.", quizOpdracht, quiz);
	}

	@Override
	public void voegQuizOpdrachtToe(Quiz quiz, QuizOpdracht quizOpdracht) {
		System.out.printf("QuizOpdracht %s kan niet toegevoegd worden aan Quiz %s.", quizOpdracht, quiz);
	}

	@Override
	public void verwijderQuiz(Quiz quiz) {
		for(QuizOpdracht quizOpdracht : quiz.getEenQuizOpdrachtLijst())
		{
			quizOpdracht.ontkoppelOpdrachtVanQuiz();
		}
		QuizCatalogus.deleteQuizFromCatalogue(quiz);
	}

	@Override
	public void neemDeelAanQuiz(Quiz quiz) {
		// TODO Auto-generated method stub
		
	}

}
