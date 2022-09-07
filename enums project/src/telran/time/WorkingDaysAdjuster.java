package telran.time;

import java.time.Period;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;

public class WorkingDaysAdjuster implements TemporalAdjuster {

int[] daysOff;
int nDays;
public int[] getDaysOff() {
	return daysOff;
}
public void setDaysOff(int[] daysOff) {
	this.daysOff = daysOff;
}
public int getnDays() {
	return nDays;
}
public void setnDays(int nDays) {
	this.nDays = nDays;
}
public WorkingDaysAdjuster(int[] daysOff, int nDays) {
	
	this.daysOff = daysOff;
	this.nDays = nDays;
}
public WorkingDaysAdjuster() {
}
	@Override
	public Temporal adjustInto(Temporal temporal) {
		
		//return new temporal matching a date after the given days
		int days = this.getnDays() + this.getDaysOff().length;
		return temporal.plus(days, ChronoUnit.DAYS);
	}

}
