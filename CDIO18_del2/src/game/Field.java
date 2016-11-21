package game;

import desktop_resources.GUI;

public class Field 
{
	private String name = "None";
	private String description = "";
	
	public Field(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	public String getName()
	{
		return name;
	}
	
	public String getDescription()
	{
		return description;
	}

	
	public void landOn(Player p, int no){
		always(p,no);
		

	}
	

	public String toString()
	{
		return 	"Name: " + name + "\n" + 
				"Description: " + description;
	}
	
	public void always(Player p, int no){
		Gamecontroller.getOut().setcar(no, p);
		Gamecontroller.getOut().msgGUI(getDescription());
	}
}