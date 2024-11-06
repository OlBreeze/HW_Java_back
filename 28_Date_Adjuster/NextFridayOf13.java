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
//------------- Application

package my.adj;

import java.time.LocalDate;


public class DateOperationApp {

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println(date.with(new NextFridayOf13()));
		 
		LocalDate date1 = LocalDate.of(2024, 12, 13); 
		System.out.println(date1.with(new NextFridayOf13()));

	}

}
