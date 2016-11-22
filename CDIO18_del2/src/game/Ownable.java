package game;

public abstract class Ownable extends Field
{
	protected int price;
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
	
	public void landOn(Player p, int no, Output out){
		always(p,no,out);
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


	public Boolean getIsOwned() {
		return isOwned;
	}


	public void setIsOwned(Boolean isOwned) {
		this.isOwned = isOwned;
	}


	public void setOwner(Player owner) {
		this.owner = owner;
		this.isOwned = true;
	}	

//	public void LandOn(Player p)
//	{
//		if(ownable(p))
//		{
//			Gamecontroller.getOut().taxAction(price);	
//		}
//	}
}