package utils;

import model.opdracht.QuizOpdracht;
import utils.datum.Datum;
import enums.Leeraar;
import enums.Leerjaar;
import enums.QuizStatus;

public class Quiz implements Comparable<Quiz>, Cloneable {
	private String onderwerp;
	private Leerjaar leerjaar;
	private Boolean isTest;
	private Boolean isUniekeDeelname;
	private QuizStatus quizStatus;
	private Leeraar leraar;
	private Datum registratieDatum;

	// constructor met parameters
	public Quiz(String onderwerp, Leerjaar leerjaar, Boolean isTest, Boolean isUniekeDeelname, Leeraar leraar) {
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

		return onderwerp;
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
			String regex = "\\s*\\b(de|een|het|met|van|in)\\b\\s*";

			String nieuwOnderwerp = this.onderwerp.replaceAll(regex, "");
			String inputNieuwOnderwerp = o.onderwerp.replaceAll(regex, "");

			if (nieuwOnderwerp.replace(" ", "").equalsIgnoreCase(inputNieuwOnderwerp.replace(" ", ""))) {
				return 0;
			}
		}
		return this.registratieDatum.verschilInDagen(o.registratieDatum);
	}

	public void verwijderQuizOpdracht(QuizOpdracht quizOpdracht) {
		// TODO Auto-generated method stub
	}

}
