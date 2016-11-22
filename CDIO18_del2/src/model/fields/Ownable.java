package model.fields;

import model.Player;
import view.Output;

public abstract class Ownable extends Field
{
	protected int price;
	private Player owner;



	public Ownable (String name, String description, int price)
	{
		super(name, description);
		this.price = price;
	}

	@Override
	public void landOn(Player p){
		if(p.getAccount().getSum()>=price && owner == null && Output.shop(price, p))
		{
			// can buy
			setOwner(p);
			p.setLaborcampCount(p.getLaborcampCount());
			p.getAccount().withdraw(price);
			Output.verificationOfPurchase();

		}
		else if(p.getAccount().getSum() < price && owner == null)
		{
			// cant affort
			Output.deniedPurchase();
		}
		else // is owned
		{
			// Pay rent
			p.getAccount().withdraw(getRent(p));
			owner.getAccount().addSum(getRent(p));

		}
	}

	public abstract int getRent(Player p);

	public void setOwner(Player owner) 
	{
		this.owner = owner;
	}	

	public Player getOwner()
	{
		return owner;
	}

	//	public Boolean getIsOwned() {
	//	return isOwned;
	//}


	//public void setIsOwned(Boolean isOwned) {
	//	this.isOwned = isOwned;
	//}

	//	public void LandOn(Player p)
	//	{
	//		if(ownable(p))
	//		{
	//			Gamecontroller.getOut().taxAction(price);	
	//		}
	//	}
}