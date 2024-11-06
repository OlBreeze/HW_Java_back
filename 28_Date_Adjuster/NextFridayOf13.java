package my.adj;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

public class NextFridayOf13 implements TemporalAdjuster{

	@Override
	public Temporal adjustInto(Temporal temporal) {
		LocalDate curDate = LocalDate.from(temporal);
		LocalDate newDate = curDate.getDayOfMonth() >= 13? curDate.plusMonths(1).withDayOfMonth(13): curDate.minusMonths(1).withDayOfMonth(13);
		
		while(true){
			if(newDate.getDayOfWeek() == DayOfWeek.FRIDAY)
				return newDate;
			newDate = newDate.plusMonths(1);
		}
	}
}
