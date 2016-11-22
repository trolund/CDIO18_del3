package game;

public class Territory extends Ownable
{

	public Territory(String name, String description, int price, int rent) {
		super(name, description, price, rent);
	}

	
	public void landOn(Player p, int no, Fieldlist fl, Output out){
		always(p,no,out);
		if(ownable(p)){
			if(out.shop(price,p)){
				setOwner(p);
			}
		}
		else{
			p.getAccount().withdraw(price);
			getOwner().getAccount().addSum(price);
		}
		
	}
	
	
	
	}


