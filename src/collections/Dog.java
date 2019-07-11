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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(topSpeed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(topSpeed) != Double.doubleToLongBits(other.topSpeed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + ", topSpeed=" + topSpeed + "]";
	}	
}
