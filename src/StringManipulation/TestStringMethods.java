package practice1;

import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStringMethods {

	public static void main(String[] args) 
	{	
		//String manipulation using array
		basicStringManipulation();
		
		//Simple email validation using regexpression
		regex();
	}
	
	public static void basicStringManipulation()
	{
		String s1 = "This is just, a test";
		String s2 = "0123456789";
		String s3 = "mzevallos@live.com";
		
		//Does @ come before .com like it's supposed to? true:false
		boolean test1 = (s3.indexOf('@') < s3.indexOf(".com"));
		//Does email contain array of characters ".com"? true:false
		boolean test2 = s3.contains(".com");
		
		//Checking where @ is and determining if the next character is '.' or not for validation
		String s4 = (s3.substring(s3.indexOf('@')+1,s3.indexOf('@')+2));
		
		System.out.println(test1);
		System.out.println(test2);
		
		System.out.println();
		
		//Testing how substring works, includes first input all the way up to, excluding last input
		System.out.println(s3.substring(s3.indexOf('@')));
		System.out.println(s2.substring(0,2));
		System.out.println(s4);
		
		//split into array
		String[] stringArray = s1.split(" ");
		for(String element: stringArray)
		{
			System.out.println(element);
		}
		
		//Capitalize first letter of every word then join array into string
		//NOTE* array will still exist in memory, unchanged. simply creating 
		//		a String from array indexes
		//NOTE* if you use an enhanced for loop, the array reference will be unchanged
		//		so it will still be lower case unless you use standard for loop and change
		//		the actual reference value
		String s5 = "";
		for(String element: stringArray)
		{
				String temp1 = element.substring(0,1).toUpperCase();
				String temp2 = element.substring(1);
				element = temp1 + temp2;
				System.out.println(element);
				s5 += element + " ";
		}
			
		//join an array with enhanced for loop
//		String s5 = "";
//		for(String element: stringArray)
//		{
//			String test = "";
//			s5+= element + " ";
//		}
		System.out.println(s5);
	}
	
	public static void regex()
	{
		String input1 = "mzeva@@email.com";
		String input2 = "mzeva@email.com";
		
		String regex = "[a-zA-Z]+@[a-z]+\\.[a-z]*";
		Pattern p = Pattern.compile(regex);
		
		Matcher m = p.matcher(input1);
		System.out.println("Is " + input1 + " a valid address? : " + m.matches());
		m = p.matcher(input2);
		System.out.println("Is " + input2 + " a valid address? : " + m.matches());
	}

}
