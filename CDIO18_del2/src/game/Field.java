package game;

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
<<<<<<< HEAD
	
	public boolean landOn(Player p, int no){
		GUI.setCar(no,p.getName());
		GUI.showMessage(getDescription());
		p.getAccount().addSum(getValue());
		GUI.setBalance(p.getName(), p.getAccount().getSum());
		return extraTurn;
	}
	
	public String toString() 
=======

	public String toString()
>>>>>>> refs/remotes/origin/Helene
	{
		return 	"Name: " + name + "\n" + 
				"Description: " + description;
	}
}