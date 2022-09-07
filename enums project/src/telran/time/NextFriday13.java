package telran.time;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;


public class NextFriday13 implements TemporalAdjuster {

	@Override
	public Temporal adjustInto(Temporal temporal) {
		int dayOfMonth = temporal.get(ChronoField.DAY_OF_MONTH);
		if (dayOfMonth == 13) {
			dayOfMonth++;
		}
		while (dayOfMonth != 13) {
			temporal = temporal.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
			dayOfMonth = temporal.get(ChronoField.DAY_OF_MONTH);
		}
		return temporal;

	}

}
