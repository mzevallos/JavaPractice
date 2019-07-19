package filePractice;

import java.io.File;
import java.util.Comparator;

public class LastModComparator implements Comparator<File>{

	@Override
	public int compare(File a, File b) {
		if(a.lastModified() > b.lastModified())
			return 1;
		else if(a.lastModified() < b.lastModified())
			return -1;
		else
			return 0;
	}

}
