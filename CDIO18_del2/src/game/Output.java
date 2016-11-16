package game;

import desktop_resources.GUI;

public class Output {
	
	public void winnerprint(Player p){
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
	
}
