package model.opdracht;

import java.io.Serializable;
import java.util.ArrayList;

import enums.Leeraar;
import enums.OpdrachtCategorie;

@SuppressWarnings("serial")
public class Opsomming extends Opdracht implements Valideerbaar,Serializable {

	private Boolean inJuisteVolgorde;
	public static final String VALIDEERTEKST = "Typ je antwoorden achter elkaar gescheiden door ;";
	
	public Opsomming(String vraag, String juisteAntwoord, Integer maxAantalPogingen, ArrayList<String> antwoordHints,
			Integer maxAntwoordTijd, Boolean inJuisteVolgorde, 
			Leeraar leeraar,OpdrachtCategorie opdrachtCategorie) {
		super(vraag, juisteAntwoord, maxAantalPogingen, antwoordHints, maxAntwoordTijd, 
				leeraar,opdrachtCategorie);
		this.inJuisteVolgorde = inJuisteVolgorde;
	}
	public Boolean getInJuisteVolgorde()
	{
		return inJuisteVolgorde;
	}
	public boolean valide(String antwoord) {
		String[] parts = antwoord.split(";");
		if(parts.length != this.getJuisteAntwoord().split(";").length)
			return false;
		return true;
	}
	public String getValideerTekst() {
		return VALIDEERTEKST;
	}
	public void setInJuisteVolgorde(Boolean inJuisteVolgorde)
	{
		this.inJuisteVolgorde = inJuisteVolgorde;
	}
	@Override
	public String toString() {
		return "Opsomming [inJuisteVolgorde=" + inJuisteVolgorde + "]";
	}
	

}
