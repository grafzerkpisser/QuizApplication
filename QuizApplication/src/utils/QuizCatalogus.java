package utils;
import java.util.ArrayList;
import model.quiz.Quiz;
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