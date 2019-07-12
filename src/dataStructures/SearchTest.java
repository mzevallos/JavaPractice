package dataStructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import collections.Dog;

public class SearchTest {

	public static void main(String[] args) 
	{
		Map<Integer,Dog> map = new HashMap<Integer,Dog>();
		List<Dog> arrList = new ArrayList<Dog>();
		
		for(int i = 0; i < 999999; i++)
		{
			Dog d = new Dog("Name: "+i, 5, 20);
			map.put(Dog.getId(), d);
			arrList.add(d);
		}
		
		//ARRAY SEARCH
		Dog search = new Dog("Name: 999998", 5, 20);
		boolean found = false;
		int position = 0;
		
		for(Dog element: arrList)
		{
			if(search.equals(element))
			{
				position = arrList.indexOf(element);
				found = true;
			}
		}
		
		if(found)
		{
			System.out.println("Found in array at index " + position);
		}
		else
		{
			System.out.println("Not found in array");
		}
		
		//Speed Check
		Long t1 = new Date().getTime();
		arrList.indexOf(search);
		Long t2 = new Date().getTime();
		System.out.println("List search time: " + (t2-t1));
		
		//MAP speed check
		t1 = new Date().getTime();
		map.get(999998); //also works as map.get(search), although you are not search by key
		t2 = new Date().getTime();
		System.out.println("Map search time: " + (t2-t1));

		
		
		//testing - unrelated to speed check above
		Collection<Map.Entry<Integer,Dog>> eSet = map.entrySet();
		Iterator<Map.Entry<Integer,Dog>> it = eSet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<Integer, Dog> e = it.next();
			System.out.println("Key: " + e.getKey() + "    |    Value: " + e.getValue());
			break;
		}
	}

}
