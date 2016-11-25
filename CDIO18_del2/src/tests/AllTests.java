package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ JUnitTestDie.class, JUnitTestFieldlist.class, JUnitTestFleet.class, JUnitTestLaborcamp.class,
		JUnitTestLanguage.class, JUnitTestPlayer.class, JUnitTestRefuge.class, JUnitTestTax.class,
		JUnitTestTerritory.class })
public class AllTests {

}
