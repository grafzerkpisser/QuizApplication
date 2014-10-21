package utils.textLezer;
import utils.datum.Datum;
import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;



public class TextLezer {

	public String output;
	public Datum datum;

	public TextLezer() {
		output = "";
	}

	public void leesNaamDatumVanBestand() {
		output = "";
		File file = new File("src/utils/textLezer/File.txt");
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String lijn = scanner.nextLine();
				if (lijn.contains("/")) {
					String[] velden = lijn.split("\t");
					String naam = velden[0];
					String[] datumVeld = velden[1].split("/");
					try {
						Datum d = new Datum(Integer.parseInt(datumVeld[0]),
								Integer.parseInt(datumVeld[1]),
								Integer.parseInt(datumVeld[2]));

						datum = d;
						output += String.format("%s %s %n", naam, datum
								.getDatumInEuropeesFormaat().toString());
					} catch (IllegalArgumentException ex) {
						output += ex.getMessage() + "\n";
					}
				}

				if (lijn.contains("-")) {
					String[] velden = lijn.split("\t");
					String naam = velden[0];
					String[] datumVeld = velden[1].split("-");
					try {
						Datum da = new Datum(Integer.parseInt(datumVeld[0]),
								Integer.parseInt(datumVeld[1]),
								Integer.parseInt(datumVeld[2]));
						datum = da;
						output += String.format("%s %s %n", naam, datum
								.getDatumInEuropeesFormaat().toString());
					} catch (IllegalArgumentException ex) {
						output += ex.getMessage() + "\n";
					}
				}
			}
			if (scanner != null)
				scanner.close();

		} catch (FileNotFoundException ex) {
			System.out.println("bestand niet gevonden");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void leesNaamDatumVanBestandBijlage(File file) {
		output = "";
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNext()) {
				String lijn = scanner.nextLine();
				if (lijn.contains("/")) {
					String[] velden = lijn.split("\t");
					String naam = velden[0];
					String[] datumVeld = velden[1].split("/");
					try {
						Datum d = new Datum(Integer.parseInt(datumVeld[0]),
								Integer.parseInt(datumVeld[1]),
								Integer.parseInt(datumVeld[2]));

						datum = d;
						output += String.format("%s %s %n", naam, datum
								.getDatumInEuropeesFormaat().toString());
					} catch (IllegalArgumentException ex) {
						output += " Foutieve datum!! \n";
					}

				}
				if (lijn.contains("-")) {
					String[] velden = lijn.split("\t");
					String naam = velden[0];
					String[] datumVeld = velden[1].split("-");
					try {
						Datum da = new Datum(Integer.parseInt(datumVeld[0]),
								Integer.parseInt(datumVeld[1]),
								Integer.parseInt(datumVeld[2]));
						datum = da;
						output += String.format("%s %s %n", naam, datum
								.getDatumInEuropeesFormaat().toString());
					} catch (IllegalArgumentException ex) {
						output += " Foutieve datum!! \n";

					}
				}
			}

			if (scanner != null)
				scanner.close();
		} catch (FileNotFoundException ex) {
			System.out.println("bestand niet gevonden");
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {
		try {
			TextLezer textL = new TextLezer();
			textL.leesNaamDatumVanBestand();
			System.out.println(textL.output);
		} catch (Exception ex) {
			System.out.println("Foutmelding: " + ex.getMessage());
		}

	}
}
