package enums;

public enum OpdrachtCategorie {
	Rekenen(1),
	NederlandseTaal(2),
	FranseTaal(3),
	AlgemeneKennis(4);
	private final int id;
	OpdrachtCategorie(int id){this.id = id;}
	public int getValue(){return id;}
}
