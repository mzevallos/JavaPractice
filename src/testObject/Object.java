package practice1;

import javax.swing.JOptionPane;

public class Object 
{
	public static void main(String[]args)
	{
//		Scanner input = new Scanner(System.in);
//		input.close();
		final int MAX_SIZE = 2;
		CreateObject[] objectArray = new CreateObject[MAX_SIZE];
		/**
		 * TODO:
		 * Add option to change info and print all info already entered.
		 * 
		 * Add functionality to create email when creating a person
		 * 
		 * Down the line try to add an abstract Superclass and force instantiation of a specific
		 * person, whether by Job title, Gender(Male, Female, Apache Attack Helicopter), 
		 * Race(Pixie, Elf, Dwarf), Class(Barbarian, Wizard, Demon Lord)
		 * 
		 * Look into interfaces to see if there is anything worthwhile to implement, consider using Generics
		 * 
		 * Potentially add an Algorithm Efficient sort method
		 * LinkedLists are fun, maybe replace arrays
		 * */
		int choice = -1;
		boolean exit = false;
		do
		{
			do
			{
				try
				{
					choice = Integer.parseInt(JOptionPane.showInputDialog("1: Create person\n"
							+ "2: Change Info\n"
							+ "3: Print People\n"
							+ "4: Exit Program"));
					switch(choice)
					{
					case 1:
						populateObject(objectArray, MAX_SIZE);
						break;
					case 2:
						break;
					case 3:
						printObjects(objectArray, MAX_SIZE);
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "Until next time, friend.");
						exit = true;
						break;
					default:
						System.out.println("what up what up!");
						break;
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter the corresponding number");
				}
			}while(choice <1 || choice >4);
		}while(!exit);
	}
	
	public static void populateObject(CreateObject[] objectArray, int size)
	{
		if(!checkSize(size))
		{
			do
			{
				try
				{
					objectArray[CreateObject.getObjectCount()] = new CreateObject(JOptionPane.showInputDialog("Enter first name"),
													  JOptionPane.showInputDialog("Enter last name"),
													  Integer.parseInt(JOptionPane.showInputDialog("Enter age")));
					
					CreateObject temp = objectArray[CreateObject.getObjectCount()-1];
					
					while(JOptionPane.showConfirmDialog(null, "Enter emails?\nCurrent Count: " + temp.getCount() +"\nMax allowed: " + temp.EMAIL_SIZE,"Emails?",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION &&
							temp.getCount() < temp.EMAIL_SIZE)
					{
						try
						{
							temp.setEmail(JOptionPane.showInputDialog("Enter in an email"));
						}
						catch(IllegalArgumentException e)
						{
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
					}
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Must enter a number for age parameter");
				}
				catch(IllegalArgumentException e)
				{
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}while(JOptionPane.showConfirmDialog(null, "Continue entering in data?\nCurrent Count: " + CreateObject.getObjectCount() +"\nMax allowed: " + size,"Continue?",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION &&
					CreateObject.getObjectCount()< size);
			checkSize(size);
		}
	}
	
	public static boolean checkSize(int size)
	{
		if(CreateObject.getObjectCount() == size)
		{
			JOptionPane.showMessageDialog(null, "Limit of array has been reached. \nNo more objects can be created.");
			return true;
		}
		return false;
	}
	public static void printObjects(CreateObject[] o, int size)
	{
		String output = "";
		if(CreateObject.getObjectCount() == 0)
		{
			output = "************************************\n\nNo information has been entered yet.\n\n************************************";
		}
		else
		{
			output = "************************************\n\n";
			for(int i = 0; i < CreateObject.getObjectCount(); i++)
			{
				output += o[i].toString();
			}
		}
		JOptionPane.showMessageDialog(null, output);
	}
}
