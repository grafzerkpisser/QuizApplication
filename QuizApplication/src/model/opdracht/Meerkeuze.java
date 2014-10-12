package model.opdracht;

import java.util.ArrayList;

import enums.Leeraar;
import enums.OpdrachtCategorie;

public class Meerkeuze extends Opdracht implements Valideerbaar {

	private ArrayList<String> keuzes;
	public static final String VALIDEERTEKST = "Geen geldige keuze";
	public Meerkeuze(String vraag, String juisteAntwoord, Integer maxAantalPogingen, ArrayList<String> antwoordHints,
			Integer maxAntwoordTijd, ArrayList<String> keuzes, 
			Leeraar leeraar, OpdrachtCategorie opdrachtCategorie) {
		super(vraag, juisteAntwoord, maxAantalPogingen, antwoordHints, maxAntwoordTijd, 
				leeraar,opdrachtCategorie);
		this.keuzes = keuzes;
	}
	public void voegKeuzeToe(String keuze)
	{
		keuzes.add(keuze);
	}
	public void verwijderKeuze(Integer index)
	{
		keuzes.remove(index);
	}
	public boolean valide(String antwoord) {
		for (String s : keuzes) {
			if(s==antwoord)
				return true;
		}
		return false;
	}
	public String getValideerTekst() {
		return VALIDEERTEKST;
	}

}
