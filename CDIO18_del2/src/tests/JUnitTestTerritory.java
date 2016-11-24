package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import view.Output;

public class JUnitTestTerritory {

	@Test
	public void test() 
	{
		Player [] p = {new Player(30000,"p1"),new Player(30000,"p2")};
		Fieldlist f = new Fieldlist();
		
		Output.setcar(1, p[0], f);
		int exRe = p[0].getAccount().getSum()-1000;
		f.getFields()[1].landOn(p[0]);

		int Re = p[0].getAccount().getSum();
		assertEquals(exRe,Re);
		
	}

}
