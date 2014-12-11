package QuizStates;

import model.opdracht.QuizOpdracht;
import model.quiz.Quiz;

public class QuizLaatsteKansState implements QuizState {

	@Override
	public void verwijderQuizOpdracht(Quiz quiz, QuizOpdracht quizOpdracht) throws IllegalStateException {
		throw new IllegalStateException(String.format("QuizOpdracht %s kan niet verwijderd worden uit Quiz %s.", quizOpdracht, quiz));
	}

	@Override
	public void voegQuizOpdrachtToe(Quiz quiz, QuizOpdracht quizOpdracht) throws IllegalStateException, IllegalArgumentException {
		throw new IllegalStateException(String.format("QuizOpdracht %s kan niet toegevoegd worden aan Quiz %s.", quizOpdracht, quiz));
	}

	@Override
	public void verwijderQuiz(Quiz quiz) throws IllegalStateException {
		throw new IllegalStateException(String.format("Quiz %s kan niet verwijderd worden.", quiz));
	}

	@Override
	public void neemDeelAanQuiz(Quiz quiz) throws IllegalStateException {
		throw new IllegalStateException(String.format("Deelname aan quiz %s is nog mogelijk, doch je moet je haasten.", quiz));		
	}
}
