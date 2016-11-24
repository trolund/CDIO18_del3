package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.fields.Fieldlist;
import view.Output;



public class JUnitTestFleet {

	@Test
	public void test() {

		//Player p = new Player(balance, name);

		Player bijan = new Player(10000, "Bijan");
		Player kasper = new Player(30000, "Kasper");
		Player helene = new Player(25000, "Helene");
		Fieldlist list = new Fieldlist();

		Output.setcar(18, bijan, list);
		// bijan lander på felt 18
		list.getFields()[18].landOn(bijan);
		// bijan køber feltet

		list.getFields()[18].landOn(kasper);
		assertEquals(6500, bijan.getAccount().getSum());
		assertEquals(29500, kasper.getAccount().getSum());

		// bijan lander herefter på felt 19
		list.getFields()[19].landOn(bijan);
		// og køber endnu en fleet

		list.getFields()[18].landOn(kasper);
		assertEquals(3500, bijan.getAccount().getSum());
		assertEquals(28500, kasper.getAccount().getSum());

	}
}
