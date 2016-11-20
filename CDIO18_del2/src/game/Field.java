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

	
	public void landOn(Player p, int no){
//		GUI.setCar(no,p.getName());
//		GUI.showMessage(getDescription());
//		p.getAccount().addSum(getValue());
//		GUI.setBalance(p.getName(), p.getAccount().getSum());

	}
	

	public String toString()
	{
		return 	"Name: " + name + "\n" + 
				"Description: " + description;
	}
}