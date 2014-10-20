package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class QuizCatalogus{
	 
	public ArrayList <Quiz> quiznaam =new ArrayList <Quiz>();
	
	public void addQuizToCatalogue (Quiz q){
		quiznaam.add(q); 
	}
	
	public String toString(){
		String result = "";
		for ( Quiz q : quiznaam) 
			result += "Quiz: " + q + "\n";
		return result;
	}
	
	
	
}
