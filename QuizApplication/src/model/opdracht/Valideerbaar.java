package model.opdracht;

public interface Valideerbaar {
	boolean valide(String antwoord);
	String getValideerTekst();
}
