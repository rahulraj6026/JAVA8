package Streams;

public class People {
	String name;
	int age;
	
	public People(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return "Person [" + this.name +", "+ this.age + "]";
	}
	
	
}
