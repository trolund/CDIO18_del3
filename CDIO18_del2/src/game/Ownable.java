package game;

public class Ownable extends Field
{
	private int price;
	private int rent;
	private Boolean isOwned=false; 
	private Player owner;
	
	public Ownable (String name, String description, int price, int rent)
	{
		super(name, description);
		this.price=price;
		this.rent = rent;
	}

	public Boolean ownable (Player player)
	{
		if(player.getAccount().getSum()>=price && !isOwned)
		{
			return true;
		}
		else
		{
			player.getAccount().withdraw(rent);
			owner.getAccount().addSum(rent);
			return false;
		}
	}
	
	
	
}

