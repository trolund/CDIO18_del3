package model.fields;

import model.Player;
import view.Language;
import view.Output;

public abstract class Ownable extends Field // Ownable klassen nearver for Field klassen, og er "abstract" hvilket betyder der ikke kan lave instandser af Ownable.  
{
	protected int price;
	private Player owner;
	boolean wantToBuy;

	public Ownable (String name, String description, int price) // Kontruktør 
	{
		super(name, description); // kald til superklassens konstruktør
		this.price = price; // sætter atribut price
	}


//		System.out.println(p.getName() + " has landed on ownable field");
//		
//		if(p.getAccount().getSum()>=price && owner == null) // tjekker om player har penge nok til at købe feltet og om det er ledigt.
//		{
//			// can buy
//			wantToBuy = Output.shop(price, p); // Spørg spilleren i GUIen om feltet skal købes. 
//			
//			if(wantToBuy) // hvis playeren sagde ja til købet køres denne kode
//			{
//				Output.setColor(p);
//				setOwner(p);
//
//				if(p.getCarPos() == 14 || p.getCarPos() == 15) //Magic numbers!!! Wooo!!! Det skal være færdigt nu :D
//				{
//					p.setLaborcampCount(p.getLaborcampCount() + 1);
//				}
//				else if(p.getCarPos() == 18 || p.getCarPos() == 19 || p.getCarPos() == 20 || p.getCarPos() == 21) //Endnu flere! Hvad vil du gøre ved det maaaan
//				{
//					p.setFleetCount(p.getFleetCount() + 1);
//				}
//					
//				p.getAccount().withdraw(price);
//				Output.verificationOfPurchase();
//				
//			}
//		}
//		else if(p.getAccount().getSum() < price && owner == null)
//		{
//			// cant affort
//			Output.deniedPurchase();
//			System.out.println("You can't affort");
//		}
//		else if(p.getAccount().getSum()>=price && owner == null && !wantToBuy)
//		{
//			//Player don't want to buy
//			Output.deniedPurchase();
//		}
//		else if(owner != null && owner != p)// is owned
//		{
//			// Pay rent
//			p.getAccount().withdraw(getRent(p));
//			owner.getAccount().addSum(getRent(p));
//			Output.payedRent(p, getRent(p));
//		}
//		else
//		{
//			//It's your own field
//			Language.ownField();
//		}
	

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