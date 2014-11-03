package model.Opdracht;
package model.Quiz;

import utils.Quiz;

public class QuizOpdracht implements Comparable<QuizOpdracht>, Cloneable {

	private int maxScore;
	private Opdracht eenOpdracht;
	private Quiz eenQuiz;

	public Opdracht getEenOpdracht() {
		return eenOpdracht;
	}

	public void setEenOpdracht(Opdracht eenOpdracht) {
		this.eenOpdracht = eenOpdracht;
	}

	public int getMaxscore() {
		return maxScore;
	}

	public void setMaxscore(int maxscore) {
		this.maxScore = maxscore;
	}

	public QuizOpdracht(Quiz eenQuiz, Opdracht eenOpdracht, int eenMaxScore) {
		this.eenQuiz = eenQuiz;
		this.eenOpdracht = eenOpdracht;
		this.maxScore = eenMaxScore;
	}

	@Override
	public int compareTo(QuizOpdracht eenQuizOpdracht) {
		return eenQuizOpdracht.compareTo(this);
	}

	@Override
	public QuizOpdracht clone() {

		return new QuizOpdracht(this);

	}

	public static void koppelOpdrachtAanQuiz(Quiz eenQuiz, Opdracht eenOpdracht, int eenMaxScore)
	{
		QuizOpdracht eenQuizOpdracht = new QuizOpdracht(eenQuiz, eenOpdracht, eenMaxScore);
		eenQuiz.voegQuizOpdrachtToe(eenQuizOpdracht);
		eenOpdracht.voegQuizOpdrachtToe(eenQuizOpdracht);
	}

	public void ontkoppelOpdrachtVanQuiz()
	{
		eenQuiz.verwijderQuizOpdracht(this);
		eenOpdracht.verwijderQuizOpdracht(this);
	}
}

