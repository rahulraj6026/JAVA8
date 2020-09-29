package maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FetchMap {
	private static Map<Integer, List<People>> mapList(List<People> list){
		return list.stream().collect(
				Collectors.groupingBy(
						People::getAge
				)
		);
	}
	public static void main(String[] args) throws IOException {
		List<People> list = new ArrayList<>();
		try(
				BufferedReader br = new BufferedReader(
						new InputStreamReader(FetchMap.class.getResourceAsStream("People.txt")));
						Stream<String> stream = br.lines();
		){
			stream.map( p -> {
				String str[] = p.split(" ");
				People peo = new People(
						str[0], Integer.parseInt(str[1]), str[2]
				);
				list.add(peo);
				return peo;
			})
			.forEach(System.out::println);
			
			System.out.println("==========================================================");
			
			//divide into two sublists
			List<People> list1 = list.subList(0, 4);
			List<People> list2 = list.subList(4, list.size());
			
			//Get a map wit people merged by age and list of people
			Map<Integer, List<People>> map1 = mapList(list1);
			Map<Integer, List<People>> map2 = mapList(list2);
			
			//iterate through and print age and the list
			map1.forEach((age, peo) -> System.out.println(age+" "+peo));
			System.out.println("==============================================");
			map2.forEach((age, peo) -> System.out.println(age+" "+peo));
			
			//Merge map1 and map2
			map2.entrySet().stream()
				.forEach(entry -> 
					map1.merge(
							entry.getKey(),
							entry.getValue(),
							(l1, l2) -> { //if key already exists then add second list into first list
								l1.addAll(l2);
								return l1;
							}
					)
				);
			
			System.out.println("================== merged ");
			map1.forEach((age, peo) -> System.out.println(age+" "+peo.toString()));
		}
		
	}
}
