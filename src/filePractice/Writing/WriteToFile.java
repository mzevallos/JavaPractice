package filePractice.Writing;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class WriteToFile {

	/**
	 * Demonstration of PrintWriter writing to a file
	 * Appending to a file
	 * */
	public static void main(String[]args)
	{
		//Create either a String as a path or File to pass as method argument
		File f = new File("C:\\Users\\MZevallos\\Desktop\\info.txt");
		writeFile(f);
		appendToFile(f);
	}
	
	public static void writeFile(File f)
	{
		//initialize PrintWriter in order to flush and close after exception handling
		PrintWriter pw = null;
		
		try
		{
			//attempt to create file if the path exists
			pw = new PrintWriter(new FileOutputStream(f));
			pw.write("This is line 1");
			pw.write(System.lineSeparator());
			pw.write("This is line 2");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem processing request encountered.");
		}
		finally
		{
			//if there was an error processing above data but the stream
			//was never closed, finally block will flush and close if stream is open
			if(pw != null)
			{
				pw.flush();
				pw.close();
			}
		}
	}
	
	public static void appendToFile(File f)
	{
		PrintWriter pw = null;
		try
		{
			//overriding Constructor with boolean to append rather than create over existing file
			pw = new PrintWriter(new FileOutputStream(f,true));
			pw.write("\nThis line has been added to a previously written text file");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Problem processing request encountered.");
		}
		finally
		{
			if(pw != null)
			{
				pw.flush();
				pw.close();
			}
		}
	}
	
}
