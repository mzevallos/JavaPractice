package collections;

public class Dog 
{
	String name;
	int age;
	double topSpeed;
	
	public Dog(String name, int age, double topSpeed) 
	{
		super();
		this.name = name;
		this.age = age;
		this.topSpeed = topSpeed;
	}

	public String getName() {return name;}

	public int getAge() {return age;}

	public double getTopSpeed() {return topSpeed;}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", topSpeed=" + topSpeed + "]";
	}	
}
