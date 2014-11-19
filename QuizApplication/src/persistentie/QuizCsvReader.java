package persistentie;

import java.io.IOException;
import java.io.ObjectInput;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.opdracht.QuizCatalogus;

public class QuizCsvReader extends AbstractCSVReader<QuizCatalogus> {

	@Override
	Set<QuizCatalogus> unmarshall(ObjectInput input) throws ClassNotFoundException, IOException{
		try{
		List<QuizCatalogus> quizLijst = new ArrayList<QuizCatalogus>(); 
		quizLijst.add((QuizCatalogus)input. readObject());
		Set<QuizCatalogus>quizen = new HashSet<QuizCatalogus>(quizLijst);
		return quizen;
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
