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
		Dicecup cup = new Dicecup();
		Output out = new Output();
		
		Output.drawGameboard(fdList);
		Output.howManyPlayers();
		Output.addplayers(p, 30000);
		
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
		Dicecup cup = new Dicecup();
		Output out = new Output();
		
		Output.drawGameboard(fdList);
		Output.howManyPlayers();
		Output.addplayers(p, 30000);

		
		fdList.getFields()[14].landOn(p[0], 14, fdList, out, cup);
		int exRes = 25000;
		int res = p[0].getAccount().getSum();
		
		assertEquals(exRes, res);
		
//		
//		exRes = 28000;
//		res = p[1].getAccount().getSum();
//		
//		assertEquals(exRes, res);
	}
}
