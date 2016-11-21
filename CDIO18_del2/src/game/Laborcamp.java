package game;

public class Laborcamp extends Ownable
{
	private int rent;

	public Laborcamp(String name, String description, int price, int rent) 
	{
		super(name, description, price, rent);
	}

	
	public int getRent()
	{
		Dicecup cup = new Dicecup();
		return rent * cup.getSum();
	}

	public void LandOn(Player p)
	{
		ownable(p);
		
	}

	public void payRent(Player p)
	{

	}
}