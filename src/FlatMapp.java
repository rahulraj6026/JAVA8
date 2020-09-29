import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class FlatMapp {
	public static void main(String[] args) {
		List<Integer> l = Arrays.asList(1,2,3,5,7,8);
		List<Integer> l1 = Arrays.asList(4,6);
		List<Integer> l2 = Arrays.asList(9);
		
		List<List<Integer>> list = Arrays.asList(l,l1,l2);
		
		Function<List<?>, Integer> size = List::size;
		
		System.out.println("size "+ size);
		
		Function<List<Integer>, Stream<Integer>> flatmapper = li -> li.stream();
		
		//This will return size of each list inside the arraylist
		list.stream()
			.map(size)
			.forEach(System.out::println);
		
		System.out.println("--------------------------------------------- ");
		
		//This will return all the elements in the list.
		list.stream()
			.flatMap(flatmapper)
			.forEach(System.out::println);
		
		
	}
}
