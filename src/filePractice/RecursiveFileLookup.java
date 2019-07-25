package filePractice;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecursiveFileLookup
{

	public static void main(String[] args) 
	{
		
		File f = new File("C:\\Users\\MZevallos\\eclipse");
		LinkedHashMap<String, String> m = new LinkedHashMap<String, String>();
		
		recurseDirectory(f, m);
		
		Collection<Map.Entry<String, String>> eSet = m.entrySet();
		
		Iterator<Map.Entry<String,String>> it = eSet.iterator();
		
		while(it.hasNext())
		{
			Map.Entry<String,String> set = it.next();
			System.out.println(set.getKey() + " | " + set.getValue());
		}
	}
	public static void recurseDirectory(File f, Map<String, String> m) 
	{		if(f == null)
		{
			System.out.println("f was null");
			return;
		}
		if(f.isDirectory())
		{
			FilenameFilter fnf = new FilenameFilter() {
				
				@Override
				public boolean accept(File dir, String name) {
						if(name.endsWith(".bmp") || name.endsWith(".jar"))
							return true;
					return false;
				}
			};
			File[] filesWithFilter = f.listFiles(fnf);
			File[] filesWithoutFilter = f.listFiles();
			for(int i = 0; i < filesWithFilter.length; i++)
			{
				m.put("Filter: " + (m.size() + 1), filesWithFilter[i].getAbsolutePath());
			}
			for(File e2: filesWithoutFilter)
			{
				if(e2.isDirectory())
				{
					File tempFile = new File(f.getAbsolutePath() + "\\" + e2.getName());
					recurseDirectory(tempFile, m);
				}
			}
		}
	}
}
