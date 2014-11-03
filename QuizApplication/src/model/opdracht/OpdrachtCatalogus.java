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

	public void wijzigVraag(Opdracht o, String vraag) {
		o.setVraag(vraag);
	}

	public void wijzigAntwoord(Opdracht o, String juisteAntwoord) {
		o.setJuisteAntwoord(juisteAntwoord);
	}
	
	public void verwijderOpdracht(Opdracht o)
	{
		//
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
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Opdracht)) {
			return false;
		}

		OpdrachtCatalogus d = (OpdrachtCatalogus) obj;

		return compareTo(d) == 0;
	}

	@Override
	public Iterator<OpdrachtCatalogus> iterator() {

		return null;
	}

	@Override
	public int compareTo(OpdrachtCatalogus o) {
		return o.compareTo(this);
	}

	@Override
	public OpdrachtCatalogus clone() throws CloneNotSupportedException {
		{
			OpdrachtCatalogus o_c = new OpdrachtCatalogus();
			o_c.opdrachtenLijst = this.opdrachtenLijst;
			return o_c;
		}

	}
}
