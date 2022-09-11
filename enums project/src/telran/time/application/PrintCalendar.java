package telran.time.application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.time.temporal.TemporalField;
import java.util.Locale;

public class PrintCalendar {

	private static int dayOfWeek;

	public static void main(String[] args) {
		
		int dayMonthYear[];
		try {
			dayMonthYear = getDayMonthYear(args);
			printCalendar(dayMonthYear[0], dayMonthYear[1], dayMonthYear[2]);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static void printCalendar(int month, int year, int dayOfWeek) {
		DayOfWeek weekDay = DayOfWeek.MONDAY;
		if (dayOfWeek > 0) {
			weekDay = DayOfWeek.of(dayOfWeek);
		}
		
		System.out.printf("%s\n",weekDay.getDisplayName(TextStyle.FULL,
				Locale.forLanguageTag("ru")));
		printTitle(month, year);
		printWeekDays(dayOfWeek);
		printDates(month, year);
		
	}

	private static void printDates(int month, int year) {
		int column = getFirstColumn(month, year);
		printOffset(column);
		int nDays = getMonthDays(month, year);
		int nWeekDays = DayOfWeek.values().length;
		for(int day = 1; day <= nDays; day++) {
			System.out.printf("%4d", day);
			column++;
			if(column == nWeekDays) {
				column = 0; 
				System.out.println();
			}
			
		}
		
	}

	private static int getMonthDays(int month, int year) {
		YearMonth ym = YearMonth.of(year, month);
				
		return ym.lengthOfMonth();
	}

	private static void printOffset(int column) {
		System.out.printf("%s", " ".repeat(column * 4));
		
	}

	private static int getFirstColumn(int month, int year) {
		LocalDate firstMonthDate = LocalDate.of(year, month, 1);
		int weekDay = firstMonthDate.getDayOfWeek().getValue();
		int firstWeekDay = DayOfWeek.values()[0].getValue();
		return weekDay - firstWeekDay;
	}

	private static void printWeekDays(int dayOfWeek) {
		DayOfWeek dayWeeks[] = DayOfWeek.values();
		if (dayOfWeek > 0) {
			dayWeeks[0] = DayOfWeek.of(dayOfWeek);
			for (int i = 1; i < 7; i++) {
				dayWeeks[i] = dayWeeks[i - 1].plus(1);
			}
		}
	
		System.out.print("  ");
		for(DayOfWeek weekDay: dayWeeks) {
			System.out.printf("%s ", weekDay.getDisplayName(TextStyle.SHORT, Locale.getDefault()));
		}
		System.out.println();
		
	}

	private static void printTitle(int month, int year) {
		Month monthEn = Month.of(month);
		System.out.printf("%s, %d\n", monthEn.getDisplayName(TextStyle.FULL,
				Locale.getDefault()), year);
		
	}

	private static int[] getDayMonthYear (String[] args) throws Exception {
		LocalDate current = LocalDate.now();
		int [] res = {current.getMonthValue(), current.getYear(), dayOfWeek};
		if (args.length > 0) {
			res[0] = getMonth(args[0]);
			if (args.length > 1) {
				res[1] = getYear(args[1]);
				if (args.length > 2) {
					res[2] = getDayOfWeek(args[2]);
				}
			}
		}
		
		return res;
	}

	private static int getDayOfWeek(String dayStr) throws Exception {
		try {
			int res = 0;
			for (int i = 1; i <= 7; i++) {
				if (DayOfWeek.of(i).toString().equals(dayStr.toUpperCase())) {
					res = i;
				}
			}

			if (res == 0) {
				throw new Exception(
						String.format("days %s is wrong value;" + " should be in the range [MONDAY - SUNDAY]", dayStr));
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("should be a name of day");
		}
	}

	private static int getYear(String yearStr) throws Exception {
		try {
			int res = Integer.parseInt(yearStr);
			if (res <= 0) {
				throw new Exception("year should be a positive number");
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("year should be a number");
		}
		
		
	}

	private static int getMonth(String monthStr) throws Exception{
		try {
			int res = Integer.parseInt(monthStr);
			int nMonths = Month.values().length;
			if (res < 1 || res > nMonths) {
				throw new Exception(String.format("month %d is wrong value;"
						+ " should be in the range [1, %d]", res, nMonths));
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("month should be a number");
		}
		
	}

}
