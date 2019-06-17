package practice1;

public class CreateObject 
{
	//Constants
	public final int EMAIL_SIZE = 5;
	
	//Instance Variables
	private String firstName;
	private String lastName;
	private int age;
	private String[] email;
	private int counter;
	
	//Static Variables
	private static int objCount;
	
	//Constructors
	public CreateObject()
	{
		this("Fred","Jones",0);
	}
	
	public CreateObject(String fName, String lName, int age)
	{
		if(fName == null || fName.contentEquals(""))
		{
			throw new IllegalArgumentException("First Name cannot be blank, what are you doing?!");
		}
		if(lName == null || lName.equals(""))
		{
			throw new IllegalArgumentException("What did I just say? Are you listening?");
		}
		if(age <= 18)
		{
			throw new IllegalArgumentException("You are too young for this service, kid!");
		}
		this.firstName = fName;
		this.lastName = lName;
		this.age = age;
		this.email = new String[EMAIL_SIZE]; 
		this.counter = 0;
		objCount++;
	}
	
	//Accessors
	public String getFirst() {return this.firstName;}
	public String getLast() {return this.lastName;}
	public int getAge() {return this.age;}
	public int getCount() {return this.counter;}
	public static int getObjectCount() {return objCount;}
	public String getEmail(int i)
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
		if(name == null || name.contentEquals(""))
		{
			throw new IllegalArgumentException("How many times do we have to teach you this lesson, Old Man?");
		}
		this.firstName = name;
	}
	public void setLast(String name)
	{
		if(name == null || name.contentEquals(""))
		{
			throw new IllegalArgumentException("We found the patient, Sir. He appears to have forgotten his last name.");
		}
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
		if(!(email.substring(email.length() - 3, email.length()).equalsIgnoreCase(".com")))
		{
			throw new IllegalArgumentException(".com must be at the end");
		}
		
		this.email[counter++] = email;
	}
	
	//Special Purpose
	public String toString()
	{
		String output = "************************************";
		if(objCount == 0)
		{
			output+= "\n\nNo information has been entered yet.\n\n************************************";
		}
		else
		{
			output += "\n\nFirst Name: " + this.getFirst() + "\nLast Name: " + this.getLast() +
					"\nAge: " + this.getAge();
			if(this.counter < 1)
			{
				output += "\nNo emails on file.\n";
			}
			else
			{
				String[] temp = new String[this.counter];
				temp = this.getEmailArray();
				output += "List of emails: \n";
				
				for(int i = 0; i < this.counter; i++)
				{
					output += temp[i] + "\n";
				}
			}
			output += "\n************************************";
		}
		
		return output;
	}
}
