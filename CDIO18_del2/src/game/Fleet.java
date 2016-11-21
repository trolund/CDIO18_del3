package game;

import java.awt.List;

public class Fleet extends Ownable
{
private int rent_1=500;


	public Fleet(String name, String description, int price, int rent) 
	{
		super(name, description, price, rent);
	}

	
	public int count(){
		int con = 0;
		Field[] list = Gamecontroller.getList();
		
		
		return con;
	}
}
