package practice1;
import javax.*;
import javax.swing.JOptionPane;

import java.util.*;

public class Object 
{
	public static void main(String[]args)
	{
		Scanner input = new Scanner(System.in);
		input.close();
		
		CreateObject[] objectArray = new CreateObject[5];
		
		int choice = 10;
			do
			{
				try
				{
					choice = Integer.parseInt(JOptionPane.showInputDialog("1: Create person\n"
							+ "2: Change Info\n"
							+ "3: Print People"));
				}
				catch(NumberFormatException e)
				{
					JOptionPane.showMessageDialog(null, "Please enter the corresponding number");
				}
			}while(choice <1 || choice >3);
		
		switch(choice)
		{
		case 1:
			populateObject();
		case 2:
			
		case 3:
			
		default: 
			JOptionPane.showMessageDialog(null, "Nice try, guy.");
			
		}
	}
	
	public static void populateObject()
	{
		try
		{
			CreateObject o = new CreateObject();
		}
		catch(NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Must enter a number for age parameter");
		}
		catch(IllegalArgumentException e)
		{
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
