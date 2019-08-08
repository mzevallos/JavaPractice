package functionalProgramming;

public class DarkSouls {

	//instance variables
	private int characters, deathCount, hoursPlayed, gameSeriesOwned;

	//constructor
	public DarkSouls(int characters, int deathCount, int hoursPlayed, int gameSeriesOwned) {
		super();
		this.characters = characters;
		this.deathCount = deathCount;
		this.hoursPlayed = hoursPlayed;
		this.gameSeriesOwned = gameSeriesOwned;
	}

	//accessors
	public int getCharacters() {return this.characters;}
	public int getDeathCount() {return this.deathCount;}
	public int getHoursPlayed() {return this.hoursPlayed;}
	public int getGameSeriesOwned() {return this.gameSeriesOwned;}
	
	
	
}
