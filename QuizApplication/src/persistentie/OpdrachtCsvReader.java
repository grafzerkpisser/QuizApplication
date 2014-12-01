package persistentie;

import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.opdracht.OpdrachtCatalogus;

public class OpdrachtCsvReader extends AbstractCSVReader<OpdrachtCatalogus> {
	
	@Override
	Set<OpdrachtCatalogus> unmarshall(ObjectInput input) throws ClassNotFoundException, IOException{
		try{
		List<OpdrachtCatalogus> opdrachtLijst = new ArrayList<OpdrachtCatalogus>(); 
		opdrachtLijst.add((OpdrachtCatalogus)input. readObject());
		Set<OpdrachtCatalogus>opdrachten = new HashSet<OpdrachtCatalogus>(opdrachtLijst);
		return opdrachten;
		}
		catch(IOException ex)
		{
			throw new IOException("File kan niet gelezen worden.");
		}
		catch(ClassNotFoundException ex)
		{
			throw new ClassNotFoundException("Klasse kan niet gevonden worden.");
		}
		
	}

}
