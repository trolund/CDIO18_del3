package game;

/**
 * 
 * @author von Scholten
 *
 */

public class Tax extends Field {

	private int taxAmmount;
	private int taxRate;
	private Output out = new Output();

	public Tax(String name, String description, int taxAmmount, int taxRate) 
	{
		super(name, description);
		this.taxAmmount = taxAmmount;
		this.taxRate = taxRate;
	}

	public void LandOnField(Player p)
	{
		payTax(p);
	}
	
	public void payTax(Player p)
	{
		
		if(out.taxAction(taxAmmount))
		{
			p.getAccount().withdraw(taxAmmount);
		}
		else
		{
				p.getAccount().withdraw((int) (p.getAccount().getSum() * (taxRate/100)));
		}
	}
	
	
	
	
}
