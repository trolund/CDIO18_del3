package game;

import desktop_resources.GUI;

public class Output {
	
	public void winnerprint(Player p){
		System.out.println("The winner is" + p.getName());
		GUI.showMessage("The winner is" + p.getName());
	}
	
	public void OneMoreGame(){
		System.out.println("One More Game?");
		GUI.showMessage("One More Game?");
	}

}
