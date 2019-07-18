package filePractice;

import java.io.File;
import java.io.FilenameFilter;

public class ListingFilesAndDirectories 
{
	public static void main(String[]args)
	{
		File f = new File("C:\\Users");
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
		System.out.println("Entire list of items in directory:");
		String[] items = f.list();
		for(String element : items)
		{
			count1++;
			System.out.println(element);
		}
		
		System.out.println("\nList of all path names in a directory:");
		File[] allFiles = f.listFiles();
		for(File element: allFiles)
		{
			count2++;
			System.out.println(element);
		}
		
		System.out.println("\nAll folders in a directory");
		for(File element: allFiles)
		{
			if(element.isDirectory()) // if(!element.isDirectory()) will return all files instead of folders
			{
				count3++;
				System.out.println(element);
			}
		}
		System.out.println("Count 1: " + count1 + "\nCount 2: " + count2+ "\nCount 3: " + count3);
				
		System.out.println("\nSearching for a specific extension:");
		FilenameFilter fnf = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				if(name.endsWith(".docx"))
					return true;
				return false;
			}
		};
		
		File[] docxFiles = f.listFiles(fnf);
		System.out.println("All docx extension files within current directory:");
		for(File e: docxFiles)
		{
			System.out.println(e);
		}
	}
}
