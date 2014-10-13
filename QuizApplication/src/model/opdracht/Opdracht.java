package model.opdracht;

import java.util.ArrayList;

import utils.datum.Datum;
import enums.Leeraar;
import enums.OpdrachtCategorie;


public class Opdracht implements Comparable<Opdracht> {
	private String vraag;
	private String juisteAntwoord;
	private Integer maxAantalPogingen;
	private ArrayList<String> antwoordHints;
	private Integer maxAntwoordTijd;
	private Leeraar leeraar;
	private OpdrachtCategorie opdrachtCategorie;
	private Datum aanmaakDatum;
	public void setAanmaakDatum(Datum aanmaakDatum)
	{
		this.aanmaakDatum = aanmaakDatum;
	}
	public void setVraag(String vraag)
	{
		this.vraag = vraag;
	}
	public void setJuisteAntwoord(String juisteAntwoord)
	{
		this.juisteAntwoord = juisteAntwoord;
	}
	public void setMaxAantalPogingen(Integer maxAantalPogingen)
	{
		this.maxAantalPogingen = maxAantalPogingen;
	}
	public void setAntwoordHints(ArrayList<String> antwoordHints)
	{
		this.antwoordHints = antwoordHints;
	}
	public void setMaxAntwoordTijd(Integer maxAntwoordTijd)
	{
		this.maxAntwoordTijd = maxAntwoordTijd;
	}
	public void setLeeraar(Leeraar leeraar)
	{
		this.leeraar = leeraar;
	}
	public void setOpdrachtCategorie(OpdrachtCategorie opdrachtCategorie)
	{
		this.opdrachtCategorie = opdrachtCategorie;
	}
	public Datum getAanmaakDatum()
	{
		return aanmaakDatum;
	}
	public OpdrachtCategorie getOpdrachtCategorie()
	{
		return opdrachtCategorie;
	}
	public Leeraar getLeeraar()
	{
		return leeraar;
	}
	public String getVraag()
	{
		return vraag;
	}
	public String getJuisteAntwoord()
	{
		return juisteAntwoord;
	}
	public Integer getMaxaantaPogingen()
	{
		return maxAantalPogingen;
	}
	public ArrayList<String> getAntwoordHints()
	{
		return antwoordHints;
	}
	public Integer getMaxAntwoordTijd()
	{
		return maxAntwoordTijd;
	}
	public Opdracht(String vraag, String juisteAntwoord,
			Integer maxAantalPogingen, ArrayList<String> antwoordHints,
			Integer maxAntwoordTijd, Leeraar leeraar, OpdrachtCategorie opdrachtCategorie){
		this.vraag = vraag;
		this.juisteAntwoord = juisteAntwoord;
		this.maxAantalPogingen = maxAantalPogingen;
		this.antwoordHints = antwoordHints;
		this.maxAntwoordTijd = maxAntwoordTijd;
		this.leeraar = leeraar;
		this.opdrachtCategorie = opdrachtCategorie;
		this.aanmaakDatum = new Datum();
	}
	public boolean isJuisteAntwoord(String antwoord)
	{
		return antwoord.equals(this.juisteAntwoord);
	}
	@Override
	public int compareTo(Opdracht o) {
		return o.compareTo(this);
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Opdracht)) {
			return false;
		}

		Opdracht d = (Opdracht) obj;

		return compareTo(d) == 0;
	}
	
	
}
