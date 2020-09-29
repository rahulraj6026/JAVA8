package maps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Bimap {
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
						new InputStreamReader(Bimap.class.getResourceAsStream("People.txt")));
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
			
			System.out.println("grouping ==========================================================");
			
			//divide into two sublists
			List<People> list1 = list.subList(0, 4);
			List<People> list2 = list.subList(4, list.size());
			
			//Get a map wit people merged by age and list of people
			Map<Integer, List<People>> map1 = mapList(list1);
			Map<Integer, List<People>> map2 = mapList(list2);
			
			//iterate through and print age and the list
			map1.forEach((age, peo) -> System.out.println(age+" "+peo));
			System.out.println("second map result ==============================================");
			map2.forEach((age, peo) -> System.out.println(age+" "+peo));
			
			//Bimap example
			HashMap<Integer, Map<String, List<People>>> bimap = new HashMap<>();
			
			list.forEach(
					people -> {
						bimap.computeIfAbsent(//if the key is absent then we create a new HashMap
								people.getAge(), 
								HashMap::new
						).merge(
								people.getGender(),
								new ArrayList<People>(Arrays.asList(people)),//because Arrays.asList cannot be changed
								(l1, l2) -> {
									l1.addAll(l2);
									return l1;
								}
						);
					}
			);
			
			System.out.println("Bi map result ==================================================");
			bimap.forEach((age, map) -> System.out.println(age+" "+map.toString()));
		}
		
	}
}
