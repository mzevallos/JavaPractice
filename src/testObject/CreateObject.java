package practice1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateObject 
{
	//Constants
	public final int EMAIL_SIZE = 5;
	
	//Instance Variables
	
	/**
	 * TODO:
	 * Strings are immutable and costly on performance. 
	 * Consider using StringBuffer or StringBuilder where applicable
	 * 
	 * Add in Date and Calendar functionality, Objects can be created every day of the week
	 * except Saturdays and Sundays. 
	 * Objects will not longer be able to be instantiated 1 year from
	 * the time the Date and Calendar functionality get added to the program
	 * */
	private String firstName;
	private String lastName;
	private int age;
	private String[] email;
	private int counter;
	private Date dateCreated;
	
	//Static Variables
	private static int objCount;
	
	//Constructors
	public CreateObject()
	{
		this("Fred","Jones",0);
	}
	
	public CreateObject(String fName, String lName, int age)
	{
		validateName(fName);
		validateName(lName);
		if(age < 18)
		{
			throw new IllegalArgumentException("You are too young for this service, kid!");
		}
		
		this.dateCreated = new Date ();
		checkDate();
		
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.email = new String[EMAIL_SIZE]; 
		this.counter = 0;
		objCount++;
	}
	
	//Accessors
	public Date getDateCreated() {return this.dateCreated;}
	public String getFirst() {return this.firstName;}
	public String getLast() {return this.lastName;}
	public int getAge() {return this.age;}
	public int getCount() {return this.counter;}
	public static int getObjectCount() {return objCount;}
	private String getEmail(int i)
	{
		return this.email[i];
	}
	public String[] getEmailArray()
	{
		String[] temp = new String[EMAIL_SIZE];
		
		for(int i = 0; i < this.counter; i++)
		{
			temp[i] = getEmail(i);
		}
		
		return temp;
	}
	//Mutators
	public void setFirst(String name)
	{
		validateName(name);
		this.firstName = name;
	}
	public void setLast(String name)
	{
		validateName(name);
		this.lastName = name;
	}
	public void setAge(int age)
	{
		if(age < 18)
		{
			throw new IllegalArgumentException("Too young to ride this ride.");
		}
		this.age = age;
	}
	public void setEmail(String email)
	{
		/*
		 * EMAIL VALIDATION: can be enhanced and simplified through regex
		 * Dummy exceptions thrown, can be more detailed
		 * */
		if(this.getCount() >= EMAIL_SIZE)
		{
			throw new IllegalArgumentException("Max number of emails reached.");
		}
		if(email == null || email.trim().equals(""))
		{
			throw new IllegalArgumentException("Email cannot be blank, please fix all your mistakes and think about what you've done.");
		}
		else if(email.contains("@"))
		{
			String tempString = email.substring(0,email.indexOf('@'));
			String tempString2 = email.substring(email.indexOf('@')).toLowerCase();
			email = tempString+tempString2;
		}
		else
		{
			throw new IllegalArgumentException("This is all wrong, you get no hints. Figure out what you did wrong yourself.");
		}

		if(email.substring(0,1).equals("@"))
		{
			throw new IllegalArgumentException("Email header cannot be left blank.");
		}
		if(!(email.contains(".com")))
		{
			throw new IllegalArgumentException("Must include Domain Name");
		}
		if(email.indexOf('@') > email.indexOf(".com"))
		{
			throw new IllegalArgumentException("Learn to write a proper email.");
		}
		if(email.substring(email.indexOf('@')+1, email.indexOf('@')+2).contentEquals("."))
		{
			throw new IllegalArgumentException("@ and . cannot be next to each other. Write Domain Identifier");
		}
		if(!(email.substring(email.length() - 4, email.length()).equalsIgnoreCase(".com")))
		{
			throw new IllegalArgumentException(".com must be at the end");
		}
		
		this.email[counter++] = email;
	}
	
	//Special Purpose
	public void validateName(String name)
	{
		if(name == null || name.equals(""))
		{
			throw new IllegalArgumentException("Name is incorrect, Please try again.");
		}
		for(int i = 0; i < name.length(); i++)
		{
			if(!(Character.isLetter(name.charAt(i))))
			{
				throw new IllegalArgumentException("Name can only contain letters. Try again.");
			}
		}
	}
	
	public static String formatDate(Date d)
	{
		SimpleDateFormat f = new SimpleDateFormat("MM/dd/YYYY hh:mm:ss");

		return f.format(d);
		
	}
	public void checkDate()
	{
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 2025);
		c.set(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		
		Date d = c.getTime();
		if(d.getTime() < this.getDateCreated().getTime())
		{
			System.out.println(d.getTime());
			throw new IllegalArgumentException("The time for adding objects has now passed.\n" +
												"Cannot create objects beyond the date: " + this.formatDate(d));
		}
	}
	public String toString()
	{
		String output = "";
		output += "First Name: " + this.getFirst() + "\nLast Name: " + this.getLast() +
					"\nAge: " + this.getAge() + "\nDate Created: " + this.formatDate(this.getDateCreated());
		
		if(this.counter < 1)
		{
			output += "\nNo emails on file.\n";
		}
		else
		{
			String[] temp = new String[this.counter];
			temp = this.getEmailArray();
			output += "\nList of emails: \n";
			
			for(int i = 0; i < this.counter; i++)
			{
				output += temp[i] + "\n";
			}
		}
		output += "\n************************************\n\n";
		
		
		return output;
	}
}
