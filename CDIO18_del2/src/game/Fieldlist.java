package game;

 public class  Fieldlist 
{
	private game.Field[] fields = new Field[22];

	public Fieldlist()
	{
		fields[0] = new Field("Start", "Klar parat start");
		
		fields[1] = new Territory("Tribe Encampment", "Vil du købe Tribe Encampment", 1000, 100);
		fields[2] = new Territory("Crater","Crater field yo hvad vil du gøre?", 1500, 300);
		fields[3] = new Territory("mountain", "Mountain descr", 2000, 500);
		fields[4] = new Territory("Cold Desert", "Puha det er cold i desert", 3000, 700);
		fields[5] = new Territory("Black Cave", "Black Cave descr", 4000, 1000);
		fields[6] = new Territory("The Werewall", "The Werewall med den fede description", 4300,1300);
		fields[7] = new Territory("Mountain village", "Mountain Village descr", 4750, 1600);
		fields[8] = new Territory("South Citated", "description yo", 5000, 2000);
		fields[9] = new Territory("Palace Gates", "description her yo", 5500, 2600);
		fields[10] = new Territory("Tower", "Descriptiptipt", 6000, 3200);
		fields[11] = new Territory("Castle", "description til Castle bro", 8000, 4000);
		
		
		fields[12] = new Refuge("Walled City", "Walled City bonus 5000 yo", 5000);
		fields[13] = new Refuge("Monastery", "Monastery giver bonus 500 dask bro", 500);
		
		
		fields[14] = new Laborcamp("Huts in the mountain", "description", 2500, 100); //100*sumOfDice
		fields[15] = new Laborcamp("The pit","description", 2500, 100); //100*sumOfDice
		
		
		fields[16] = new Tax("Goldmine","description", 2000,0);
		fields[17] = new Tax("Caravan", "description", 4000, 10); //10 procent of total assets
		
		
		fields[18] = new Fleet("Second Sail","descrip", 4000, 1); // Mellem 500 og 4000 rent
		fields[19] = new Fleet("Sea Grover", "descprtiop", 4000, 1);
		fields[20] = new Fleet("The Buccanneers", "fdescriptoin",4000, 1);
		fields[21] = new Fleet("Privateer armade", "descripterion", 4000, 1);
		
	}
	
	public game.Field[] getFields()
	{
		return fields;
	}
}