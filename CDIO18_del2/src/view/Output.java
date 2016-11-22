package view;

import controller.Gamecontroller;

/*
 * Class wrote by: Troels Lund and Kasper Leiszner
 */

import desktop_fields.Street;
import desktop_resources.GUI;
import model.Player;
import model.fields.Fieldlist;

public class Output 
{
	
	public static void winnerPrint(Player p)
	{
		System.out.println(Language.getWinnerText() + " " + p.getName());
		GUI.showMessage(Language.getWinnerText() + " " + p.getName());
	}
	
	public static void oneMoreGame()
	{
		System.out.println(Language.getEndText());
		GUI.showMessage(Language.getEndText());
	}
	
	public static int howManyPlayers()
	{
		return Integer.parseInt(GUI.getUserSelection(Language.getPlayerCountText(), "2","3","4","5","6")); 
	}
	
	public static void turnMsg(int nr, Player p, String s)
	{
		GUI.setCar(nr,p.getName());
		GUI.showMessage(s);
	}
	
	public static void drawGameboard(Fieldlist fd)
	{
		model.fields.Field[] logicField = fd.getFields();
		desktop_fields.Field[] guiField = new desktop_fields.Field[logicField.length];

		for (int i = 0; i < logicField.length; i++) 
		{
			guiField[i] = new Street.Builder()
								.setTitle(logicField[i].getName())
								.setRent("" + logicField[i].getValue())
								.build();
			
		}
		
		GUI.create(guiField);
	}
		
	public static boolean taxAction(int price){
		return GUI.getUserLeftButtonPressed("hvad vil du helst?", "Betale " + price , "eller betale 10% af din formue");
	}
	
	public static void setGUIDice(int die1 , int die2){
		GUI.setDice(die1,die2);
	}
	
	public static void setGUIBalance(Player p){
		GUI.setBalance(p.getName(), p.getAccount().getSum());
	}
	
	public static void GUIcreateFields(desktop_fields.Field[] f) {	
		GUI.create(f);
	}
	
	public static void setcar(int no, Player p){
		p.moveCarPos(no);
		GUI.setCar(p.getCarPos(),p.getName());
		
	}
	
	public static void msgGUI(String s){
//	GUI.showMessage(s);
	GUI.getUserButtonPressed(s, Language.rollButName());
	}
	
	public static Player[] addplayers(Player[] players, int startSum)
	{
		String name = "";
		players = new Player[Gamecontroller.getNumberOfPlayers()];
		
		for(int i=0; i < players.length; i++)
		{
			name = GUI.getUserString(Language.getNameOfPlayer() + " " + (i+1));
			players[i] = new Player(startSum,name);
		}
		
		for(int i=0; i < players.length; i++)
		{
			GUI.addPlayer(players[i].getName(), players[i].getAccount().getSum());
		}
		
		return players;
	}
	
	public static boolean shop(int price, Player p){
		return GUI.getUserLeftButtonPressed(p.getName() + " Vil du købe feltet for: " + price, "Fortag køb", "Afslå køb");
	}
	
	public static boolean setTestMode(){
		return GUI.getUserLeftButtonPressed(Language.testModeStrings(0),Language.testModeStrings(1),Language.testModeStrings(2));
	}
	
	public static void verificationOfPurchase(){
		GUI.showMessage(Language.purchaseString());
		
	}
	
	public static void deniedPurchase(){
		GUI.showMessage(Language.dpurchaseString());
		
	}
}



