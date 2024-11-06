package my.calendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class PrintCalendarAppl {

	private static final int DATE_WIDTH = 4;
	private static final int DEFAULT_FIRST_DAY = 7;

	public static void main(String[] args) {
		try {
			DateArguments date = args.length == 3 ? getDateArguments(args) : getCurrentDateArguments();
			printCalendar(date);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	private static void printCalendar(DateArguments date) {
		printTitle(date);
		printWeekdayNames(date);
		printDates(date);
	}

	private static void printDates(DateArguments date) {
		int firstColumn = getFirstColumn(date);

		for (int i = DATE_WIDTH; i < firstColumn * DATE_WIDTH; i++) {
			System.out.print(" ");
		}
		printNumbersFromOffset(date, firstColumn);
	}

	private static void printNumbersFromOffset(DateArguments date, int firstColumn) {
		YearMonth temp = YearMonth.of(date.year(), date.month());
		int days = temp.lengthOfMonth();
		for (int i = 1; i <= days; i++) {
			System.out.printf("%4d", i);
			if (firstColumn == 7) {
				firstColumn = 1;
				System.out.println();
			} else {
				firstColumn++;
			}
		}

	}

	private static int getFirstColumn(DateArguments date) {
		int firstDayOfWeek = date.firstDayOfWeek();

		LocalDate temp = LocalDate.of(date.year(), date.month(), 1);
		int dayOfWeekFirstDay = temp.getDayOfWeek().getValue();
		int diff = dayOfWeekFirstDay - firstDayOfWeek;
		
		return diff >= 0 ? diff + 1 : diff + 8;
	}

	private static void printWeekdayNames(DateArguments date) {
		System.out.print("  ");

		int firstDayOfWeek = date.firstDayOfWeek();

		for (int i = firstDayOfWeek; i < firstDayOfWeek + 7; i++) {
			
			DayOfWeek day = DayOfWeek.of(i < 8 ? i : i - 7);
			
			String str = day.getDisplayName(TextStyle.SHORT, Locale.forLanguageTag("en"));
			System.out.print(str + " ");
		}
		System.out.println();
	}

	private static void printTitle(DateArguments date) {
		Month m = Month.of(date.month());
		String str = m.getDisplayName(TextStyle.FULL, Locale.forLanguageTag("en"));
		System.out.printf("%8s%s %d\n", " ", str, date.year());

	}

	private static DateArguments getCurrentDateArguments() {
		LocalDate date = LocalDate.now();
		return new DateArguments(date.getYear(), date.getMonthValue(), DEFAULT_FIRST_DAY);
	}

	private static DateArguments getDateArguments(String[] args) throws Exception {
		int year = Integer.parseInt(args[0]);
		int month = Integer.parseInt(args[1]);
		int firstDayOfWeek = Integer.parseInt(args[2]);

		if (month < 1 || month > 12)
			throw new Exception("Month must be in range from 1 to 12");

		if (firstDayOfWeek < 1 || firstDayOfWeek > 7)
			throw new Exception("First day of week  must be in range from 1 to 7");

		return new DateArguments(year, month, firstDayOfWeek);

	}

}
