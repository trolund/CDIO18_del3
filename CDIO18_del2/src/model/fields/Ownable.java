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
	public void landOn(Player p)
	{
		System.err.println("Ownable");
		boolean wantToBuy = Output.shop(price, p);
		
		if(p.getAccount().getSum()>=price && owner == null && wantToBuy)
		{
			// can buy
			Output.setColor(p.getCarPos(), p);
			setOwner(p);
			
			if(p.getCarPos() == 14 || p.getCarPos() == 15) //Magic numbers!!! Wooo!!! Det skal være færdigt nu :D
			{
				p.setLaborcampCount(p.getLaborcampCount() + 1);
			}
			else if(p.getCarPos() == 18 || p.getCarPos() == 19 || p.getCarPos() == 20 || p.getCarPos() == 21) //Endnu flere! Hvad vil du gøre ved det maaaan
			{
				p.setFleetCount(p.getFleetCount() + 1);
			}
				
			p.getAccount().withdraw(price);
			Output.verificationOfPurchase();
		}
		else if(p.getAccount().getSum() < price && owner == null)
		{
			// cant affort
			Output.deniedPurchase();
		}
		else if(p.getAccount().getSum()>=price && owner == null && !wantToBuy)
		{
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
}