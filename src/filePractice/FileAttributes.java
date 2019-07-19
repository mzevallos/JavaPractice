package filePractice;

import java.io.File;
import java.io.FileFilter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class FileAttributes 
{
	public static void main(String[]args)
	{
		File f = new File("C:\\Users\\MZevallos\\Documents");
		
		File[] allFiles = f.listFiles();
		
		//Import user created comparator class to sort based on established rule set
		Arrays.sort(allFiles, new LastModComparator());
		
		for(File e : allFiles)
		{
			if(e.isFile()) 
			{
				System.out.println("***************************************");
				long byteSize = e.length();
				long sizeInKB = byteSize/1024;
				System.out.println("File Name: " + e.getName());
				System.out.println("Size in Bytes: " + byteSize);
				System.out.println("Size in KB: " + sizeInKB);
				
				long lastMod = e.lastModified();
				Date d = new Date(lastMod);
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY hh:mm:ss");
				System.out.println("Last Modified: " + sdf.format(d));
			}
		}
		
		System.out.println();
		System.out.println("All Files Modified This Month: ");
		FileFilter fFilter = new FileFilter() {
			
			@Override
			public boolean accept(File file) {
				Calendar c = Calendar.getInstance();
				c.set(Calendar.MONTH, c.get(Calendar.MONTH)-1);
				
				Date d2 = c.getTime();

				if(file.lastModified() >= d2.getTime())
					return true;
				return false;
			}
		};
		
		File[] allFiles2 = f.listFiles(fFilter);
		for(File e: allFiles2)
		{
			if(e.isFile())
			{
				long lastMod = e.lastModified();
				Date d = new Date(lastMod);
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY hh:mm:ss");
				System.out.println("Last Modified: " + sdf.format(d));
			}
		}
	}
}
