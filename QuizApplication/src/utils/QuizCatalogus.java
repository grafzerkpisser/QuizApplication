
package utils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import model.quiz.Quiz;
/*<<<<<<< HEAD
=======*/
public abstract class QuizCatalogus implements Iterable <Quiz>{
	//temp
	// is hiermee de associatie met Quiz af
	public static ArrayList <Quiz> quiznaam =new ArrayList <Quiz>();
	
	// nog exceptions opvangen
	
	public static void addQuizToCatalogue (Quiz q){
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
	
	public static void deleteQuizFromCatalogue( Quiz q){
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
//>>>>>>> refs/remotes/origin/master

@SuppressWarnings("serial")
public class QuizCatalogus implements Iterable<QuizCatalogus>,
Comparable<QuizCatalogus>, Cloneable, Serializable {
	
	public ArrayList<Quiz> quizLijst;
	public QuizCatalogus() {
		quizLijst = new ArrayList<Quiz>();
	}
	public void voegQuizToe(Quiz q) {
		quizLijst.add(q);
	}
	
	public void verwijderQuiz(Quiz q) throws Exception {
		if (q.getEenQuizOpdrachtLijst().size() > 0)
			throw new Exception(
					"Quiz kan niet verwijderd worden wanneer er reeds opdrachten zijn aan toegevoegd");
		else
			quizLijst.remove(q);
	}
	
	@Override
	public QuizCatalogus clone() throws CloneNotSupportedException {

		QuizCatalogus q_c = new QuizCatalogus();
		q_c.quizLijst = this.quizLijst;
		return q_c;
	}
	
	@Override
	public String toString() {
		String quizen = "";
		for (Quiz q : quizLijst) {
			quizen += q.toString() + "/n";
		}
		return quizen;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((quizLijst == null) ? 0 : quizLijst.hashCode());
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
		if (quizLijst == null) {
			if (other.quizLijst != null)
				return false;
		} else if (!quizLijst.equals(other.quizLijst))
			return false;
		return true;
	}
<<<<<<< HEAD
	@Override
	public int compareTo(QuizCatalogus q) {
		return q.compareTo(this);
	}

	@Override
	public Iterator<QuizCatalogus> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
=======
}
>>>>>>> refs/remotes/origin/master
