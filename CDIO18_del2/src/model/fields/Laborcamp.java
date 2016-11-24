package model.fields;

import model.Dicecup;
import model.Player;
import view.Language;
import view.Output;

public class Laborcamp extends Ownable
{
	private int baseRent;

	public Laborcamp(String name, String description, int price, int baseRent) 
	{
		super(name, description, price);
		this.baseRent = baseRent;
		
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

				p.setLaborcampCount(p.getLaborcampCount() + 1);
					
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
			int rent = getRent(p);
			p.getAccount().withdraw(rent);
			getOwner().getAccount().addSum(rent);
			Output.payedRent(p, rent);
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
		Dicecup cup = new Dicecup();
		cup.getDie1().roll();
		cup.getDie2().roll();
		int sum = cup.getSum();
		Output.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		return sum * baseRent * p.getLaborcampCount();
	}

}