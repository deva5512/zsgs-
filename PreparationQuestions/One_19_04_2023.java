package PreparationQuestions;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

public class One_19_04_2023 {

	public static void main(String[] args) {
		String from_date = "25-08-1998";
		String to_date = "27.09.2020";

		usingCalander(from_date, to_date);

		String[] from = from_date.split("-");
		String[] to = to_date.split("\\.");
		from_date = "";
		to_date = "";

		for (int i = from.length - 1; i >= 0; i--) {
			from_date += from[i];
			to_date += to[i];
			if (i != 0) {
				from_date += "-";
				to_date += "-";
			}
		}
		LocalDate local_date_from = LocalDate.parse(from_date);
		LocalDate local_date_to = LocalDate.parse(to_date);

		long days = ChronoUnit.DAYS.between(local_date_from, local_date_to);
		System.out.println(days);

	}

	public static void usingCalander(String from, String to) {

		String[] fro = from.split("-");

		int from_year = Integer.parseInt(fro[2]);
		int from_mon = Integer.parseInt(fro[1]);
		int from_date = Integer.parseInt(fro[0]);

		Calendar cal1 = Calendar.getInstance();
		cal1.set(from_year, from_mon, from_date);

		String[] too = to.split("\\.");

		int to_year = Integer.parseInt(too[2]);
		int to_mon = Integer.parseInt(too[1]);
		int to_date = Integer.parseInt(too[0]);

		Calendar cal2 = Calendar.getInstance();
		cal2.set(to_year, to_mon, to_date);

		long milli1 = cal1.getTimeInMillis();
		long milli2 = cal2.getTimeInMillis();
		long diff = milli2 - milli1;

		long days = diff / (24 * 60 * 60 * 1000);

		System.out.println(days + 1);
	}

}
