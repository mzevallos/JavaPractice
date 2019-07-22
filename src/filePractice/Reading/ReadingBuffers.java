package filePractice.Reading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadingBuffers {

	public static void main(String[] args) 
	{
		/**
		 * Contents of Created Text File used in program:
		 * 
		 * Name: Mauricio Zevallos
		 * Date of Birth: 08/12/1994
		 * Gender: Male
		 * Race: White
		 * Ethnicity: Hispanic
		 * 
		 * */
		
		readingWithBuffer();
		System.out.println();
		readWithScanner();
	}

	public static void readingWithBuffer() 
	{
		BufferedReader br = null;
		
		try 
		{
			//Shorthand way to write reader: 
			//BufferedReader br = new BufferedReader(new FileReader(new File("pathname")));
			//working with local file person.txt - any information can be displayed from the text file
			File f = new File("C:\\Users\\MZevallos\\Desktop\\person.txt");
			FileReader fr = new FileReader(f);
			br = new BufferedReader(fr);
			long sizeInBytes = f.length();
			
			//Create a string to accept 
			String line = "";
			//Acting buffer without having to create new String instances below
			StringBuilder sb = new StringBuilder();
			
			
			while((line = br.readLine()) != null)
			{
				//Append the immutable String to the StringBuilder, which is mutable
				sb.append(line).append(System.lineSeparator()); //lineSeparator method to keep file structure
			}
			
			sb.append("Size in Bytes: " + sizeInBytes);
			//Create new String with the StingBuilder containing all the lines in the file
			String readFile = sb.toString();
			System.out.println(readFile);
			
			//close resource leak - can throw IOException
			br.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File does not exist");
		} 
		catch (IOException e) 
		{
			System.out.println("File may be corrupted or may have been deleted");
		}
		finally
		{
			try 
			{
				if(br != null)
					br.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public static void readWithScanner()
	{
		Scanner scan = null;
		
		try 
		{
			scan = new Scanner(new FileInputStream(new File("C:\\Users\\MZevallos\\Desktop\\person.txt")));
			
			StringBuilder sb = new StringBuilder();
			int numLines = 0;
			
			while(scan.hasNextLine())
			{
				sb.append(scan.nextLine()).append(System.lineSeparator());
				numLines++;
			}
			
			String readFile = sb.toString();
			System.out.println(readFile + "Total number of lines in file: " + numLines);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File was not found.");
		}
		finally
		{
			if(scan != null)
				scan.close();
		}
		
	}
}
