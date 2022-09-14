package telran.time.application;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Timer;
import java.util.TimerTask;

//Application class
//Performs beeps each specified time interval
public class Reminder {

	public static void main(String[] args) {
		// mandatory args[0] interval value
		// mandatory args[1] ChronoUnit enum string value (case insensitive)
		// optional args[2] when ended in the given ChronoUnit (see args[1]), default in
		// 1 hour
		// beep System.out.println("\007\007\007") - will sound only on real console
		// example of launching: java -jar reminder.jar 10 seconds 100 -
		// each 10 seconds during 100 seconds there should be beeps
		long timerArguments[];
		long intervalMs;
		final Timer time = new Timer();
		try {
			timerArguments = getArguments(args);
			ChronoUnit unit = getTimeUnit(args);
			intervalMs = timerArguments[0] * unit.getDuration().toMillis();
			LocalDateTime finishTime = LocalDateTime.now().plus(timerArguments[1], unit);
			TimerTask timerBody = new TimerTask() {
				@Override
				public void run() {
					LocalDateTime current = LocalDateTime.now();
					if (current.compareTo(finishTime) >= 0) {
						signal();
						time.cancel();
						return;
					}
					signal();
				}
				private void signal() {
					System.out.println("\007\007\007");
				}
			};
			time.schedule(timerBody, intervalMs, intervalMs);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private static long[] getArguments(String[] args) throws Exception {
		long[] res;
		res = new long[2];
		try {
			if (args.length > 2) {
				res[0] = getTimeInterval(args[0]);
				res[1] = getTimePeriod(args[2]);
				return res;
			}
			throw new Exception("please input arguments [Interval, Unit, Period]");

		} catch (NumberFormatException e) {
			throw new Exception("time period should be a number");
		}
	}

	private static long getTimePeriod(String timePeriod) throws Exception {
		try {
			long res = Integer.parseInt(timePeriod);
			if (res <= 0) {
				throw new Exception("time period should be a positive number");
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("time period should be a number");
		}
	}

	private static long getTimeInterval(String timeInterval) throws Exception {
		try {
			long res = Integer.parseInt(timeInterval);
			if (res <= 0) {
				throw new Exception("time interval should be a positive number");
			}
			return res;
		} catch (NumberFormatException e) {
			throw new Exception("time interval should be a number");
		}

	}

	private static ChronoUnit getTimeUnit(String[] timeUnit) throws Exception {
		try {
			ChronoUnit unit = ChronoUnit.valueOf(timeUnit[1].toUpperCase());
			return unit;
		} catch (Exception e) {
			throw new Exception("wrong name of time unit " + timeUnit[1]);
		}

	}

}
