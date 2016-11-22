package controller;

/**
 * Team 18 - CDIO 3 
 * DTU
 * Collaborators:  KasperLeiszner, Bijan Negari, Helene Zgaya, Frederik von Scholten and Troels Lund
 *      ___           ___                       ___              
 *     /\  \         /\  \          ___        /\  \             
 *    /::\  \       /::\  \        /\  \      /::\  \            
 *   /:/\:\  \     /:/\:\  \       \:\  \    /:/\:\  \           
 *  /:/  \:\  \   /:/  \:\__\      /::\__\  /:/  \:\  \          
 * /:/__/ \:\__\ /:/__/ \:|__|  __/:/\/__/ /:/__/ \:\__\         
 * \:\  \  \/__/ \:\  \ /:/  / /\/:/  /    \:\  \ /:/  /         
 *  \:\  \        \:\  /:/  /  \::/__/      \:\  /:/  /          
 *   \:\  \        \:\/:/  /    \:\__\       \:\/:/  /           
 *    \:\__\        \::/__/      \/__/        \::/  /            
 *     \/__/         ~~                        \/__/             
 */

/*
 * Class wrote by: Troels Lund and Kasper Leiszner
 */

import desktop_resources.GUI;
import model.Dicecup;
import model.Player;
import model.fields.Fieldlist;
import tests.FakeDicecup;
import view.Output;

public class Gamecontroller 
{

	private Player[] players;
	private Dicecup cup;
	private Fieldlist list = new Fieldlist();
	private final int startSum = 30000;
	private static int numberOfPlayers = 0;
	private boolean testMode = false;

	public static void main(String[] args) 
	{
		new Gamecontroller().setup();
	}

	public void setup()
	{
		Output.drawGameboard(list);
		testMode = Output.setTestMode(); 	// Giver spilleren mulighed for at gå i test mode og tildeler til testMode boolean

		if(testMode){ // Kode der bliver kørt vis programmet er i test mode!
			cup = new FakeDicecup();
		}
		else{
			cup = new Dicecup();
		}
		numberOfPlayers = Output.howManyPlayers();
		players = Output.addplayers(players, startSum);

		for(int i = 0; i < players.length; i++){
			Output.setcar(1,players[i]);
		}

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
				Output.winnerPrint(p);
				GUI.close();
			}
		}

	}

	public static int getNumberOfPlayers() 
	{
		return numberOfPlayers;
	}

	private void turn(Player p){
		GUI.removeAllCars(p.getName());

		cup.getDie1().roll(); 
		cup.getDie2().roll();

		list.getFields()[cup.getSum()-1].landOn(p);

		Output.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		Output.msgGUI(list.getFields()[cup.getSum()-1].getDescription());
		Output.setcar(cup.getSum(), p);

		Output.setGUIBalance(p);
		winner(p);
	}


}

