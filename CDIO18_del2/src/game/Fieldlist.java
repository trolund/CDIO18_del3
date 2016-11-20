package game;

 public class  Fieldlist 
{
	private Field[] fields = new Field[21];

	public Fieldlist()
	{
		fields[0] = new Territory("Tribe Encampment", "Vil du købe Tribe Encampment", 1000, 100);
		fields[1] = new Territory("Crater","Crater field yo hvad vil du gøre?", 1500, 300);
		fields[2] = new Territory("mountain", "Mountain descr", 2000, 500);
		fields[3] = new Territory("Cold Desert", "Puha det er cold i desert", 3000, 700);
		fields[4] = new Territory("Black Cave", "Black Cave descr", 4000, 1000);
		fields[5] = new Territory("The Werewall", "The Werewall med den fede description", 4300,1300);
		fields[6] = new Territory("Mountain village", "Mountain Village descr", 4750, 1600);
		fields[7] = new Territory("South Citated", "description yo", 5000, 2000);
		fields[8] = new Territory("Palace Gates", "Baaah", 5500, 2600);
		fields[9] = new Territory("Tower", "Descriptiptipt", 6000, 3200);
		fields[10] = new Territory("Castle", "description til Castle bro", 8000, 4000);
		
		fields[11] = new Refuge("Walled City", "Walled City bonus 5000 yo", 5000);
		fields[12] = new Refuge("Monastery", "Monastery giver bonus 500 dask bro" 500);
		
		fields[13] = new LaborCamp("Huts in the mountain", "description", 2500, 100*sumOfDice);
		fields[14] = new LaborCamp("The pit","description", 2500, 100*sumOfDice);
		
		fields[15] = new Tax("Goldmine","description", 2000);
		fields[16] = new Tax("Caravan", "description", 4000, 10% of-total-assets);
		
		fields[17] = new Fleet("Second Sail","descrip", 4000, rent);
		fields[18] = new Fleet("Sea Grover", "descprtiop", 4000, rent);
		fields[19] = new Fleet("The Buccanneers", "fdescriptoin",4000, rent);
		fields[20] = new Fleet("Privateer armade", "descripterion", 4000, rent);
	}
	
	public Field[] getFields()
	{
		return fields;
	}
}