package functionalProgramming;

import java.util.function.Function;

public class CreateFunction 
{
	public static void main(String[]args) {
		
		/**
		 * Function created to count the number of words in a sentence
		 * The input is the argument you are passing along
		 * The output will be the return value
		 * <T, R> - Input, Output
		 * */
		
		Function<String, Integer> wordCountFunction = new Function<String, Integer>(){
			
			@Override
			public Integer apply(String t)
			{
				//split the sentence into an array by the space (" ")
				//get the length of the array to determine how many words in sentence
				return t.split(" ").length;
			}
		};
		
		Integer count = wordCountFunction.apply("This is a test sentence");
		System.out.println("Word Count Function \n"+count);
		
		/* Function inputs an Integer value, processes the data,
		 * and outputs a String representation of the Integer
		 */
		Function<Integer, String> numToTextFunction = new Function<Integer, String>() {
			
			@Override
			public String apply(Integer t) {
				switch(t) 
				{
					case 0:	return "zero";
					case 1: return "one";
					case 2: return "two";
					case 3: return "three";
					default: return "error";
				}
			}
		};
		
		String result = numToTextFunction.apply(2);
		System.out.println("Number to Text Function \n"+result);
		
		/* Chain the two functions
		 * 
		 * .andThen(Function) method
		 * Input begins with first function used so Function<String, Integer> wordCountFunction must .apply() a String as Input
		 * Output ends with the last function called so Function<Integer, String> numToTextFunction will return a String as Output
		 * Function Chaining simplified: Give the output of previous function as input to the next function
		 * 
		 * .compose(Function) method
		 * Does the same thing in reverse. Starts on the inner function and works its way to outer function
		 */
		String functionChain = wordCountFunction.andThen(numToTextFunction).apply("Testing function chaining");
		
		System.out.println("Chaining both Functions \n"+ functionChain);
	}
}
