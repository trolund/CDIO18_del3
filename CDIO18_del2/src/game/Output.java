package game;

import java.awt.Color;

import desktop_fields.Street;
import desktop_resources.GUI;

public class Output 
{
	
	public void winnerPrint(Player p)
	{
		System.out.println(Language.getWinnerText() + " " + p.getName());
		GUI.showMessage(Language.getWinnerText() + " " + p.getName());
	}
	
	public void oneMoreGame()
	{
		System.out.println(Language.getEndText());
		GUI.showMessage(Language.getEndText());
	}
	
	public int howManyPlayers()
	{
		return Integer.parseInt(GUI.getUserSelection(Language.getPlayerCountText(), "2","3","4","5","6")); 
	}
	
	public String[] setplayerNames()
	{		
		String[] names = new String[Gamecontroller.getNumberOfPlayers()];
		
		for(int i = 0; i < names.length; i++)
		{
			names[i] = GUI.getUserString(Language.getNameOfPlayer() + " " + i);
		}
		
		return names; 
	}

	public void turnMsg(int nr, Player p, String s)
	{
		GUI.setCar(nr,p.getName());
		GUI.showMessage(s);
	}
	
	public void drawGameboard(Fieldlist fd)
	{
		game.Field[] logicField = fd.getFields();
		desktop_fields.Field[] guiField = new desktop_fields.Field[logicField.length];

		GUI.create(guiField);

		for (int i = 0; i < logicField.length; i++) 
		{
			guiField[i] = new Street.Builder()
								.setTitle(logicField[i].getName())
								.setRent("" + logicField[i].getValue())
								.build();
			
		}
	}
		
	public boolean taxAction(int price){
		return GUI.getUserLeftButtonPressed("hvad vil du helst?", "Betale " + price , "eller betale 10% af din formue");
	}
	
	public void setGUIDice(int die1 , int die2){
		GUI.setDice(die1,die2);
	}
	
	public void setGUIBalance(Player p){
		GUI.setBalance(p.getName(), p.getAccount().getSum());
	}
	
	public void GUIcreateFields(desktop_fields.Field[] f) {	
		GUI.create(f);
	}
	
	public void setcar(int no, Player p){
		p.moveCarPos(no);
		GUI.setCar(p.getCarPos(),p.getName());
		
	}
	
	public void msgGUI(String s){
	GUI.showMessage(s);
	}
}



