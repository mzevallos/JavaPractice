package functionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilters {

	public static void main(String[] args) {
		
		List<DarkSouls> aList = new ArrayList<DarkSouls>();
		
		//DarkSouls(Characters, Deaths, Hours Played, Games of Series Owned)
		aList.add(new DarkSouls(1, 1000, 2, 1));
		aList.add(new DarkSouls(3, 56, 30, 3));
		aList.add(new DarkSouls(2, 31, 120, 4));
		aList.add(new DarkSouls(5, 342, 42, 2));
		aList.add(new DarkSouls(1, 2, 500, 5));
		
		System.out.println("Address References without toString Override");
		Stream<DarkSouls> gameStream = aList.stream();
		gameStream.forEach(System.out::println); //prints out address references since no toString method was overridden
		
		System.out.println("************");
		gameStream = aList.stream();
		gameStream.forEach(t -> System.out.println("Death Count: " + t.getDeathCount()));
		
		//Filter uses a Predicate in Lambda Expression, return value is boolean
		System.out.println("************");
		gameStream = aList.stream();
		gameStream.filter(t -> t.getHoursPlayed() >= 100)
				  .forEach(t -> System.out.println("Hours Played: " + t.getHoursPlayed()));
		
		System.out.println("************");
		System.out.println("List of all Objects with more than 25 hours played, less than 100 deaths, and no less than 4 games owned");
		gameStream = aList.stream();
		gameStream.filter(t -> t.getHoursPlayed() > 25)
			      .filter(t -> t.getDeathCount() < 100)
				  .filter(t -> t.getGameSeriesOwned() >3)
				  .forEach(t -> System.out.println("Player Reference: " + t));
		
	}

}
