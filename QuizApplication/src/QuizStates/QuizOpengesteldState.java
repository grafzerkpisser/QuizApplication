package QuizStates;

import model.opdracht.QuizOpdracht;
import model.quiz.Quiz;

public class QuizOpengesteldState implements QuizState {

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
		System.out.printf("Quiz %s kan niet verwijderd worden.", quiz);
	}

	@Override
	public void neemDeelAanQuiz(Quiz quiz) {
		System.out.printf("Deelname aan quiz %s is nog mogelijk.", quiz);
		
	}
}