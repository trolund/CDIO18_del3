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

	public void landOn(Player p, int no, Output out)
	{
		always(p,no,out);
		payTax(p);
	}

	public void payTax(Player p)
	{
		if(p.getCarPos() == 17)
		{
			if(out.taxAction(taxAmmount))
			{
				p.getAccount().withdraw(taxAmmount);
			}
			else
			{
				p.getAccount().withdraw( (int) (p.getAccount().getSum() * ((100-taxRate)/100)));
			}

		}
		else
		{
			p.getAccount().withdraw(taxAmmount);
		}
	}
}