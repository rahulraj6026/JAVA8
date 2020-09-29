package DateAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CollectionSample {
	public static void main(String[] args) throws IOException {
		List<People> list = new ArrayList<>();
		try(
				BufferedReader br = new BufferedReader(
						new InputStreamReader(
								CollectionSample.class.getResourceAsStream("People.txt")
						));
				Stream<String> stream = br.lines();
				
			){
				stream.map(
					line ->	{
						String str[] = line.split(" ");
						//fetch name and the year
						String name = str[0].trim();
						int year = Integer.parseInt(str[1]);
						Month month = Month.of(Integer.parseInt(str[2]));
						int day = Integer.parseInt(str[3]);
						
						//create a instance of people
						People p = new People(name, LocalDate.of(year, month, day));
						list.add(p);
						return p;
					})
					.forEach(System.out::println);
			}
			LocalDate now = LocalDate.of(2020, 9, 10);
			
			list.stream().forEach(
					p -> {
						Period per = Period.between(p.getDate(), now);
						
						System.out.println(
								p.getName()+" Was born "+ per.get(ChronoUnit.YEARS)+" Years ago "+
								per.get(ChronoUnit.MONTHS)+" Months ago "+
								per.get(ChronoUnit.DAYS)+" Day Ago "+
								" Total months "+
								p.getDate().until(now, ChronoUnit.MONTHS)+" "+
								p.getDate().until(now, ChronoUnit.YEARS)
						);
						
					}
			
			);
	}
}
