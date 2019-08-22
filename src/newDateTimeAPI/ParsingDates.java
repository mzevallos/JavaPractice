package newDateTimeAPI;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class ParsingDates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZonedDateTime zdt = ZonedDateTime.now();
		
		DateTimeFormatter customDTF = DateTimeFormatter.ofPattern("MMMM dd, yyyy HH:mm:ss");
		DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		//format returns a String data type
		String s = customDTF.format(zdt);
		String s2 = dtf.format(zdt);
		
		System.out.println("String Data Type using format() method: " + s);
		System.out.println("String Data Type using format() method: " + s2);
		
		System.out.println();
		
		//parse returns a LocalDateTime data type
		LocalDateTime ldt = LocalDateTime.parse(dtf.format(zdt), dtf);
		LocalDateTime ldt2 = LocalDateTime.parse("2010-01-01T00:00:00", dtf);
		
		System.out.println("LocalDateTime Data Type using parse() method: " +ldt);
		System.out.println("LocalDateTime Data Type using parse() method: " +ldt2);
		
		System.out.println();
		
		/**
		 * NOTE****
		 * when parsing a custom date and time, must use the correct object type as the String supplied
		 * 
		 * DateTimeFormatter pattern1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
		 * DateTimeFormatter pattern2 = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
		 * 
		 * LocalDate onlyDateSupplied = LocalDate.parse("August 01, 1990", pattern1); 
		 * LocalDateTime bothDateTimeSupplied = LocalDateTime.parse("08/01/1990 10:12:01", pattern2)
		 * */
		String timeString = "April 12, 1994 15:12:01"; //hard coded date to fit formatter
		String timeString2 = customDTF.format(zdt); //formatted an existing Object to parse into new Object
		
		LocalDateTime custom1 = LocalDateTime.parse(timeString, customDTF);
		LocalDateTime custom2 = LocalDateTime.parse(timeString2, customDTF);
		
		System.out.println("Hard Coded String for date: "+ custom1);
		System.out.println("Date Retrieved from a previously created object: " + custom2);
		
		System.out.println(custom2.plus(2, ChronoUnit.DAYS));
		
		Duration d = Duration.ofHours(250000);
		System.out.println(custom1.plus(d));
		
		
		
				
	}

}
