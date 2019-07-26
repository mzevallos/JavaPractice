package interfaces;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import collections.Dog;

/**
 * Create a program using set interface extending from Collection.
 * Usage of Set design to remove duplicates in an array and to validate whether or not a value can be added to the array
 */
public class SetExample 
{
	public static void main(String[]args)
	{
		int counter = 0;
		Dog[] dogArray = new Dog[20];
		
		//Method to create an array
		counter = createArray(dogArray, counter);
		//Method to create a Set
		Set<Dog> s = createSet(dogArray, counter);
		
		/* 
		 * Method to remove duplicates in an array
		 * Pass an array into a set(already done above) then back to the same array after clearing it out
		 * */
		counter = clearArray(dogArray, counter, s);
		System.out.println("\nRemove duplicates in array: Array -> Set -> Array");
		System.out.println("Array without duplicate values");
		System.out.println("Counter: " + counter);
		printArray(dogArray, counter);
		
		/*
		 * Now that we have successfully removed duplicates, I will try adding to the array 
		 * after the fact. I will attempt new input, and validate so duplicates are not allowed
		 * */
		counter = addToArray(dogArray, counter, s);
		System.out.println("\nArray attempting to add duplicate and new values");
		System.out.println("Counter: " + counter);
		printArray(dogArray, counter);
		

	}
	public static int createArray(Dog[] dogArray, int counter)
	{
		Dog d = new Dog("Sparky", 3, 19);
		Dog d1 = new Dog("Max", 2, 15);
		Dog d2 = new Dog("Tiger", 5, 24);
		
		//Creating array with duplicates
		dogArray[0] = d;
		dogArray[1] = d;
		dogArray[2] = d;
		dogArray[3] = d;
		dogArray[4] = d1;
		dogArray[5] = d2;
		counter = 6;
		
		//Method to print Array
		System.out.println("Array with Duplicates");
		printArray(dogArray, counter);
		
		return counter;
	}
	
	public static void printArray(Dog[]dogArray, int counter)
	{
		for(int i = 0; i < counter; i++)
		{
			System.out.println(dogArray[i]);
		}
	}
	
	public static Set<Dog> createSet(Dog[]dogArray, int counter)
	{
		//Note: Sets do not allow duplicate values
		Set<Dog> s = new HashSet<Dog>();
		 for(int i = 0; i < counter; i++)
		 {
			 s.add(dogArray[i]);
		 }
		 
		 //Method to iterate Set
		 System.out.println("\nSet without duplicates");
		 iterate(s);
			
		 return s;
	}
	
	public static void iterate(Set<Dog> s)
	{
		Iterator<Dog> it = s.iterator();
		
		while(it.hasNext())
		{
			Dog temp = it.next();
			System.out.println(temp);
		}
	}
	public static int clearArray(Dog[] dogArray, int counter, Set<Dog> s)
	{
		Arrays.fill(dogArray, null); //clear array
		counter = 0; //clear counter of values in array
		
		Iterator<Dog> it = s.iterator();
		while(it.hasNext())
			{
				Dog temp = it.next();
				dogArray[counter++] = temp;
			}
		
		return counter;
	} 
	
	public static int addToArray(Dog[] dogArray, int counter, Set<Dog> s)
	{
		int temporarySize = s.size();
		boolean valid = false;
		
		Dog d = new Dog("Tiger", 5, 24);
		Dog d1 = new Dog("Dapper", 7, 21);
		Dog d2 = new Dog("Wilhelm", 11, 10);
		
		s.add(d);
		valid = check(temporarySize, s.size());
		if(valid)
		{
			dogArray[counter++] = d;
			temporarySize = s.size();
		}
		s.add(d1);
		valid = check(temporarySize, s.size());
		if(valid)
		{
			dogArray[counter++] = d1;
			temporarySize = s.size();
		}
		s.add(d2);
		valid = check(temporarySize, s.size());
		if(valid)
		{
			dogArray[counter++] = d2;
			temporarySize = s.size();
		}
		return counter;
		
	}
	public static boolean check(int tempSize, int size)
	{
		if(tempSize == size)
		{
			System.out.println("Array cannot contain duplicates");
			return false;
		}
		return true;
	}
}
