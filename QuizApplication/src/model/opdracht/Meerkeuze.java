package model.opdracht;


import java.io.Serializable;
import java.util.ArrayList;

import enums.Leeraar;
import enums.OpdrachtCategorie;

@SuppressWarnings("serial")
public class Meerkeuze extends Opdracht implements Valideerbaar, Serializable {

	private ArrayList<String> keuzes;
	public ArrayList<String> getKeuzes()
	{
		return keuzes;
	}
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
	@SuppressWarnings("unused")
	public void verwijderKeuze(Integer index)
	{
		boolean b = (keuzes.remove(index.intValue()) != null);
		
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
	@Override
	public String toString() {
		return "Meerkeuze [keuzes=" + keuzes + "]";
	}

}
