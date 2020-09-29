import java.io.File;
import java.io.FileFilter;

public class Annonymous{
	public static void main(String[] args) {
		/*
		 * FileFilter filter = new FileFilter() {
		 * 
		 * @Override public boolean accept(File pathname) { return
		 * pathname.getName().endsWith(".java"); } };
		 */
		
		FileFilter filter = (pathname) -> pathname.getName().endsWith(".java");
		
		File file = new File("E:\\eclipse-workspace\\chef\\src\\chef");
		File[] f = file.listFiles(filter);
		
		for (File file2 : f) {
			System.out.println(file2);
		}
	}
}