package model.fields;

import model.Dicecup;
import model.Player;
import view.Output;

public class Laborcamp extends Ownable
{
	private int baseRent;

	public Laborcamp(String name, String description, int price, int baseRent) 
	{
		super(name, description, price);
		this.baseRent = baseRent;
		
	}

	@Override
	public int getRent(Player p) {
		Dicecup cup = new Dicecup();
		cup.die1.roll();
		cup.die2.roll();
		int sum = cup.getSum();
		//Output
		return sum * baseRent * p.getLaborCampCount();
	}

//	public int landOn(Player p, int no, Output out, Fieldlist list, Dicecup cup)
//	{
//		int rolledSum;
//		int laborCount = 0;
//		Laborcamp[] labor = new Laborcamp[3];
//		
//		always(p, no, out);
//		labor[0] = (Laborcamp) list.getFields()[14];
//		labor[1] = (Laborcamp) list.getFields()[15];
//		labor[2] = (Laborcamp) list.getFields()[no];
//		cup.die1.roll();
//		cup.die2.roll();
//		rolledSum = cup.getSum();
//		
//		if(labor[2].getOwner() != p)
//		{
//			if(labor[0].getOwner() == labor[1].getOwner())
//			{
//				laborCount = 2;
//			}
//			else
//			{
//				laborCount = 1;
//			}
//			
//			return rolledSum*100*laborCount;
//		}
//		else
//		{
//			return 0;
//		}
//	}
}