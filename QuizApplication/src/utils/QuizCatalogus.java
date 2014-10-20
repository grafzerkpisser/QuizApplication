package utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class QuizCatalogus implements Iterable <Quiz>{
	private ArrayList <Quiz> quiznaam;
	
	public QuizCatalogus(){
		quiznaam =new ArrayList <Quiz>();
		
	}
	
	/*public void voegQuizToe(String naam, String leerjaar, Boolean test, Boolean uniek, String status){
		Quiz onderwerp = new Quiz(naam, status, uniek, uniek, status);
		quiznaam.add(onderwerp);
	}*/
	
	public String toString() {
		return " Quiz" + quiznaam ;
	}
}
