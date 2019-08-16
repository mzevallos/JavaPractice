package newDateTimeAPI.oldDateAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) throws ParseException
	{
		//Testing Date Class
		testDate();
		
		formatDate();
		
		calendarMethod();
		
		stringDateCalendarConversions();
	}
	public static void testDate()
	{
		Date d1 = new Date();
		long l = d1.getTime();
		
		int day = d1.getDay();
		
		switch(day)
		{
			case 0:
				System.out.println("Today is Sunday");
				break;
			case 1:
				System.out.println("Today is Monday");
				break;
			case 2:
				System.out.println("Today is Tuesday");
				break;
			case 3:
				System.out.println("Today is Wednesday");
				break;
			case 4:
				System.out.println("Today is Thursday");
				break;
			case 5:
				System.out.println("Today is Friday");
				break;
			default:
				System.out.println("Today is Saturday");
				break;
		}
		
		System.out.println(d1);
		System.out.println(l);
	}
	
	public static void formatDate()
	{
		Date d1 = new Date();
		
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		System.out.println(sdf.format(d1));
	}
	
	public static void calendarMethod()
	{
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		
		int day = c.get(Calendar.DAY_OF_MONTH);
		int month = c.get(Calendar.MONTH);
		
		System.out.println("Today is the "+ day +"th day of the month");
		System.out.println("Today is the "+ (month + 1) + "th month of the year");
		
		//Creates format structure to be used for calendar date
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM, dd yyyy : EEEE");
		//formats todays date
		System.out.println(sdf.format(c.getTime()));
		
		//Check tomorrows date
		c.add(Calendar.DAY_OF_MONTH, 1);
		//formats tomorrows date
		System.out.println(sdf.format(c.getTime()));
		
		//set date
		c.set(Calendar.YEAR, 2021);
		System.out.println(sdf.format(c.getTime()));
		
		//Rollback all changes made
		c = Calendar.getInstance();
		System.out.println(sdf.format(c.getTime()));
	}

	public static void stringDateCalendarConversions() throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		
		//Calendar -> Date -> String
		Calendar c = Calendar.getInstance();
		Date d = c.getTime();
		String s = sdf.format(d);
		System.out.println(s);
		
		//String -> Date -> Calendar
		String date = "08/12/1994";
		Date d1 = sdf.parse(date);
		System.out.println(sdf.format(d1));
		c.setTime(d1);
		System.out.println(sdf.format(c.getTime()));
	}
}
