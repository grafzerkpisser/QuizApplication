package model.opdracht;

import java.util.ArrayList;

import enums.Leeraar;
import enums.OpdrachtCategorie;

public class Reproductie extends Opdracht {

	private ArrayList<String> trefwoorden;
	public Reproductie(String vraag, String juisteAntwoord, Integer maxAantalPogingen, ArrayList<String> antwoordHints,
			Integer maxAntwoordTijd, Leeraar leeraar, ArrayList<String> trefwoorden,
			OpdrachtCategorie opdrachtCategorie) {
		super(vraag, juisteAntwoord, maxAantalPogingen, antwoordHints, maxAntwoordTijd, 
				leeraar,opdrachtCategorie);
		this.trefwoorden = trefwoorden;
	}
	public void voegTrefwoordToe(String trefwoord)
	{
		this.trefwoorden.add(trefwoord);
	}
	public void VerwijderTrefwoord(Integer index)
	{
		this.trefwoorden.remove(index);
	}

}
