package game;

/**
 * Team 18 - CDIO 3 
 * DTU
 * Collaborators:  KasperLeiszner, Bijan Negari, Helene Zgaya, Frederik von Scholten and Troels Lund
 */

/*
 * Class wrote by: Troels Lund and Kasper Leiszner
 */

import desktop_resources.GUI;
import tests.FakeDicecup;

public class Gamecontroller 
{

	//	private String[] names;
	private Player[] players;
	private Dicecup cup;
	private Fieldlist list = new Fieldlist();
	private final int maxSum = 3000;
	private final int startSum = 30000;
	private Output out = new Output();
	private static int numberOfPlayers = 0;
	private boolean testMode = false;

	public static void main(String[] args) 
	{
		new Gamecontroller().setup();
	}

	public void setup()
	{
		out.drawGameboard(list);
		testMode = out.setTestMode(); 	// Giver spilleren mulighed for at gå i test mode og tildeler til testMode boolean
		
		if(testMode){ // Kode der bliver kørt vis programmet er i test mode!
			cup = new FakeDicecup();
		}
		else{
			cup = new Dicecup();
		}
		numberOfPlayers = out.howManyPlayers();
		players = out.addplayers(players, startSum);
		update();
	}

	public void update(){
		for(int i=0; i <= (players.length)-1; i++)
		{
			if(!(players[i].getAccount().getSum() <= 0))
			{ // not that smart.... :)
				turn(players[i]);
			}
			else 
			{
				players[i].setBankrupt(true);
			}

			if(i >= players.length-1)
			{
				i = -1;
			}
		}
	}

	private void winner(Player p){
		for(int i =0; i < players.length; i++){
			int con = 0;
			if(players[i].getBankruptStatus()){
			con++;
			}
			
			if(con-1 == numberOfPlayers){
				out.winnerPrint(p);
				GUI.close();
			}
		}
		
//		if(p.getAccount().getSum() >= maxSum)
//		{
//			out.winnerPrint(p);
//			out.oneMoreGame();	
//
//			for(int i=0; i>players.length; i++)
//			{
//				players[i].getAccount().setSum(1000);
//			}

			
		}

	public static int getNumberOfPlayers() 
	{
		return numberOfPlayers;
	}

	private void turn(Player p){
		GUI.removeAllCars(p.getName());

		cup.die1.roll(); 
		cup.die2.roll();

		out.setGUIDice(cup.die1.getValue(), cup.die2.getValue());

		list.getFields()[cup.getSum()-1].landOn(p, cup.getSum(), list, out);

		out.setGUIBalance(p);
		winner(p);
	}
	
	//	private void addplayers(){
	//		numberOfPlayers = out.howManyPlayers();
	//		players = new Player[numberOfPlayers];
	//		names = out.setplayerNames();
	//
	//		for(int i=0; i < players.length; i++){
	//			players[i] = new Player(startSum,names[i]);
	//		}
	//		for(int i=0; i < players.length; i++){
	//			GUI.addPlayer(players[i].getName(), players[i].getAccount().getSum());
	//		}
	//	}


	public void creatField()
	{
		//	Field[] fields = new Field[11];


	}



}

