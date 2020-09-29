import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortFlatMap {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,4,7);
		List<Integer> list1 = Arrays.asList(2,5,8);
		List<Integer> list2 = Arrays.asList(3,6,9);
		List<Integer> list3 = new ArrayList<Integer>();
		
		List<Integer> sample = Stream
				.concat(Stream.concat(list.stream(), list1.stream()), list2.stream())
				.collect(Collectors.toList());
		
		System.out.println(sample.stream().sorted().collect(Collectors.toList()));
	}
}
