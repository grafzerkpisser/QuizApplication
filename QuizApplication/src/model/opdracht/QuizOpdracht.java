package model.opdracht;

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

	public QuizOpdracht(QuizOpdracht quizOpdracht) {
		this.eenQuiz = quizOpdracht.eenQuiz;
		this.eenOpdracht = quizOpdracht.eenOpdracht;
		this.maxScore = quizOpdracht.maxScore;

	}

	public QuizOpdracht() {
		this.maxScore = 0;
	}

	@Override
	public int compareTo(QuizOpdracht eenQuizOpdracht) {
		return eenQuizOpdracht.compareTo(this);
	}

	@Override
	public QuizOpdracht clone() throws CloneNotSupportedException {

		return new QuizOpdracht(this);

	}

	public static void koppelOpdrachtAanQuiz(Quiz eenQuiz, Opdracht eenOpdracht, int eenMaxScore) {
		QuizOpdracht eenQuizOpdracht = new QuizOpdracht(eenQuiz, eenOpdracht, eenMaxScore);
		eenQuiz.voegQuizOpdrachtToe(eenQuizOpdracht);
		eenOpdracht.voegQuizOpdrachtToe(eenQuizOpdracht);
	}

	public void ontkoppelOpdrachtVanQuiz() {
		eenQuiz.verwijderQuizOpdracht(this);
		eenOpdracht.verwijderQuizOpdracht(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((eenOpdracht == null) ? 0 : eenOpdracht.hashCode());
		result = prime * result + ((eenQuiz == null) ? 0 : eenQuiz.hashCode());
		result = prime * result + maxScore;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuizOpdracht other = (QuizOpdracht) obj;
		if (eenOpdracht == null) {
			if (other.eenOpdracht != null)
				return false;
		} else if (!eenOpdracht.equals(other.eenOpdracht))
			return false;
		if (eenQuiz == null) {
			if (other.eenQuiz != null)
				return false;
		} else if (!eenQuiz.equals(other.eenQuiz))
			return false;
		if (maxScore != other.maxScore)
			return false;
		return true;
	}

}
