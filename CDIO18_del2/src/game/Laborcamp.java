package game;

public class Laborcamp extends Ownable
{
	private int rent;

	public Laborcamp(String name, String description, int price, int rent) 
	{
		super(name, description, price, rent);
	}


	public int getRent(Player p)
	{
		Dicecup cup = new Dicecup();
		cup.die1.roll();
		cup.die2.roll();
		Gamecontroller.getOut().setGUIDice(cup.die1.getValue(), cup.die2.getValue());
		Field[] fieldlist = Gamecontroller.getList();

		Laborcamp[] laborList = new Laborcamp[2];
		System.arraycopy(fieldlist, 14, laborList, 15, 2);

		if(laborList[1].getOwner().equals(laborList[2].getOwner()))
		{
			return rent * 2 * cup.getSum();
		}
		else if(laborList[1].getOwner().equals(p) || laborList[2].getOwner().equals(p))
		{
			return rent * cup.getSum();
		}
	}

	public void LandOn(Player p)
	{
		if(!(ownable(p))){
			getRent(p);
		}


	}

	public void payRent(Player p)
	{

	}
}