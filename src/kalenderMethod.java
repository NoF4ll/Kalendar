import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.IsoFields;
public class kalenderMethod {
	static void calendar(int jahr, int monat) {

		LocalDate currentDay = LocalDate.of(jahr, monat, 1);

		System.out.println(currentDay.getMonth() + "\t" + currentDay.getYear());
		System.out.println("Wo\t Mo\t Di\t Mi\t Do\t Fr\t Sa\t So");
		int calendarWeek = currentDay.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR); //Woche im Jahr
		int newCalendarWeek = calendarWeek;
		System.out.print(calendarWeek + "\t ");

		switch (currentDay.getDayOfWeek()) {
		case MONDAY:
			System.out.print(currentDay.getDayOfMonth()); break;
		case TUESDAY:
			System.out.print("\t " + currentDay.getDayOfMonth()); break;
		case WEDNESDAY:
			System.out.print("\t \t " + currentDay.getDayOfMonth()); break;
		case THURSDAY:
			System.out.print("\t \t \t " + currentDay.getDayOfMonth()); break;
		case FRIDAY:
			System.out.print("\t \t \t \t " + currentDay.getDayOfMonth()); break;
		case SATURDAY:
			System.out.print("\t \t \t \t \t " + currentDay.getDayOfMonth()); break;
		case SUNDAY:
			System.out.print("\t \t \t \t \t \t " + currentDay.getDayOfMonth()); break;
		}
		currentDay = currentDay.plusDays(1);

		while (currentDay.getMonthValue() == monat)
		{
			if (newCalendarWeek != calendarWeek) {
				System.out.print(newCalendarWeek);
			}
			calendarWeek = newCalendarWeek;
			if (currentDay.getDayOfWeek() == DayOfWeek.SUNDAY) {
				System.out.println("\t " + currentDay.getDayOfMonth());
			} else {
				System.out.print("\t " + currentDay.getDayOfMonth());
			}
			currentDay = currentDay.plusDays(1);
			newCalendarWeek = currentDay.get(IsoFields.WEEK_OF_WEEK_BASED_YEAR);
		} 
	}
}