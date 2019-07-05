package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Iterating {

	public static void main(String[] args) 
	{
		List<Dog> pet = new ArrayList<Dog>();
		
		Dog d = new Dog("Sparky", 3, 19);
		Dog d1 = new Dog("Max", 2, 15);
		Dog d2 = new Dog("Tiger", 5, 24);
		
		pet.add(d);
		pet.add(d1);
		pet.add(d2);
		
		Iterator<Dog> it = pet.iterator();
		
		while(it.hasNext())
		{
			System.out.println("Name: " + it.next().getName());
		}
		
		//reset iterator after it has reached the end
		it = pet.iterator();
		
		//adds previous() and hasPrevious() methods
		ListIterator<Dog> it2 = pet.listIterator();
		System.out.println("**********List Iterator Iteration**********");
		while(it2.hasNext())
		{
			System.out.println("Name: " + it2.next().getName());
		}
		System.out.println("**********List Iterator Reverse Order**********");
		while(it2.hasPrevious())
		{
			System.out.println("Name: " + it2.previous().getName());
		}
	}

}
