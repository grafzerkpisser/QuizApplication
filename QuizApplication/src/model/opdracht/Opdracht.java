package model.opdracht;

import java.util.ArrayList;
import java.util.UUID;

import model.quiz.Quiz;
import utils.datum.Datum;
import enums.Leeraar;
import enums.OpdrachtCategorie;

public class Opdracht implements Comparable<Opdracht>, Cloneable {
	
	//Properties
	private String vraag;
	private String juisteAntwoord;
	private Integer maxAantalPogingen;
	private ArrayList<String> antwoordHints;
	private Integer maxAntwoordTijd;
	private Leeraar leeraar;
	private OpdrachtCategorie opdrachtCategorie;
	private Datum aanmaakDatum;
	private UUID opdrachtId;	
	private ArrayList<QuizOpdracht> eenQuizOpdrachtLijst;
	
	
	//Getters & Setters
	
	public void setAanmaakDatum(Datum aanmaakDatum) {
		this.aanmaakDatum = aanmaakDatum;
	}

	public void setVraag(String vraag) {
		this.vraag = vraag;
	}

	public void setJuisteAntwoord(String juisteAntwoord) {
		this.juisteAntwoord = juisteAntwoord;
	}

	public void setMaxAantalPogingen(Integer maxAantalPogingen) {
		this.maxAantalPogingen = maxAantalPogingen;
	}

	public void setAntwoordHints(ArrayList<String> antwoordHints) {
		this.antwoordHints = antwoordHints;
	}

	public void setMaxAntwoordTijd(Integer maxAntwoordTijd) {
		this.maxAntwoordTijd = maxAntwoordTijd;
	}

	public void setLeeraar(Leeraar leeraar) {
		this.leeraar = leeraar;
	}

	public void setOpdrachtCategorie(OpdrachtCategorie opdrachtCategorie) {
		this.opdrachtCategorie = opdrachtCategorie;
	}

	public Datum getAanmaakDatum() {
		return aanmaakDatum;
	}

	public OpdrachtCategorie getOpdrachtCategorie() {
		return opdrachtCategorie;
	}

	public Leeraar getLeeraar() {
		return leeraar;
	}

	public String getVraag() {
		return vraag;
	}

	public String getJuisteAntwoord() {
		return juisteAntwoord;
	}

	public Integer getMaxaantaPogingen() {
		return maxAantalPogingen;
	}

	public ArrayList<String> getAntwoordHints() {
		return antwoordHints;
	}

	public Integer getMaxAntwoordTijd() {
		return maxAntwoordTijd;
	}
	public ArrayList<QuizOpdracht> getEenQuizOPdrachtLijst() {
		return eenQuizOpdrachtLijst;
	}
	
	//Constructors
	public Opdracht(String vraag, String juisteAntwoord, Integer maxAantalPogingen, ArrayList<String> antwoordHints,
			Integer maxAntwoordTijd, Leeraar leeraar, OpdrachtCategorie opdrachtCategorie) {
		this.opdrachtId = UUID.randomUUID();
		this.vraag = vraag;
		this.juisteAntwoord = juisteAntwoord;
		this.maxAantalPogingen = maxAantalPogingen;
		this.antwoordHints = antwoordHints;
		this.maxAntwoordTijd = maxAntwoordTijd;
		this.leeraar = leeraar;
		this.opdrachtCategorie = opdrachtCategorie;
		this.aanmaakDatum = new Datum();
	}
	
	//Methods
	public boolean isJuisteAntwoord(String antwoord) {
		return antwoord.equals(this.juisteAntwoord);
	}
	public void wijzigOpdracht() {
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
		ArrayList<QuizOpdracht> toeTeVoegenQuizOpdrachten = new ArrayList<QuizOpdracht>();
		for (QuizOpdracht qO : eenQuizOpdrachtLijst) {
			if (qO.equals(quizOpdracht)) {

				toeTeVoegenQuizOpdrachten.add(qO);
			}
		}

		if (toeTeVoegenQuizOpdrachten.size() != 0) {
			for (QuizOpdracht qO : toeTeVoegenQuizOpdrachten) {
				eenQuizOpdrachtLijst.add(qO);
			}
		}
	}
	
	
	
	//Override Methods
	@Override
	public int compareTo(Opdracht o) {
		return o.compareTo(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((aanmaakDatum == null) ? 0 : aanmaakDatum.hashCode());
		result = prime * result
				+ ((antwoordHints == null) ? 0 : antwoordHints.hashCode());
		result = prime * result
				+ ((juisteAntwoord == null) ? 0 : juisteAntwoord.hashCode());
		result = prime * result + ((leeraar == null) ? 0 : leeraar.hashCode());
		result = prime
				* result
				+ ((maxAantalPogingen == null) ? 0 : maxAantalPogingen
						.hashCode());
		result = prime * result
				+ ((maxAntwoordTijd == null) ? 0 : maxAntwoordTijd.hashCode());
		result = prime
				* result
				+ ((opdrachtCategorie == null) ? 0 : opdrachtCategorie
						.hashCode());
		result = prime * result + ((vraag == null) ? 0 : vraag.hashCode());
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
		Opdracht other = (Opdracht) obj;
		if (aanmaakDatum == null) {
			if (other.aanmaakDatum != null)
				return false;
		} else if (!aanmaakDatum.equals(other.aanmaakDatum))
			return false;
		if (antwoordHints == null) {
			if (other.antwoordHints != null)
				return false;
		} else if (!antwoordHints.equals(other.antwoordHints))
			return false;
		if (juisteAntwoord == null) {
			if (other.juisteAntwoord != null)
				return false;
		} else if (!juisteAntwoord.equals(other.juisteAntwoord))
			return false;
		if (leeraar != other.leeraar)
			return false;
		if (maxAantalPogingen == null) {
			if (other.maxAantalPogingen != null)
				return false;
		} else if (!maxAantalPogingen.equals(other.maxAantalPogingen))
			return false;
		if (maxAntwoordTijd == null) {
			if (other.maxAntwoordTijd != null)
				return false;
		} else if (!maxAntwoordTijd.equals(other.maxAntwoordTijd))
			return false;
		if (opdrachtCategorie != other.opdrachtCategorie)
			return false;
		if (vraag == null) {
			if (other.vraag != null)
				return false;
		} else if (!vraag.equals(other.vraag))
			return false;
		return true;
	}
	@Override
	public String toString()
	{
		return "Vraag: " + this.vraag + " & Categorie: " + this.opdrachtCategorie.toString(); 
	}
	@Override
	public Opdracht clone() throws CloneNotSupportedException {

		try {
			Opdracht q = (Opdracht) super.clone();
			return q;
		} catch (CloneNotSupportedException e) {
			throw e;
		}
	}
	


	
	
}
