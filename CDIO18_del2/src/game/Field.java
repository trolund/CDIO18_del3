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

	
	public void landOn(Player p, int no, Fieldlist list, Output out){
		always(p,no,out);
	}
	
	public void landOn(Player p, int no, Output out){
		always(p,no,out);
	}
	

	public String toString()
	{
		return 	"Name: " + name + "\n" + 
				"Description: " + description;
	}
	
	public void always(Player p, int no, Output out){
		out.setcar(no, p);
		out.msgGUI(getDescription());
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}