package functionalProgramming;

import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamRange {

	public static void main(String[] args) 
	{
		Stream<String> stringStream = Stream.of("Mike","Matt","Dimitri");
		stringStream.forEach(System.out::println);
		
		IntStream intStream = IntStream.range(10, 20); //creates a stream between a range, excludes last value
		intStream.forEach(i -> System.out.print(i + " "));
		
		System.out.println();
		
		intStream = IntStream.rangeClosed(10, 20).skip(5); //skips first 5 values in stream, includes last value
		intStream.forEach(i -> System.out.print(i + " "));
		
		System.out.println();
		
		//Optional<Integer> if you used the generic type for stream : Stream<Integer>, not IntStream
		intStream = IntStream.rangeClosed(10, 20);
		OptionalInt optional = intStream.max();
		Integer maxInt = optional.getAsInt();
		System.out.println("Max: " + maxInt);
		
		intStream = IntStream.rangeClosed(10, 20);
		System.out.println("Min: " + intStream.min().getAsInt());
		
		intStream = IntStream.rangeClosed(10, 20);
		System.out.println("Average: " + intStream.average().getAsDouble());
		
		intStream = IntStream.rangeClosed(10, 20);
		System.out.println("Sum: " + intStream.sum());
	}

}
