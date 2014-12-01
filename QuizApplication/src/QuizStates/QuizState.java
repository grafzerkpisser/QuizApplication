package QuizStates;

import java.util.UUID;

import model.opdracht.QuizOpdracht;
import model.quiz.Quiz;

public interface QuizState {
	void verwijderQuizOpdracht(Quiz quiz, QuizOpdracht quizOpdracht);
	void voegQuizOpdrachtToe(Quiz quiz, QuizOpdracht quizOpdracht);
	void verwijderQuiz(Quiz quiz);
	void neemDeelAanQuiz(Quiz quiz);
}
