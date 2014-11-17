package trash;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class WriteQuiz {
	private static Formatter output;


	public static void main(String[]args){
		openFile();
		addRecords();
		closeFile();
		}

	public static void openFile()
		{
		try {
			output = new Formatter("d:/quiz.txt");
			}
		
		catch (SecurityException securityException ){
			System.err.println("Geen toegang");
			System.exit(1);
			}
		
		catch(FileNotFoundException fileNotFoundException){
			System.err.println("Bestand niet gevonden");
			System.exit(1);
			}
		
		}

	public static void addRecords()
		{
		Scanner input = new Scanner(System.in);
		System.out.printf("%s%n%s%n?","Naam , leerjaar , Is test , is uniek, status:  ", " Geef einde input aan met ctrl-z"  );
		
		while (input.hasNext())
			{
				try
					{
					output.format("%s%s%s%s%s", input.next(),input.next(),input.next(),input.next(),input.next());  
					}
				
				catch(FormatterClosedException formatterClosedException)
					{
					System.err.println("Fout bij opslaan");
					break;
					}
				
				catch(NoSuchElementException noSuchElementException )
					{
					System.err.println("Foute input");
					break;
					}
				System.out.println("?");
			}
		}

	public static void closeFile()
		{
		if (output != null)
			output.close();
		
		}
}
