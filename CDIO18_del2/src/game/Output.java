package game;

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
}



