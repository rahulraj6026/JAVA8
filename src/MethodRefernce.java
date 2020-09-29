import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class MethodRefernce {
	public static void main(String[] args) {
		List<String> string = Arrays.asList("apple","ball", "cat","dog");
		
		List<String> res = new ArrayList<String>();
		
		Consumer<String> consumer = s -> System.out.println(s);//Lambda Expression
		
		Consumer<String> consumer1 = System.out::println;//Method Reference
		
		Consumer<String> consumer2 = s -> res.add(s);//Lambda Expression
		
		Consumer<String> consumer3 = res::add;
		
		Consumer<String> consumer4 = System.out::println;
		
		string.forEach(consumer3);
		res.forEach(consumer4); 
	}
}
