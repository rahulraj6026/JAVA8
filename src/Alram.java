import java.time.LocalTime;

public class Alram {
	public static void main(String[] args) {
		LocalTime time = LocalTime.now();
		
		LocalTime temp = LocalTime.of(23, 0);
		
		LocalTime alarm = time.plusHours(8);
		
		alarm = temp.plusHours(8);
		
		System.out.println(alarm);
	}
}
