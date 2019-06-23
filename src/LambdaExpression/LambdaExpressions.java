package practice1;

public class LambdaExpressions 
{
	//functional interface : 1 abstract method
	public interface InterfaceTest1
	{
		//public final instance variable
		int y = 10;
		
		//static method: body required
		static void walk()
		{
			System.out.println("walk");
		};
		//default method: body required
		default void run()
		{
			System.out.println("run");
		}
		//abstract method: no body
		int sprint(int argument1, double argument2, String argument3);
	}
	
	public interface InterfaceTest2
	{
		boolean canFly();
	}
	
	public static void main(String[]args)
	{
		//Testing 1st interface using Lambda
		/**
		 * 	NOTE:
		 *  Lambda parameters must match the same number of parameters in the functional interface
		 *  
		 *  Data types do not have to be referenced, but should remain consistent with what you are
		 *  using it for (e.g. (x,y,z) -> z*2; z is a String in Sprint method and cannot be multiplied by 2)
		 *  
		 *  Return type of Lambda should also remain consistent to the return type of the abstract method
		 *  (e.g. cannot return String or Object when return type of Sprint() is int)	
		 * */
		InterfaceTest1 inf = (int x, double y, String z) -> {return x*2;};
		System.out.println(inf.sprint(15, 2, "Am I doing this right?"));	//output: 30
		
		//Testing 2nd interface using Lambda
		int age = 4; //Variable that determines the answer to the output below
		
		/*
		 * Uses Lambda to check if age requirement is met and will pass argument to flightOrNo method
		 */
		String s = flightOrNo(()-> {if(age >= 5) return true; return false;}, age);

		System.out.println(s); //output: This bird cannot fly. Required Age: 5 Current Age: 4
	}
	
	public static String flightOrNo(InterfaceTest2 inf, int age)
	{
		if(inf.canFly())
			return "This bird can fly.\nRequired Age: 5 \nCurrent Age: " + age;
		return "This bird cannot fly.\nRequired Age: 5 \nCurrent Age: " + age;
	}
}

