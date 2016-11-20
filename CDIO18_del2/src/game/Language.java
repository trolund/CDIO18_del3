package game;

public class Language 
{
	private static String[] fieldInfo = {
		"Tribe Encampment",
		"Crater",
		"Mountain",
		"Cold Desert",
		"Black cave",
		"The Werewall",
		"South Citadel",
		"Palace gates",
		"Tower",
		"Castle",
		"Walled city",
		"Monastery",
		"Huts in the mountain",
		"The pit",
		"Goldmine",
		"Caravan",
		"Second Sail",
		"Sea Grover",
		"The Buccaneers",
		"Privateer armade"
	};
	
	private static String winnerText = "The winner is";
	private static String endText = "One more game?";
	private static String playerCountText = "How many players?";
	private static String nameOfPlayer = "Name of player";
	
	public static String getPlayerCountText()
	{
		return playerCountText;
	}
	
	public static String getNameOfPlayer()
	{
		return nameOfPlayer;
	}
	
	public static String getEndText()
	{
		return endText;
	}
	
	public static String getWinnerText()
	{
		return winnerText;
	}
	
	public static String[] getFieldNames()
	{
		return fieldInfo;
	}
}