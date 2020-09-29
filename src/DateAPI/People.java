package DateAPI;

import java.time.LocalDate;

/*
 * Bean to store name and DOB of People using localdate
 */
public class People {
	String name;

	LocalDate date;
	
	public People(String name, LocalDate date) {
		this.name = name;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}

	public LocalDate getDate() {
		return date;
	}
	
	public String toString() {
		return "Person [" + this.name +", "+ this.date + "]";
	}
}
