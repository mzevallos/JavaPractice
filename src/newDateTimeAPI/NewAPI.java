package newDateTimeAPI;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class NewAPI 
{
	/**
	 * New Date and Time API provides easier:
	 * - Timezone Management
	 * - Date and Time arithmetic
	 * - fluency and chaining now possible
	 * - now thread safe due to immutability
	 * */
	
	public static void main(String[]args)
	{
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);// yyyy-mm-dd
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime); // hr:mm:ss.ms
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime); //left side same as localDate output, a T to separate, right side same as localTime output
		
		//add two months from todays date
		LocalDate twoMonthsLater = localDate.plusMonths(2);
		System.out.println(twoMonthsLater);
		
		//add three months and subtract 15 days
		LocalDate chainDates = twoMonthsLater.plusMonths(3).minusDays(15);
		System.out.println(chainDates);
		
		//get month returns Month Object
		Month month = chainDates.getMonth();
		System.out.println(month);
		
		//get day of the week returns day of week enum
		DayOfWeek dayOfWeek = chainDates.getDayOfWeek();
		String stringManipulation = String.valueOf(dayOfWeek);
		System.out.println(stringManipulation.toLowerCase());
		
		LocalDateTime startOfToday = localDate.atStartOfDay();
		System.out.println(startOfToday);
		
		//with method in lieu of the set method from previous API
		LocalDate dateToCheck = localDate.withDayOfMonth(12).withMonth(5).withYear(2010);
		//comparison check if a current date has passed date supplied
		boolean isAfter = localDate.isAfter(dateToCheck);
		if(isAfter)
		{
			System.out.println("You are too late. The current date of "+ localDate +" has passed the date "+ dateToCheck);
		}
		else
		{
			System.out.println("Don't worry, you're not late. Yet.");
		}
		
	}
}
