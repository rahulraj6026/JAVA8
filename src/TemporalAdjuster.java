import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class TemporalAdjuster {
	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		
		LocalDate sunday = date.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		
		System.out.println(sunday);
	}
}
