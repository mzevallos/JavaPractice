package collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample 
{
	/**
	 * Collection Interface Methods:
	 *	boolean add(E o)
	 * 	boolean contains (Object o)
	 * 	boolean remove (Object o)
	 * 	boolean isEmpty()
	 * 	int size()
	 * 	Object[] toArray()
	 * 	Iterator<E> iterator()	
	 * */
	
	/**
	 * List: ordered sequence of elements
	 * interface List<E> extends Collection, Iterable
	 * 
	 * List Interface Methods:
	 *	void add(int index, E element)
	 * 	E remove(int index)
	 * 	boolean remove(Object o)
	 * 	E set(int index, E element)
	 * 	E get(int index)
	 * 	int indexOf(Object o)
	 * 	int lastIndexOf(Object o)
	 * 	ListIterator<E> listIterator() 
	 * 	
	 * 	**NOTE** 
	 * 	List Iterator is similar to Iterator, with addition of hasPrevious() and previous() Methods
	 * */
	
	public static void main(String[]args) 
	{
		
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		
		//overloaded add method
		integerList.add(5);
		integerList.add(1);
		integerList.add(-6);
		
		System.out.println("Size of ArrayList: " + integerList.size());
		System.out.println("Random Access of index 2: " + integerList.get(1));
		
		checkItems(integerList);
		
		//adding and removing by specified index
		integerList.add(0, 200);
		integerList.remove(3);
		
		checkItems(integerList);
		
		integerList.clear();
		System.out.println("Cleared array size: " + integerList.size());
		
		//////////////////////////////////////////////////////////////////////////
		
		List<Dog> pet = new ArrayList<Dog>();
		Dog d = new Dog("Sparky", 3, 19);
		Dog d1 = new Dog("Max", 2, 15);
		Dog d2 = new Dog("Tiger", 5, 24);
		
		pet.add(d);
		pet.add(d1);
		pet.add(d2);
		
		System.out.println(pet.get(1));
	}
	public static void checkItems(ArrayList<Integer> integerList)
	{
		for(Integer e: integerList)
		{
			System.out.println("Item "+ (integerList.indexOf(e)+1) + " in List: " + e);
		}
	}
}
