package persistentie;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;




import model.opdracht.OpdrachtCatalogus;
import model.opdracht.QuizCatalogus;

public class CsvWriter {
	
	public void SetAllOpdrachten(OpdrachtCatalogus opdrachtCatalogus) throws IOException{
		try(
				OutputStream file = new FileOutputStream("opdrachten.ser");
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);
				){
		
		output.writeObject(opdrachtCatalogus);
		output.flush();
		output.close();
		}
		catch (IOException ex) {
			throw new IOException("Object kan niet weggeschreven worden " + ex);
		}
	}
	public void SetAllQuizen(QuizCatalogus quizCatalogus) throws IOException{
		try(
				OutputStream file = new FileOutputStream("quizen.ser");
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);
				){
		
		output.writeObject(quizCatalogus);
		output.flush();
		output.close();
		}
		catch (IOException ex) {
			throw new IOException("Object kan niet weggeschreven worden " + ex);
		}
	}
}
