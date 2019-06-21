package practice1;
import javax.*;
import javax.swing.JOptionPane;

import java.util.*;

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
			do
			{
				try
				{
					choice = Integer.parseInt(JOptionPane.showInputDialog("1: Create person\n"
							+ "2: Change Info\n"
							+ "3: Print People\n"
							+ "4: Exit Program"));
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter the corresponding number");
				}
			}while(choice <1 || choice >4);
		
		switch(choice)
		{
		case 1:
			populateObject(objectArray, MAX_SIZE);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			JOptionPane.showMessageDialog(null, "Until next time, friend.");
			break;
		default:
			System.out.println("what up what up!");
			break;
		}
	}
	
	public static void populateObject(CreateObject[] objectArray, int size)
	{
		do
		{
			try
			{
				objectArray[CreateObject.getObjectCount()] = new CreateObject(JOptionPane.showInputDialog("Enter first name"),
												  JOptionPane.showInputDialog("Enter last name"),
												  Integer.parseInt(JOptionPane.showInputDialog("Enter age")));
			}
			catch(NumberFormatException e)
			{
				JOptionPane.showMessageDialog(null, "Must enter a number for age parameter");
			}
			catch(IllegalArgumentException e)
			{
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}while(JOptionPane.showConfirmDialog(null, "Continue entering in data?","Continue?",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION &&
				CreateObject.getObjectCount()< size);
		if(CreateObject.getObjectCount() == size)
		{
			JOptionPane.showMessageDialog(null, "Limit of array has been reached. \nNo more objects can be created.");
		}
	}
}
