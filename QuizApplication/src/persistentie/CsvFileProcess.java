package persistentie;

import java.io.File;
import java.io.IOException;

import java.nio.file.Paths;
import java.util.Set;


import model.opdracht.OpdrachtCatalogus;
import model.opdracht.QuizCatalogus;
import model.opdracht.QuizOpdracht;

public class CsvFileProcess implements DbStrategy {

	@Override
	public Set<OpdrachtCatalogus> leesOpdrachten() throws ClassNotFoundException, IOException {
		OpdrachtCsvReader opdrachtCsvReader = new OpdrachtCsvReader();
		File file = new File(Paths.get("opdrachten.ser").toFile().getPath());
		Set<OpdrachtCatalogus> opdrachten = opdrachtCsvReader.getAll(file);
		return opdrachten;
	}

	@Override
	public Set<QuizCatalogus> leesQuizen() throws ClassNotFoundException, IOException {
		QuizCsvReader quizCsvReader = new QuizCsvReader();
		File file = new File(Paths.get("quizen.ser").toFile().getPath());
		Set<QuizCatalogus> quizen = quizCsvReader.getAll(file);
		return quizen;
		
	}

	@Override
	public Set<QuizOpdracht> leesQuizOpdrachten() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void bewaarOpdrachten(OpdrachtCatalogus opdrachtCatalogus) throws IOException {
		CsvWriter csvWriter = new CsvWriter();
		csvWriter.SetAllOpdrachten(opdrachtCatalogus);
	}
	@Override
	public void bewaarQuizen(QuizCatalogus quizCatalogus) throws IOException {
		CsvWriter csvWriter = new CsvWriter();
		csvWriter.SetAllQuizen(quizCatalogus);
	}

}
