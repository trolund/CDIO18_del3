package game;

/**
 * Team 18 - CDIO 3 
 * DTU
 * Collaborators:  KasperLeiszner, Bijan Negari, Helene Zgaya, Frederik von Scholten and Troels Lund
 */

import desktop_resources.GUI;

public class Gamecontroller {

	private String[] names;
	private Player[] players;
	private Dicecup cup;
	private game.Field[] list = new Fieldlist().getFields();
	private final int maxSum = 3000;
	private final int startSum = 1000;
	private Output out = new Output();
	private static int numberOfPlayers = 0;

	public static void main(String[] args) {
		new Gamecontroller().setup();
	}

	public void setup(){
		addplayers();
		cup = new Dicecup();
		update();
	}

	public void update(){
		for(int i=0; i <= (players.length)-1; i++){
			if(!(players[i].getAccount().getSum() <= 0)){
			turn(players[i]);
			}
			if(i >= players.length-1){
				i = -1;
			}
		}
	}

	private void winner(Player p){
		if(p.getAccount().getSum() >= maxSum){
			out.winnerPrint(p);
			out.oneMoreGame();	
			for(int i=0; i>players.length; i++){
				players[i].getAccount().setSum(1000);
			}
			GUI.close();
		}
	}
	
	public static int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	private void turn(Player p){
		GUI.removeAllCars(p.getName());

		cup.die1.roll();
		cup.die2.roll();

		if(list[cup.getSum()-2].landOn(p, cup.getSum()-1)){
			turn(p);
		}
		winner(p);
	}
	
	private void addplayers(){
		numberOfPlayers = out.howManyPlayers();
		players = new Player[numberOfPlayers];
		names = out.setplayerNames();

		for(int i=0; i < players.length; i++){
			players[i] = new Player(startSum,names[i]);
		}
		for(int i=0; i < players.length; i++){
			GUI.addPlayer(players[i].getName(), players[i].getAccount().getSum());
		}
	}

}




