package game;

public class Territory extends Ownable
{

	public Territory(String name, String description, int price, int rent) {
		super(name, description, price, rent);
	}

	
	public void LandOn(Player p, int no, Fieldlist fl, Output out){
		
		if(ownable(p)){
			if(out.shop(price)){
				setOwner(p);
			}
		}
		else{
			p.getAccount().withdraw(price);
			getOwner().getAccount().addSum(price);
		}
		always(p,no,out);
	}
	
	
	
	}


