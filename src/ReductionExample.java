import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReductionExample {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList();
		
		int res = 
				list.stream().reduce(0, Integer::sum);
		//(i1, i2) -> i1 + i2 This can also be written as Integer::sum
		
		
		int maxres = 
				list.stream().reduce(0, Integer::max);
		
		//we can also use Option instead of passing an Identity
		
		Optional<Integer> opt = 
				list.stream().reduce(Integer::max);
		
		System.out.println(res+" "+opt);
				
	}
}
