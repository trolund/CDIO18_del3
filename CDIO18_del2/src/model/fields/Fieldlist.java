package model.fields;

/**
 * 
 * @author von Scholten
 *
 */

public class  Fieldlist 
{
	//an array of the fieldlist
	private model.fields.Field[] fields = new Field[22];

	//list of fields
	public Fieldlist()
	{
		//Start field
		//Refuge type with no bonus
		fields[0] = new Refuge("Start", "description",0);

		//Territory type fields is ownable with a price and a rent
		fields[1] = new Territory("Tribe Encampment", "description", 1000, 100);
		fields[2] = new Territory("Crater","description", 1500, 300);
		fields[3] = new Territory("mountain", "description", 2000, 500);
		fields[4] = new Territory("Cold Desert", "description", 3000, 700);
		fields[5] = new Territory("Black Cave", "description", 4000, 1000);
		fields[6] = new Territory("The Werewall", "description", 4300,1300);
		fields[7] = new Territory("Mountain village", "description", 4750, 1600);
		fields[8] = new Territory("South Citated", "description", 5000, 2000);
		fields[9] = new Territory("Palace Gates", "description", 5500, 2600);
		fields[10] = new Territory("Tower", "description", 6000, 3200);
		fields[11] = new Territory("Castle", "description", 8000, 4000);
		
		//Refuge type fields is not ownable
		//adds a bonus
		fields[12] = new Refuge("Walled City", "description", 5000);
		fields[13] = new Refuge("Monastery", "description", 500);

		//Laborcamp type fields is ownable with a price and a rent 
		//baseRent multiplied by a dice roll and number of owned fields 
		fields[14] = new Laborcamp("Huts in the mountain", "description", 2500, 100); //100*sumOfDice
		fields[15] = new Laborcamp("The pit","description", 2500, 100); //100*sumOfDice

		//Tax type fields is not ownable
		//withdraw a baseRent or (only [17]) chose to pay 10% of accets
		fields[16] = new Tax("Goldmine","description", 2000,0);
		fields[17] = new Tax("Caravan", "description", 4000, 10);

		//Fleet type fields is ownable with a price and a rent 
		//baseRent multiplied by owned fields 
		fields[18] = new Fleet("Second Sail","description", 4000, 500); // Mellem 500 og 4000 rent
		fields[19] = new Fleet("Sea Grover", "description", 4000, 500);
		fields[20] = new Fleet("The Buccanneers", "description",4000, 500);
		fields[21] = new Fleet("Privateer armade", "description", 4000, 500);
	}

	public model.fields.Field[] getFields()
	{
		return fields;
	}

}