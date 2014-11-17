package utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.IllegalStateException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class LeesQuiz {
private static Scanner input;
public static void main(String[]args)
{
openFile();
readRecords();
closeFile();
}
public static void openFile()
{
try	{
input=new Scanner(Paths.get("D:/quiz.txt"));
}
catch(IOException ioException)
{
System.err.println("Kan bestand niet openen");
System.exit(1);
}
}
public static void readRecords()
{
System.out.printf("%-15s%-12s%-12s%-10s%-10s%n","Omschrijving","Leerjaar","Test", "Uniek", "Status");
try
{
while (input.hasNext())
{
System.out.printf("%-15s%-12s%-12s%-10s%-10s%n", input.next(),input.next(),input.next(),input.next(),input.next());
}
}
catch (NoSuchElementException noSuchElementException)
{
System.err.println("Bestaat niet");
//System.exit(1);
}
catch (IllegalStateException illegalStateException )
{
System.err.println("Bestaat niet illegal state");
}
}
public static void closeFile()
{
if (input != null)
input.close();
}
}