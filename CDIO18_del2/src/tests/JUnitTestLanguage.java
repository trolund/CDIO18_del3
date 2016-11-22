package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import game.Language;

public class JUnitTestLanguage 
{

	@Test
	public void TC01() 
	{
		String exRes = "The winner is";
		String res = Language.getWinnerText();
		
		assertEquals(exRes, res);
	}
	
	@Test
	public void TC02()
	{
		String exRes = "Cold Desert";
		String res = Language.getFieldNames()[3];
		
		assertEquals(exRes, res);
	}

}
