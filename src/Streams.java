import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams {
	public static void main(String[] args) {
		Stream<String> stream = Stream.of("one", "tenths", "hundreds","thousands");
		
		Predicate<String> p1 = s -> s.length() > 3;
		
		Predicate<String> p2 = Predicate.isEqual("tenths");
		Predicate<String> p3 = Predicate.isEqual("one");
		
		
		/*
		 * stream. filter(p1).forEach(s -> System.out.println(s));
		 */
		
		stream.
		filter(p2.or(p3)).forEach(s -> System.out.println(s));
		
		
				
	}
}
