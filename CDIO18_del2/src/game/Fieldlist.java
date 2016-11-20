package game;

import java.awt.Color;

import desktop_fields.Street;

public class  Fieldlist 
{
	private Field[] fields = new Field[12];

	public Fieldlist()
	{
		fields[0] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[1] = new Tax("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold",1,1);
		fields[2] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[3] = new Tax("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold",1,1);
		fields[4] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[5] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[6] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[7] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[8] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[9] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[10] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		fields[11] = new Field("Tower", "You have found a mysterious tower and chest lays inside, you've gained 250 gold");
		
	}
	
	public Field[] getFields()
	{
		return fields;
	}

	
}