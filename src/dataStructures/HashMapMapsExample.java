package dataStructures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import collections.Dog;

public class HashMapMapsExample 
{
	
	public static void main (String[]args)
	{
		/**
		 * imports util.Hasmap, util.Map
		 * Creation: Map<K, V> aMap = new HashMap<K, V>();
		 * 
		 * Map Methods:
		 * E.put(key, value) 
		 * E.get()
		 * E.keySet()
		 * E.values()
		 * E.entrySet()
		 * E.remove(key)
		 * E.clear()
		 */
		
		/*
		 * Note: Can specify size of memory block for better performance
		 * 
		 * Map m = new HashMap(1) is slow like an array since everything is stored in the same memory block
		 * and the JVM would need to perform a linear search within the memory block to find a matching key
		 * to what you are looking for
		 * 
		 * Map m = new HashMap(1000) allows for better performance since there are more memory blocks
		 * where the hasCode can store the values into and the values are all spread out
		 */
		Map<String, Dog> m = new HashMap<String, Dog>(); 
		
		Dog d = new Dog("Sparky", 3, 19);
		Dog d1 = new Dog("Max", 2, 15);
		Dog d2 = new Dog("Tiger", 5, 24);
		Dog d3 = new Dog("Dapper", 7, 21);
		Dog d4 = new Dog("Wilhelm", 11, 10);
		
		m.put(d.getName(), d); //The key will be the name, the value will be the object
		m.put(d1.getName(), d1);
		m.put(d2.getName(), d2);
		m.put(d3.getName(), d3);
		m.put(d4.getName(), d4);
		
		Dog aDog = m.get("Dapper");
		
		System.out.println(aDog);
		
		Collection<Dog> collection = m.values();
		Iterator<Dog> it = collection.iterator();
		
		while(it.hasNext())
		{
			System.out.println(it.next().getName());
		}
		
		//Return both the keys and values of a Collection as an entrySet
		Collection<Map.Entry<String, Dog>> entrySet = m.entrySet();
		Iterator<Map.Entry<String, Dog>> entryIt = entrySet.iterator();
		
		System.out.println("\nKey and Value Iteration");
		while(entryIt.hasNext())
		{
			Map.Entry<String, Dog> ent = entryIt.next();
			System.out.println("Key: "+ ent.getKey() + "		Value: " + ent.getValue());
		}
		
		//Return only keys of a Collection
		Collection<String> keyVals = m.keySet();
		Iterator<String> keyIt = keyVals.iterator();
		
		System.out.println("\nKey only Iteration");
		while(keyIt.hasNext())
		{
			String s = keyIt.next();
			System.out.println("Key: " + s);
		}
		
		//Return only values of a Collection
		Collection<Dog> values = m.values();
		Iterator<Dog> valIt = values.iterator();
		
		System.out.println("\nValue only iteration");
		while(valIt.hasNext())
		{
			Dog temp = valIt.next();
			System.out.println("Value: " + temp);
		}
		
		m.remove("Dapper");
		m.clear();
		
	}
}
