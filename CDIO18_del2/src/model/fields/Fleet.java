package model.fields;

import model.Player;

public class Fleet extends Ownable
{
private int baseRent;


	public Fleet(String name, String description, int price, int baseRent) 
	{
		super(name, description, price);
		this.baseRent = baseRent;
	}

	@Override
	public int getRent(Player p) {
		return (int) (baseRent * Math.pow(2, p.getFleetCount()));
	}
}
