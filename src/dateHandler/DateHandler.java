package dateHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/  koristena stranica
public class DateHandler {

	private static DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy.");
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy.");

	public static String dateTimeToString(LocalDateTime date) {

		String fDate = date.format(timeFormatter);

		return fDate;
	}

	public static LocalDateTime stringToDateTime(String date) {
		LocalDateTime fDate = LocalDateTime.parse(date, timeFormatter);
		return fDate;
	}
	
	public static String dateToString(LocalDate date) {

		String fDate = date.format(formatter);

		return fDate;
	}

	public static LocalDate stringToDate(String date) {
		LocalDate fDate = LocalDate.parse(date, formatter);
		return fDate;
	}

}