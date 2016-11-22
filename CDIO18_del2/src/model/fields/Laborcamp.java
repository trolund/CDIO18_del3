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
	public int getRent(Player p) 
	{
		Dicecup cup = new Dicecup();
		cup.getDie1().roll();
		cup.getDie2().roll();
		int sum = cup.getSum();
		Output.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		return sum * baseRent * p.getLaborcampCount();
	}

}