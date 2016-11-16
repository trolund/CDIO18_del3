package game;

/**
 * Team 18 - CDIO 3 
 * DTU
 * Collaborators:  KasperLeiszner, Bijan Negari, Helene Zgaya, Frederik von Scholten and Troels Lund
 */



import java.awt.Color;

import desktop_codebehind.Car;
import desktop_fields.Field;
import desktop_fields.Street;
import desktop_resources.GUI;

public class Gamecontroller {

	private Player[] players = null;
	private Dicecup cup;
	private game.Field[] list = new Fieldlist().getFields();
	private final int maxSum = 3000;
	private Output out = new Output();
	private int numberOfPlayers = 0;

	public static void main(String[] args) {
		new Gamecontroller().setup();
	}

	public void setup(){
		numberOfPlayers = out.howManyPlayers();
		players = new Player[numberOfPlayers];
		
		for(int i=0; i < players.length; i++){
			players[i] = new Player(0,"player "+ i);
		}
		
		cup = new Dicecup();
		

		//flyttes til Fieldlsit.
//		Field[] fields = new Field[11];
//
//		fields[0] = new Street.Builder().setBgColor(new Color (0,191,255)).setTitle(list[0].getName()).setRent(list[0].getValue() +",-").setDescription(list[0].getDescription()).setSubText("2").build();
//		fields[1] = new Street.Builder().setBgColor(new Color (0,0,0)).setFgColor(new Color (250,250,250)).setTitle(list[1].getName()).setRent(list[1].getValue() +",-").setDescription(list[1].getDescription()).setSubText("3").build();
//		fields[2] = new Street.Builder().setBgColor(new Color (255,140,0)).setTitle(list[2].getName()).setRent(list[2].getValue() +",-").setDescription(list[2].getDescription()).setSubText("4").build();
//		fields[3] = new Street.Builder().setBgColor(new Color (250,250,250)).setTitle(list[3].getName()).setRent(list[3].getValue() +",-").setDescription(list[3].getDescription()).setSubText("5").build();
//		fields[4] = new Street.Builder().setBgColor(new Color (0,0,255)).setFgColor(new Color (250,250,250)).setTitle(list[4].getName()).setRent(list[4].getValue() +",-").setDescription(list[4].getDescription()).setSubText("6").build();
//		fields[5] = new Street.Builder().setBgColor(new Color (255,20,147)).setTitle(list[5].getName()).setRent(list[5].getValue() +",-").setDescription(list[5].getDescription()).setSubText("7").build();
//		fields[6] = new Street.Builder().setBgColor(new Color (0,0,0)).setFgColor(new Color (250,250,250)).setTitle(list[6].getName()).setRent(list[6].getValue() +",-").setDescription(list[6].getDescription()).setSubText("8").build();
//		fields[7] = new Street.Builder().setBgColor(new Color (255,69,0)).setTitle(list[7].getName()).setRent(list[7].getValue() +",-").setDescription(list[7].getDescription()).setSubText("9").build();
//		fields[8] = new Street.Builder().setBgColor(new Color (0)).setFgColor(new Color (250,250,250)).setTitle(list[8].getName()).setRent(list[8].getValue() +",-").setDescription(list[8].getDescription()).setSubText("10").build();
//		fields[9] = new Street.Builder().setBgColor(new Color (0,0,0)).setFgColor(new Color (250,250,250)).setTitle(list[9].getName()).setRent(list[9].getValue() +",-").setDescription(list[9].getDescription()).setSubText("11").build();
//		fields[10] = new Street.Builder().setBgColor(new Color (255,215,0)).setTitle(list[10].getName()).setRent(list[10].getValue() +",-").setDescription(list[10].getDescription()).setSubText("12").build();
//

	//	GUI.create(fields);
 //oprettes i Output klasse
//		Car car1 = new Car.Builder()
//				.typeRacecar()
//				.patternHorizontalDualColor()
//				.primaryColor(Color.RED)
//				.secondaryColor(Color.BLUE)
//				.build();
//
//		Car car2 = new Car.Builder()
//				.typeTractor()
//				.patternHorizontalDualColor()
//				.primaryColor(Color.BLACK)
//				.secondaryColor(Color.RED)
//				.build();

		

		System.out.println("setup done");
		update();
	}

	public void update(){
		System.out.println(players.length);
		for(int i=0; i < players.length; i++){
			
			if(!(players[i].getAccount().getSum() < 0)){
			turn(players[i]);
			}
			
			if(i < players.length){
				i = 0;
			}
		}
	}

	private void winner(Player p){
		if(p.getAccount().getSum() >= maxSum){
			out.winnerprint(p);
			out.oneMoreGame();	
			for(int i=0; i>players.length; i++){
				players[i].getAccount().setSum(1000);
			}
			GUI.close();
		}
	}

	private void turn(Player p){
		System.out.println("en tur bliver spillet af"+ p.getName());
		GUI.removeAllCars(p.getName());

		cup.die1.roll();
		cup.die2.roll();

		System.out.println(cup.die1.getValue());
		System.out.println(cup.die2.getValue());

		GUI.setDice(cup.die1.getValue(), cup.die2.getValue());

		if(list[cup.getSum()-2].landOn(p, cup.getSum()-1)) turn(p);
		
		GUI.setBalance(p.getName(), p.getAccount().getSum());
		System.out.println("værdi" + cup.getSum());
		
		winner(p);
	}

}
