package filePractice;

import java.io.File;
import java.io.FilenameFilter;

public class RecursiveFileLookup 
{

	public static void main(String[] args) 
	{
		
		File f = new File("C:\\Users\\MZevallos\\eclipse");
		
		recurseDirectory(f);
	}
	public static void recurseDirectory(File f) 
	{
		if(f == null)
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
			for(File e: filesWithFilter)
			{
				System.out.println(e);
			}
			for(File e2: filesWithoutFilter)
			{
				if(e2.isDirectory())
				{
					File tempFile = new File(f.getAbsolutePath() + "\\" + e2.getName());
					recurseDirectory(tempFile);
				}
			}
		}
	}
}

/**
 * CODE OUTPUT FROM METHOD ABOVE
 * 	C:\Users\MZevallos\eclipse\something1.bmp
 *	C:\Users\MZevallos\eclipse\docs\api\java.base\java\io\class-use\something3.bmp
 *	C:\Users\MZevallos\eclipse\java-2019-03\eclipse\configuration\org.eclipse.osgi\173\data\-1721673519\content.jar
 *	C:\Users\MZevallos\eclipse\java-2019-03\eclipse\configuration\org.eclipse.osgi\181\data\listener_1925729951\artifacts.jar
 *	C:\Users\MZevallos\eclipse\java-2019-03\eclipse\configuration\org.eclipse.osgi\181\data\listener_1925729951\content.jar
 *	C:\Users\MZevallos\eclipse\java-2019-03\eclipse\configuration\org.eclipse.osgi\213\0\.cp\lib\java10api.jar
 *	C:\Users\MZevallos\eclipse\java-2019-03\eclipse\configuration\org.eclipse.osgi\224\0\.cp\lib\javaagent-shaded.jar
 *	C:\Users\MZevallos\eclipse\java-2019-03\eclipse\configuration\org.eclipse.osgi\224\0\.cp\lib\launchingsupport.jar
 *	C:\Users\MZevallos\eclipse\java-2019-03\eclipse\plugins\org.eclipse.equinox.launcher_1.5.300.v20190213-1655.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\.settings\something2.bmp
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\181\data\-1721673519\content.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\189\data\listener_1925729951\artifacts.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\189\data\listener_1925729951\content.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\221\0\.cp\lib\java9api.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\232\0\.cp\lib\launchingsupport.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\69\0\.cp\jars\maven-aether-provider-3.1.0.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\69\0\.cp\jars\maven-model-3.1.0.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\69\0\.cp\jars\maven-model-builder-3.1.0.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\69\0\.cp\jars\maven-repository-metadata-3.1.0.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\69\0\.cp\jars\plexus-interpolation-1.16.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\configuration\org.eclipse.osgi\69\0\.cp\jars\plexus-utils-2.1.jar
 *	C:\Users\MZevallos\eclipse\java-oxygen\eclipse\plugins\org.eclipse.equinox.launcher_1.4.0.v20161219-1356.jar
 * */

/**
 * Failed attempts below
 * */

//	public static void recurseDirectory(File f) 
//	{
//		if(f == null)
//		{
//			System.out.println("f was null");
//			return;
//		}
//		if(f.isDirectory())
//		{
//			if(!f.isFile())
//			{
//				try
//				{
//					File[] files = f.listFiles();
//					for(File e: files)
//					{
//						File tempFile = new File(f.getAbsolutePath() + "\\" + e.getName());
//						
//						FilenameFilter fnf = new FilenameFilter() {
//							
//							@Override
//							public boolean accept(File dir, String name) {
//									if(name.endsWith(".bmp"))
//										return true;
//								return false;
//							}
//						};
//						
//						File[] jarFiles = f.listFiles(fnf);
//						for(File ed: jarFiles)
//						{
//							System.out.println(ed.getAbsolutePath());
//						}
//						
//						recurseDirectory(tempFile);
//					}
//				}
//				catch(NullPointerException e)
//				{
//					System.out.println("Something went wrong");
//				}
//			}
//		}
//	}

	
	
	
//				if(e.isFile())
//				{
//					FilenameFilter fnf = new FilenameFilter() {
//						
//						@Override
//						public boolean accept(File dir, String name) {
//								if(name.endsWith(".bmp"))
//									return true;
//							return false;
//						}
//					};
//					File[] bmpFiles = f.listFiles(fnf);
//					for(File e2: bmpFiles)
//					{
//						System.out.println(e2);
//					}
//				}
				//System.out.println(e);
//				File tempFile = new File(f.getAbsolutePath() + "\\" + e.getName());
//				
//				FilenameFilter fnf = new FilenameFilter() {
//					
//					@Override
//					public boolean accept(File dir, String name) {
//							if(name.endsWith(".bmp"))
//								return true;
//						return false;
//					}
//				};
//				
//				File[] jarFiles = f.listFiles(fnf);
//				for(File ed: jarFiles)
//				{
//					System.out.println(ed.getAbsolutePath());
//				}
//				
//				recurseDirectory(tempFile);

