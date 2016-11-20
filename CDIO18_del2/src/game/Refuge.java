package game;

/**
 * 
 * @author von Scholten
 *
 */

public class Refuge extends Field
{
	private int bonus;

	public Refuge(String name, String description, int bonus) {
		super(name, description);
		this.bonus = bonus;
	}


	public int LandOnField()
	{	
		return bonus;	
	}
}
