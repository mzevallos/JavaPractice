package functionalProgramming;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class TransformingFunctions {

	public static void main(String[] args) {

		List<String> dates = new ArrayList<String>();
		
		dates.add("01/01/2019");
		dates.add("02/01/2019");
		dates.add("03/01/2019");
		dates.add("04/01/2019");
		dates.add("05/01/2019");
		dates.add("06/01/2019");
		dates.add("07/01/2019");
		
		System.out.println("Convert Strings into Date Objects and print dates that land on a weekend");
		Stream<String> dateStream = dates.stream();
		
		dateStream.map(TransformingFunctions::convertDate)
				  .filter(TransformingFunctions::isWeekend)
				  .forEach(System.out::println);
		
		System.out.println("Convert Strings into Date Objects and print dates that land on a weekday");
		dateStream = dates.stream();
		
		dateStream.map(TransformingFunctions::convertDate)
				  .filter(d -> !TransformingFunctions.isWeekend(d))
				  .forEach(System.out::println);

	}
	
	public static boolean isWeekend(Date d)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		
		//will return true if the day lands on Sunday or Saturday
		return c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || 
			   c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
	}
	
	public static Date convertDate(String d)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sdf.parse(d);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	

}
