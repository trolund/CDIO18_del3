package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Player;
import game.Fieldlist;
import game.Laborcamp;
import game.Output;
import game.Dicecup;

public class JUnitTestLaborcamp 
{

	@Test
	public void TC01() 
	{
		Player[] p = {new Player(30000, "Kasper"), new Player(30000, "Troels")};
		Fieldlist fdList = new Fieldlist();
		Dicecup cup = new Dicecup();
		Output out = new Output();
		
		out.drawGameboard(fdList);
		out.howManyPlayers();
		out.addplayers(p, 30000);
		
		fdList.getFields()[14].landOn(p[0], 14, fdList, out, cup);
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
		
		out.drawGameboard(fdList);
		out.howManyPlayers();
		out.addplayers(p, 30000);

		
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
