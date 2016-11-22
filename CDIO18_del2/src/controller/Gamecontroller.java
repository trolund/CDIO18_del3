package controller;

/**
 * Team 18 - CDIO 3 
 * DTU
 * Collaborators:  KasperLeiszner, Bijan Negari, Helene Zgaya, Frederik von Scholten and Troels Lund
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
	private boolean gameEnded = false;

	public static void main(String[] args) 
	{
		new Gamecontroller().setup();
	}

	public void setup()
	{
		Output.drawGameboard(list);
		testMode = Output.setTestMode(); 	// Giver spilleren mulighed for at gå i test mode og tildeler til testMode boolean

		if(testMode)
		{ // Kode der bliver kørt vis programmet er i test mode!
			cup = new FakeDicecup();
		}
		else
		{
			cup = new Dicecup();
		}
		
		numberOfPlayers = Output.howManyPlayers();
		players = Output.addplayers(players, startSum);
		
		update();
	}

	public void update()
	{
		while(!gameEnded)
		{
			for(int i=0; i < players.length; i++)
			{
				if(!(players[i].getAccount().getSum() <= 0))
				{
					turn(players[i]);
				}
				else 
				{
					players[i].setBankrupt(true);
				}
				
				winner(players[i]);
			}
		}
	}

	private void winner(Player p)
	{
		int con = 0;
		
		for(int i =0; i < players.length; i++)
		{
			if(players[i].getBankruptStatus())
			{
				con++;
			}
		}
		
		if(con == numberOfPlayers - 1)
		{
			Output.winnerPrint(p);
			GUI.close();
		}
	}

	public static int getNumberOfPlayers() 
	{
		return numberOfPlayers;
	}

	private void turn(Player p)
	{
		cup.getDie1().roll(); 
		cup.getDie2().roll();
		
		Output.setGUIDice(cup.getDie1().getValue(), cup.getDie2().getValue());
		Output.msgGUI(list.getFields()[cup.getSum()].getDescription());
		Output.removeCar(p);
		Output.setcar(cup.getSum(), p);
		
		list.getFields()[cup.getSum()].landOn(p);

		Output.setGUIBalance(p);
		winner(p);
	}
}

