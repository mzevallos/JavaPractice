package functionalProgramming;

import java.util.function.Predicate;

public class PredicateClass {

	public static void main(String[] args) {
		
		Predicate<String> sizeOfString = new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				if(t.length() <= 50)
					return true;
				return false;
			}
		};
		Predicate<String> hasWord = new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				if(t.contains("Predicate"))
					return true;
				return false;
			}
		};
		
		//Test Object return Boolean
		System.out.println(sizeOfString.test("This is a Predicate class example"));
		System.out.println(hasWord.test("This is a Predicate class example"));
		
		//.negate() method works as ! .and() works as && .or() works as ||
		//hasWord.negate() will return false instead of true if the String Object contains Predicate
		System.out.println(hasWord.negate().and(sizeOfString).test("Predicate"));
		
		//Remove need for anonymous inner type classes by using Lambda Expressions
		//See package pracitce1.LambdaExpressions for more examples
		Predicate<String> s = t -> t.contains("Predicate"); 
		boolean amv = test1(t -> t.contains("Predicate"));
		System.out.println("Lambda test: " + s.test("something something something lowercase predicate"));
		System.out.println("Lambda through method test: " + amv);
	}

	private static boolean test1(Predicate<String> testing) {
		String t1 = "something something something Predicate";
		if(testing.test(t1) == true)
			return true;
		return false;
		
	}

}
