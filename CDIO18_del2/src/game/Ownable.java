package game;

public abstract class Ownable extends Field
{
	private int price;
	private int rent;
	private Boolean isOwned = false; 
	private Player owner;



	public Ownable (String name, String description, int price, int rent)
	{
		super(name, description);
		this.price = price;
		this.rent = rent;
	}


	public Player getOwner()
	{
		return owner;
	}


	public Boolean ownable (Player p)
	{
		if(p.getAccount().getSum()>=price && !isOwned)
		{
			return true;
		}
		else if(p.getAccount().getSum() < price && !isOwned)
		{
			return false;
		}
		else
		{
			p.getAccount().withdraw(rent);
			owner.getAccount().addSum(rent);
			return false;
		}
	}	

//	public void LandOn(Player p)
//	{
//		if(ownable(p))
//		{
//			Gamecontroller.getOut().taxAction(price);	
//		}
//	}
}