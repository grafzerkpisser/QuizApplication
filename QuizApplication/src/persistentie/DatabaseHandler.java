package persistentie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.opdracht.Opdracht;
import model.opdracht.OpdrachtCatalogus;
import model.opdracht.QuizCatalogus;
import model.opdracht.QuizOpdracht;
import model.quiz.Quiz;

public class DatabaseHandler {

	private DbStrategy dbStrategy;
	private List<OpdrachtCatalogus> opdrachtCatalogus;
	private List<QuizCatalogus> quizCatalogus;
	private OpdrachtCatalogus resultOpdrachtCatalogus;
	private QuizCatalogus resultQuizCatalogus;
	
	public OpdrachtCatalogus getOpdrachtCatalogus()
	{
		return resultOpdrachtCatalogus;
	}
	public QuizCatalogus getQuizCatalogus()
	{
		return resultQuizCatalogus;
	}
	public DatabaseHandler(DbStrategy dbStrategy){
		this.dbStrategy = dbStrategy;
		resultOpdrachtCatalogus = new OpdrachtCatalogus();
	}
	
	public void vulCatalogi() throws ClassNotFoundException, IOException{
		opdrachtCatalogus = new ArrayList<OpdrachtCatalogus>(dbStrategy.leesOpdrachten());
		dbStrategy.leesQuizen();
		
	}
	
	public void saveCatalogi(){
		
	}
	public void generateMapping(){
		for (OpdrachtCatalogus opdrachtcatalogus : opdrachtCatalogus) {
			for (Opdracht opdracht : opdrachtcatalogus.opdrachtenLijst) {
				if(opdracht.getEenQuizOPdrachtLijst().size() == 0){
					resultOpdrachtCatalogus.voegOpdrachtToe(opdracht);
				}
			}
		}
		for (QuizCatalogus quizcatalogus : quizCatalogus) {
			this.resultQuizCatalogus = quizcatalogus;
			for (Quiz quiz 	: quizcatalogus.quizLijst) {
				for (QuizOpdracht quizOpdracht : quiz.getEenQuizOpdrachtLijst()) {
					 if(!resultOpdrachtCatalogus.opdrachtenLijst.contains(quizOpdracht.getEenOpdracht())){
						 resultOpdrachtCatalogus.voegOpdrachtToe(quizOpdracht.getEenOpdracht());
					}
				}
			}
		}
		
	}
	
	
	
	
	
}
