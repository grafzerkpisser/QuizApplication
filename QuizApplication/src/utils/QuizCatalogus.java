package utils;

import utils.Quiz;
import model.opdracht.Opdracht;
import model.opdracht.OpdrachtCatalogus;

import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Iterator;
//import java.io.File;
//import java.util.Scanner;


public abstract class QuizCatalogus implements Iterable <Quiz>{
	
	// is hiermee de associatie met Quiz af
	public ArrayList <Quiz> quiznaam =new ArrayList <Quiz>();
	
	// nog exceptions opvangen
	
	public void addQuizToCatalogue (Quiz q){
		//exception: is q wel een quiz? ArrayStoreException
		try {
		quiznaam.add(q);
		}
		catch(ArrayStoreException f){
			System.out.println("Fout formaat");
		}
		
		finally{
			System.out.println("Quiz niet toegevoegd");
		}
		
	}
	
	public void deleteQuizFromCatalogue( Quiz q){
		// enkel te verwijderen indien status in constructie of afgewerkt
		q.getQuizStatus();
		
		quiznaam.remove(q);
	}
		
	public String toString(){
		String result = "";
		for ( Quiz q : quiznaam) //for each
			result += "Quiz: " + q + "\n";
		return result;
	}
	
	public int compareTo (QuizCatalogus QC){
		return QC.compareTo(QC);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((quiznaam == null) ? 0 : quiznaam.hashCode());
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
		QuizCatalogus other = (QuizCatalogus) obj;
		if (quiznaam == null) {
			if (other.quiznaam != null)
				return false;
		} else if (!quiznaam.equals(other.quiznaam))
			return false;
		return true;
	}
	
	
	
	
	
		
	
}