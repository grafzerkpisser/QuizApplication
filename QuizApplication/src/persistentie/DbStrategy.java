package persistentie;

import java.io.IOException;
import java.util.Set;
import model.opdracht.OpdrachtCatalogus;
import model.opdracht.QuizCatalogus;
import model.opdracht.QuizOpdracht;

public interface DbStrategy {
	Set<OpdrachtCatalogus> leesOpdrachten() throws ClassNotFoundException, IOException;
	void bewaarOpdrachten(OpdrachtCatalogus opdrachtCatalogus) throws IOException;
	Set<QuizCatalogus> leesQuizen() throws ClassNotFoundException, IOException;
	Set<QuizOpdracht> leesQuizOpdrachten();
	void bewaarQuizen(QuizCatalogus quizCatalogus) throws IOException; 
}
