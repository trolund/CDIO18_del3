package game;

import desktop_resources.GUI;

public class Output {
	
	public void winnerPrint(Player p){
		System.out.println("The winner is" + p.getName());
		GUI.showMessage("The winner is" + p.getName());
	}
	
	public void oneMoreGame(){
		System.out.println("One More Game?");
		GUI.showMessage("One More Game?");
	}
	
	public int howManyPlayers(){
		return Integer.parseInt(GUI.getUserSelection("How many players?", "2","3","4","5","6")); 
	}
	
	public String[] setplayerNames(){		
		String[] names = new String[Gamecontroller.getNumberOfPlayers()];
		for(int i = 0; i < names.length; i++){
			names[i] = GUI.getUserString("Name of Player " + i);
		}
		return names; 
	}
	

	public void turnMsg(int nr, Player p, String s){
		GUI.setCar(nr,p.getName());
		GUI.showMessage(s);
		
	}

	
}



