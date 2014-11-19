package model.quiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import model.opdracht.QuizOpdracht;
import utils.datum.Datum;
import enums.Leeraar;
import enums.Leerjaar;
import enums.QuizStatus;

@SuppressWarnings("serial")
public class Quiz implements Comparable<Quiz>, Cloneable, Serializable {
	@SuppressWarnings("unused")
	private UUID quizId;
	private String onderwerp;
	private Leerjaar leerjaar;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private QuizStatus quizStatus;
	private Leeraar leraar;
	private Datum registratieDatum;
	private ArrayList<QuizOpdracht> eenQuizOpdrachtLijst;
	
	// constructor met parameters
	public Quiz(String onderwerp, Leerjaar leerjaar, Boolean isTest, Boolean isUniekeDeelname, Leeraar leraar) {
		eenQuizOpdrachtLijst = new ArrayList<QuizOpdracht>();
		this.quizId = UUID.randomUUID();
		this.onderwerp = onderwerp;
		this.leerjaar = leerjaar;
		this.isTest = isTest;
		this.isUniekeDeelname = isUniekeDeelname;
		this.quizStatus = QuizStatus.IN_CONSTRUCTIE;
		this.leraar = leraar;
		registratieDatum = new Datum();
	}

	public String getOnderwerp() {
		return onderwerp;
	}

	public Leerjaar getLeerjaar() {
		return leerjaar;
	}

	public Boolean getIsTest() {
		return isTest;
	}

	public Boolean getIsUniekeDeelname() {
		return isUniekeDeelname;
	}

	public QuizStatus getQuizStatus() {
		return quizStatus;
	}

	public String getCleanOnderwerp() {
		String regex = "\\s*\\b(de|een|het|met|van|in)\\b\\s*";

		String nieuwOnderwerp = this.onderwerp.replaceAll(regex, "");
		return nieuwOnderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public void setLeerjaar(Leerjaar leerjaar) {
		this.leerjaar = leerjaar;
	}

	public void setIsTest(Boolean isTest) {
		this.isTest = isTest;
	}

	public void setIsUniekeDeelname(Boolean isUniekeDeelname) {
		this.isUniekeDeelname = isUniekeDeelname;
	}

	public void setQuizStatus(QuizStatus quizStatus) {
		this.quizStatus = quizStatus;
	}
	public ArrayList<QuizOpdracht> getEenQuizOpdrachtLijst() {
		return eenQuizOpdrachtLijst;
	}
	
	

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Quiz)) {
			return false;
		}

		Quiz q = (Quiz) obj;

		return compareTo(q) == 0;
	}

	@Override
	public Quiz clone() throws CloneNotSupportedException {

		try {
			Quiz q = (Quiz) super.clone();
			return q;
		} catch (CloneNotSupportedException e) {
			throw e;
		}
	}

	@Override
	public int hashCode() {
		return this.leraar.getValue() + this.registratieDatum.verschilInDagen(new Datum()) + this.registratieDatum.hashCode();
	}

	@Override
	public String toString() {
		return String.format("%s, %s", this.onderwerp, this.registratieDatum);
	}

	@Override
	public int compareTo(Quiz o) {
		if (o.onderwerp.equalsIgnoreCase(this.onderwerp)) {
			return 0;
		} else {
			String inputNieuwOnderwerp = o.getCleanOnderwerp();

			if (getCleanOnderwerp().replace(" ", "").equalsIgnoreCase(inputNieuwOnderwerp.replace(" ", ""))) {
				return 0;
			}
		}
		return this.registratieDatum.verschilInDagen(o.registratieDatum);
	}

	public void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {

		ArrayList<QuizOpdracht> teVerwijderenQuizOpdrachten = new ArrayList<QuizOpdracht>();
		for (QuizOpdracht qO : eenQuizOpdrachtLijst) {
			if (qO.equals(quizOpdracht)) {

				teVerwijderenQuizOpdrachten.add(quizOpdracht);
			}
		}

		for (QuizOpdracht qO : teVerwijderenQuizOpdrachten) {
			eenQuizOpdrachtLijst.remove(qO);
		}
	}

	public void voegQuizOpdrachtToe(QuizOpdracht quizOpdracht) {
		eenQuizOpdrachtLijst.add(quizOpdracht);
	}
}
