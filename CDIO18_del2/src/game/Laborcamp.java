package game;

public class Laborcamp extends Ownable
{
	private int rent;

	public Laborcamp(String name, String description, int price, int rent) 
	{
		super(name, description, price, rent);
	}

	public int landOn(Player p, int no, Output out, Fieldlist list, Dicecup cup)
	{
		int rolledSum;
		int laborCount = 0;
		Laborcamp[] labor = new Laborcamp[3];
		
		always(p, no, out);
		labor[0] = (Laborcamp) list.getFields()[14];
		labor[1] = (Laborcamp) list.getFields()[15];
		labor[2] = (Laborcamp) list.getFields()[no];
		cup.die1.roll();
		cup.die2.roll();
		rolledSum = cup.getSum();
		
		if(labor[2].getOwner() != p)
		{
			if(labor[0].getOwner() == labor[1].getOwner())
			{
				laborCount = 2;
			}
			else
			{
				laborCount = 1;
			}
			
			return rolledSum*100*laborCount;
		}
		else
		{
			return 0;
		}
	}
}