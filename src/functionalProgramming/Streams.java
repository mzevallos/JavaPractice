package functionalProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Streams {

	public static void main(String[] args) 
	{
		/**
		 * When using streams, you can manipulate them using Intermediate and Terminal operations
		 * Intermediate Operations
		 * Stream Operation:				Goal:								Input:
		 * filter							Filter items to a given predicate	Predicate
		 * map								Process items and transforms		Function
		 * limit							Limit the results					int
		 * sorted							Sort items inside stream			Comparator
		 * distinct							remove duplicates through equals()
		 * 
		 * Terminal Operations
		 * Stream Operation:				Goal:								Input:
		 * forEach							for every item, output something	Consumer
		 * count							counts current items			
		 * collect							reduce stream into desired collection
		 * 
		 * NOTE
		 * after using a terminal operation, you cannot process over the same stream again
		 * */
		
		List<Integer> aList = new ArrayList<Integer>();
		aList.add(1);
		aList.add(2);
		aList.add(3);
		aList.add(4);
		
		//convert collection into a stream of integers
		System.out.println("List Stream:");
		Stream<Integer> listStream = aList.stream();
		listStream.filter(t -> t <=10).forEach(i -> System.out.println(i));
		
		Set<Integer> aSet = new HashSet<Integer>();
		aSet.add(10);
		aSet.add(20);
		aSet.add(30);
		aSet.add(40);
		aSet.add(50);
		aSet.add(60);
		aSet.add(70);
		
		System.out.println("Unsorted Collection Stream: ");
		Stream<Integer> setStream = aSet.stream();
		setStream.forEach(System.out::println);
		
		//Error when processing the same stream again after using terminal operation forEach
		System.out.println("Attempting to process on the same stream: ");
		try {
			setStream.forEach(System.out::println);
		} catch (IllegalStateException e) {
			System.out.println("IllegalStateException: Stream has already been process or closed, create a new stream.");
		}
		
		//to sort stream, either use a sorted collection(LinkedHashSet<E> or TreeSet<E> instead of HashSet<E>
		//optionally use the sorted stream method
		System.out.println("Sorted Collection Stream:");
		setStream = aSet.stream();
		setStream.sorted().forEach(System.out::println);
		
		//use comparator to reverse the order
		System.out.println("Sorted Collection in reverse:");
		setStream = aSet.stream();
		setStream.sorted((first, second) -> second - first).forEach(System.out::println);
		
		//testing stream function using set
		Stream<Integer> testList = aList.stream();
		Optional<Integer> optional = testList.max((f,s) -> f-s);
		Integer maxInt = optional.get();
		System.out.println("Largest Value in Set: "+ maxInt);
	}

}
