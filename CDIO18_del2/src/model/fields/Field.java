package model.fields;

import model.Dicecup;
import model.Player;
import view.Output;

public abstract class Field 
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
	
	public abstract void landOn(Player p);

//	public void landOn(Player p, int no, Fieldlist list, Output out, Dicecup cup){
//		always(p,no,out);
//	}
//	
//	public void landOn(Player p, int no, Fieldlist list, Output out){
//		always(p,no,out);
//	}
//	
//	public void landOn(Player p, int no, Output out){
//		always(p,no,out);
//	}
	

	public String toString()
	{
		return 	"Name: " + name + "\n" + 
				"Description: " + description;
	}
	
//	public void always(Player p, int no, Output out){
//	}

	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}