package maps;

public class People {
	String name;
	int age;
	String gender;
	
	public People(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}
	
	public String toString() {
		return "["+ this.name+" "+this.age +" "+this.gender+"]";
	}
}
