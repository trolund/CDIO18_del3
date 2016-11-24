package model.fields;

import model.Player;
import view.Language;
import view.Output;

public class Territory extends Ownable
{
	private int rent;

	public Territory(String name, String description, int price, int rent) 
	{
		super(name, description, price);
		this.rent = rent;
	}
	@Override
	public void landOn(Player p){
		if(p.getAccount().getSum()>=price && getOwner() == null) // tjekker om player har penge nok til at købe feltet og om det er ledigt.
		{	// can buy
			wantToBuy = Output.shop(price, p); // Spørg spilleren i GUIen om feltet skal købes. 
			
			if(wantToBuy) // hvis playeren sagde ja til købet køres denne kode
			{
				Output.setColor(p);
				setOwner(p);
					
				p.getAccount().withdraw(price);
				Output.verificationOfPurchase();
			}
		}
		else if(p.getAccount().getSum() < price && getOwner() == null)
		{	// cant affort
			Output.deniedPurchase();
			System.out.println("You can't affort");
		}
		else if(p.getAccount().getSum()>=price && getOwner()  == null && !wantToBuy)
		{	//Player don't want to buy
			Output.deniedPurchase();
		}
		else if(getOwner()  != null && getOwner()  != p)// is owned
		{	// Pay rent
			p.getAccount().withdraw(getRent(p));
			getOwner().getAccount().addSum(getRent(p));
			Output.payedRent(p, getRent(p));
		}
		else
		{
			//It's your own field
			Language.ownField();
		}
	}

	@Override
	public int getRent(Player p) 
	{
		// ignore player
		return rent;
	}
}


