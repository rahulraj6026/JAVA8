import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionExample {
	public static void main(String[] args) {
		/*Comparator<String> compare = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};*/
		
		Comparator<String> compare = (String o1, String o2) -> {
			return o1.compareTo(o2);
		};
		
		List<String> temp = Arrays.asList("apple", "zoo", "camera", "people");
		Collections.sort(temp, compare);
		
		System.out.println(temp);
	}
}
