package newDateTimeAPI;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Formatting {
	
	public static void main(String[]args)
	{
		ZonedDateTime now = ZonedDateTime.now();
		
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
		
		String format1 = dateTimeFormatter.format(now);
		System.out.println("Preset formatted String 1: "+format1);
		
		String format2 = DateTimeFormatter.ISO_OFFSET_TIME.format(now);
		System.out.println("Preset formatted String 2: "+format2);
		
		String customFormat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss Z").format(now);
		System.out.println("Custom formatted String 1: "+customFormat1);
		
		dateTimeFormatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy : HH:mm:ss");
		
		String customFormat2 = dateTimeFormatter.format(now);
		System.out.println("Custom formatted String 2: "+customFormat2);
	}

}
