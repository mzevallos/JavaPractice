package filePractice;

import java.io.File;
import java.io.IOException;

public class CreateFile 
{
	public static void main(String[]args)
	{
		File f = new File("C:\\Users\\MZevallos\\Desktop");

		//3 checks to creating a folder
		System.out.println("Correct path: " + f.exists());
		System.out.println("Is a directory: " + f.isDirectory());	
		System.out.println("Can write: " + f.canWrite());
		
		if(f.exists() && f.isDirectory() && f.canWrite())
		{
			File newFolder = new File("C:\\Users\\MZevallos\\Desktop\\JavaCode");
			if(!newFolder.exists())
				newFolder.mkdir(); //Create a folder in current directory (JavaCode will be created)
			else
				System.out.println("Folder already exists");
			
			//Create File within folder
			File txtFile = new File("C:\\Users\\MZevallos\\Desktop\\JavaCode\\Java.txt");
			try 
			{
				txtFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
