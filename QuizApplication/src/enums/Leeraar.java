package enums;

public enum Leeraar {
	Eli(1),
	Patrick(2),
	Gavin(3),
	Brecht(4),
	Bart(5);
	private final int id;
	Leeraar(int id){this.id = id;}
	public int getValue(){return id;}
}
