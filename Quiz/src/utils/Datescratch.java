package utils;
import java.util.Date;
import java.io;


public class Datescratch{

	private int dag; //dag
	private int maand; // maand 
	private int jaar; // jaar
	
	private boolean setdatum;
	
	public enum Dagvanweek { Maandag, Dinsdag, Woensdag, Donderdag, Vrijdag, Zaterdag, Zondag};
	
	
	//constructors
	// constructor zonder parameter
	public Datescratch() {
		@SuppressWarnings("deprecation")
		Date systeemdatum = new Date();
		dag = systeemdatum.getDate();
		maand = systeemdatum.getMonth();
		jaar = systeemdatum.getYear();
		
	}
		 
	// constructor met parameter
	public Datescratch( Datescratch vandaag){
	this.dag = vandaag.dag;
	this.maand = vandaag.maand;
	this.jaar = vandaag.jaar;
	}
	
	// constructor met 3 int-parameters
	public Datescratch( int dag, int maand, int jaar)	{
		setDatescratch(dag, maand, jaar);}
		
		
		private void setDatescratch(int dag2, int maand2, int jaar2) {
		// TODO Auto-generated method stub
		
	}

	//String-constructor
	public Datescratch(String datescratch){
		
		if (datescratch.length()!=7)
			throw new IllegalArgumentException("Verkeerde lengte");
		else 
			System.out.println("Controle op geldigheid");
			
			//jaar, maand en dag uit datescratch halen
			String subJaar = datescratch.substring(4,7);
			String subMaand = datescratch.substring(2,3);
			String subDag = datescratch.substring(0,1);
			int berekenJaar;
			int berekenMaand;
			int berekenDag;
			
			
			try	{
				berekenJaar = Integer.parseInt(subJaar);
				if (berekenJaar<0 || berekenJaar> 9999)
				{
					throw new IllegalArgumentException("Ongeldig jaar");
						
				}
				
			}
			
			catch (NumberFormatException ex){
				throw new IllegalArgumentException("Jaar is niet numeriek");
			}
			
			try	{
				berekenMaand = Integer.parseInt(subMaand);
				if (berekenMaand<0 || berekenMaand> 12)
				{
					throw new IllegalArgumentException("Ongeldige maand");
						
				}
				
			}
			
			catch (NumberFormatException ex){
				throw new IllegalArgumentException("Maand is niet numeriek");
			}
			
			try	{
				berekenDag = Integer.parseInt(subDag);
				if (berekenDag<0 || berekenDag> 31)
				{
					throw new IllegalArgumentException("Ongeldige dag");
						
				}
				
			}
			
			catch (NumberFormatException ex){
				throw new IllegalArgumentException("Dag is niet numeriek");
			}
			
			this.dag=berekenDag;
			this.maand=berekenMaand;
			this.jaar=berekenJaar;
			setdatum = true;
			
	}
	
	//setters
	public boolean setDatum ( int dag, int maand, int jaar){
		
		/*this.dag=dag;
		this.maand=maand;
		this.jaar=jaar;*/
		// eerst Datescratch(String datescratch); uitvoeren
		return setdatum;
	}
	
	//getters
	public String getDatumInAmerikaansFormaat (){
		return String.format("%s/%s/%s" , this.jaar, this.maand, this.dag);
	}
	public String getDatumInEuropeesFormaat (){
		return String.format("%s/%s/%s" , this.dag, this.maand, this.jaar);
	}
	
	/*schrikkeljaar
	if (jaar %4) ==0
	{
		if(jaar % 100)==0
		{
			if ( jaar % 400)==0
			{
			schrikkeljaar = true
			}
			schrikkeljaar = false
		}
		
		else schrikkeljaar = true;
		} 
		}
	else schrikkeljaar=False
	*/
	
	//toString
	
	//andere
	
	
	
	
	
	
	
	
	 
	
	
	
}
