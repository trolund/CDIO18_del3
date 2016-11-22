package model.fields;

import java.awt.List;

import model.Player;

public class Fleet extends Ownable
{
private int baseRent;


	public Fleet(String name, String description, int price, int baseRent) 
	{
		super(name, description, price);
		this.baseRent = baseRent;
	}

	
	public int count(){
		int con = 0;
//		Field[] list = Gamecontroller.getList();
		
		
		return con;
	}


	@Override
	public int getRent(Player p) {
		return (int) (baseRent * Math.pow(2, p.getFleetCount()));
	}
}
