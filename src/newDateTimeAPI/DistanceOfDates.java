package newDateTimeAPI;

import java.time.Duration;
import java.time.Instant;
import java.time.Period;
import java.util.concurrent.TimeUnit;

public class DistanceOfDates {
	
	public static void main(String[]args)
	{
		Instant now = Instant.now();
		System.out.println("Current Time: " + now);
		
		//add 5 hours
		Instant plusFiveHours = now.plus(Duration.ofHours(5));
		System.out.println("Current Time plus 5 hours: " + plusFiveHours);
		//add 2 days
		Instant plusTwoDays = now.plus(Period.ofDays(2));
		System.out.println("Current Time plus 2 days: "+ plusTwoDays);
		
		Duration datesBetween = Duration.between(plusFiveHours, plusTwoDays);
		System.out.println(datesBetween);
		
		long seconds = datesBetween.getSeconds();
		long days = TimeUnit.SECONDS.toDays(seconds);
		long hours = TimeUnit.SECONDS.toHours(datesBetween.minus(Duration.ofDays(days)).getSeconds());
		
		System.out.println(days + " Day(s), " + hours + " Hours");
	}

}
