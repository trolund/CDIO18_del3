package model.fields;

import model.Player;
import view.Output;

public class Territory extends Ownable
{
	private int rent;

	public Territory(String name, String description, int price, int rent) {
		super(name, description, price);
		this.rent = rent;
	}

	@Override
	public int getRent(Player p) {
		// ignore player
		return rent;
	}

	
	
	
//	public void landOn(Player p, int no, Fieldlist fl, Output out){
//		always(p,no,out);
//		if(ownable(p)){
//			if(out.shop(price,p)){
//				setOwner(p);
//				p.getAccount().withdraw(price);
//			}
//		}
//		else{
//			p.getAccount().withdraw(rent);
//			getOwner().getAccount().addSum(rent);
//		}
//		
//	}
//	
	
	
	}


