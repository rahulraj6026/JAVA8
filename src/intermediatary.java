import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class intermediatary {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("one", "tenths", "hundreds","thousands");
		Stream<String> stream1 = Stream.of("one", "tenths", "hundreds","thousands");
		
		Predicate<String> p1 = s -> s.length() > 1;
		
		List<String> str = new ArrayList<String>();
		
		//intermediatary operation as peek, filter has return type
		stream
				.peek(System.out::println)
				.filter(p1)
				.peek(str::add);
		
		//final Operation as forEach has forEach does not have return type
		stream1
			.peek(System.out::println)
			.filter(p1)
			.forEach(str::add);
	
		System.out.println(str);
		
				
	}
}
