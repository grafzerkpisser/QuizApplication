package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class QuizCatalogus implements Iterable <Quiz>{
	 
	public ArrayList <Quiz> quiznaam =new ArrayList <Quiz>();
	
	// nog exceptions opvangen
	
	public void addQuizToCatalogue (Quiz q){
		quiznaam.add(q); 
	}
	
	public void deleteQuizFromCatalogue( Quiz q){
		quiznaam.remove(q);
	}
		
	public String toString(){
		String result = "";
		for ( Quiz q : quiznaam) //for each
			result += "Quiz: " + q + "\n";
		return result;
	}
	
	//override methode
	
}
