package QuizStates;

import java.util.UUID;

import model.opdracht.QuizOpdracht;
import model.quiz.Quiz;

public interface QuizState {
	void verwijderQuizOpdracht(Quiz quiz, QuizOpdracht quizOpdracht)throws IllegalStateException;
	void voegQuizOpdrachtToe(Quiz quiz, QuizOpdracht quizOpdracht) throws IllegalStateException, IllegalArgumentException;
	void verwijderQuiz(Quiz quiz) throws IllegalStateException;
	void neemDeelAanQuiz(Quiz quiz) throws IllegalStateException;
}
