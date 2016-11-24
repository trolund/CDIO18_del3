package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Dicecup;
import model.Player;
import model.fields.Fieldlist;
import model.fields.Laborcamp;
import view.Output;

public class JUnitTestLaborcamp 
{

	@Test
	public void TC01() 
	{
		Player[] p = {new Player(30000, "Kasper"), new Player(30000, "Troels")};
		Fieldlist fdList = new Fieldlist();
		
		Output.drawGameboard(fdList);
		Output.howManyPlayers();
		Output.addplayers(p, 30000);
		
		//You DO NOT buy the field
		fdList.getFields()[14].landOn(p[0]);
		int exRes = 30000;
		int res = p[0].getAccount().getSum();
		
		assertEquals(exRes, res);
	}

	
	
	
	
	
	@Test
	public void TC02() 
	{
		Player[] p = {new Player(30000, "Kasper"), new Player(30000, "Troels")};
		Fieldlist fdList = new Fieldlist();
		
		Output.drawGameboard(fdList);
		Output.howManyPlayers();
		Output.addplayers(p, 30000);
		Output.setcar(1, p[0], fdList);

		//You DO buy the field
		fdList.getFields()[14].landOn(p[0]);
		int exRes = 30000 - 2500;
		int res = p[0].getAccount().getSum();
		
		assertEquals(exRes, res);
	}
	
	
	@Test
	public void TC03() 
	{
		Player[] p = {new Player(30000, "Kasper"), new Player(30000, "Troels")};
		Fieldlist fdList = new Fieldlist();
		Dicecup d=new Dicecup();
		
		Output.drawGameboard(fdList);
		Output.howManyPlayers();
		Output.addplayers(p, 30000);
		Output.setcar(1, p[0], fdList);
		
		d.getDie1().roll();
		d.getDie2().roll();
		
		//You DO buy the field
		fdList.getFields()[14].landOn(p[0]);
		fdList.getFields()[14].landOn(p[1]);

		int exRes = p[1].getAccount().getSum()-(100 * d.getSum());
		int res = p[1].getAccount().getSum();
		
		assertEquals(exRes, res);
	}
}
