package Streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsSample {
	public static void main(String[] args) {
		List<People> list = new ArrayList<>();
		
		try(
				BufferedReader br = 
				new BufferedReader(new InputStreamReader(
						CollectorsSample.class.getResourceAsStream(("people.txt"))));
		
				Stream<String> stream = br.lines();
		){
			stream.map(line -> {
				String[] str = line.split(" ");
				People p = new People(str[0].trim(), Integer.valueOf(str[1]));
				list.add(p);
				return p;
			})
			.forEach(System.out::println);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		Stream<People> stream = list.stream();
		
		System.out.println();
		
		//Stream to find the min among people whose age is >= 20
		Optional<People> opt = stream.
										filter(p -> p.getAge() >= 20)
										.min(Comparator.comparing(People::getAge));
		
		//As the stream is already processed we can create a new stream as it is a light
		//weight process else we use the same stream we get exception IllegalState
		Optional<People> opt1 = list.stream().
										max(Comparator.comparing(People::getAge));
		
		System.out.println(opt1);
		
		//group by age and name
		Map<Integer, List<People>> p = 
		list.stream()
			.collect(Collectors.groupingBy(People::getAge));
		
		//group by age and return their names
		Map<Integer, List<String>> p1 = 
				list.stream()
					.collect(
							Collectors.groupingBy(	People::getAge,
							Collectors.mapping(People::getName, Collectors.toList())
						));
		
		System.out.println("Group by age " + p1);
		
		//group by age and return the count
		Map<Integer, Long> p2 = 
					list.stream()
					.collect(
							Collectors.groupingBy(
									People::getAge,
									Collectors.counting()
							)
					);
		
		System.out.println("count "+ p2);
		
		//group by age and return it as a collection
				Map<Integer, Set<String>> p3 = 
							list.stream()
							.collect(
									Collectors.groupingBy(
											People::getAge,
											Collectors.mapping(
													People::getName,
													Collectors.toCollection(TreeSet::new)
											)
									)
							);
				
			System.out.println("Collection is " + p3);
				
				//return as a string
				Map<Integer, String> p4 = 
						list.stream()
						.collect(
								Collectors.groupingBy(
										People::getAge,
										Collectors.mapping(
												People::getName,
												Collectors.joining(", ")
										)
								)
						);
		
	System.out.println("return the result as String " + p4);
	}
}
