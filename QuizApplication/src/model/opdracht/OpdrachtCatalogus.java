package model.opdracht;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class OpdrachtCatalogus implements Iterable<OpdrachtCatalogus>,
		Comparable<OpdrachtCatalogus>, Cloneable {

	public ArrayList<Opdracht> opdrachtenLijst;

	public OpdrachtCatalogus() {
		opdrachtenLijst = new ArrayList<Opdracht>();
	}

	public void voegOpdrachtToe(Opdracht o) {
		opdrachtenLijst.add(o);
	}

	public void wijzigVraag(Opdracht o, String vraag) throws Exception {
		if (o.getEenQuizOPdrachtLijst().size() > 0)
			throw new Exception(
					"Vraag kan niet gewijzigd worden wanneer reeds toegevoegd aan een Quiz");
		else
			o.setVraag(vraag);
	}

	public void wijzigAntwoord(Opdracht o, String juisteAntwoord)
			throws Exception {
		if (o.getEenQuizOPdrachtLijst().size() > 0)
			throw new Exception(
					"Antwoord kan niet gewijzigd worden wanneer reeds toegevoegd aan een Quiz");
		else
			o.setJuisteAntwoord(juisteAntwoord);
	}

	public void verwijderOpdracht(Opdracht o) throws Exception {
		if (o.getEenQuizOPdrachtLijst().size() > 0)
			throw new Exception(
					"Opdracht kan niet verwijderd worden wanneer reeds toegevoegd aan een Quiz");
		else
			opdrachtenLijst.remove(o);
	}

	@Override
	public String toString() {
		String opdrachten = "";
		for (Opdracht o : opdrachtenLijst) {
			opdrachten += o.toString() + "/n";
		}
		return opdrachten;
	}

	@Override
	public int compareTo(OpdrachtCatalogus o) {
		return o.compareTo(this);
	}

	@Override
	public Iterator<OpdrachtCatalogus> iterator() {

		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((opdrachtenLijst == null) ? 0 : opdrachtenLijst.hashCode());
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
		OpdrachtCatalogus other = (OpdrachtCatalogus) obj;
		if (opdrachtenLijst == null) {
			if (other.opdrachtenLijst != null)
				return false;
		} else if (!opdrachtenLijst.equals(other.opdrachtenLijst))
			return false;
		return true;
	}

	@Override
	public OpdrachtCatalogus clone() throws CloneNotSupportedException {

		OpdrachtCatalogus o_c = new OpdrachtCatalogus();
		o_c.opdrachtenLijst = this.opdrachtenLijst;
		return o_c;
	}
}
