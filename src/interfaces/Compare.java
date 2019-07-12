package interfaces;

import java.util.Arrays;

public class Compare implements Comparable {

	int id;
	
	public Compare()
	{
		this.id++;
	}
	
	
	public int getId() {return this.id;}
	
	@Override
	public int compareTo(Object o)
	{
		/**
		 * compare Method:
		 * instance2.compare(instance1) = 1 if instance2 is larger
		 * instance2.compare(instance1) = 0 if they are the same
		 * instance2.compare(instance1) = -1 if instance1 is larger
		 * */
		if(this.getId() == ((Compare)o).getId())
			return 0;
		
		if(this.getId() > ((Compare)o).getId())
			return 1;
		
		if(this.getId() < ((Compare)o).getId())
			return -1;
		
		return 0;
	}
	
	public static void main(String[]args)
	{
		Compare c = new Compare();
		Compare c1 = new Compare();
		Compare c2 = new Compare();
		c.id = 59;
		c1.id = 1002;
		c2.id = 3;
		
		Compare[] array = new Compare[3];
		array[0] = c;
		array[1] = c1;
		array[2] = c2;
		
		for(Compare e : array)
		{
			System.out.println("Order: " + e.getId());
		}
		
		System.out.println();
		Arrays.sort(array);
		
		for(Compare e : array)
		{
			System.out.println("Order: " + e.getId());
		}
	}

}
