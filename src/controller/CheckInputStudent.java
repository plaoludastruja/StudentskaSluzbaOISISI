package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class CheckInputStudent {
	
	public static boolean checkFirstLastName(String s) {
		String regex = "[A-ZŽŠĐČĆ].+";
		if(s.matches(regex))
			return true;
		
		return false;
	}
	
	public static boolean checkDate(String s) {	
		try {
			LocalDate.parse(s, DateTimeFormatter.ofPattern("dd.MM.yyyy."));
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
	public static boolean checkAddress(String s) {
		String regex = ".*[,].*[,].*[,].*";
		if(s.matches(regex))
			return true;
		
		return false;
	}
	public static boolean checkPhone(String s) {
		String regex = ".+";
		if(s.matches(regex))
			return true;
		
		return false;
	}
	public static boolean checkEmail(String s) {
		String regex = ".*[@].*\\..*";
		if(s.matches(regex))
			return true;
		
		return false;
	}
	public static boolean checkIndex(String s) {
		String regex = ".+";
		if(s.matches(regex))
			return true;
		
		return false;
	}
	public static boolean checkIndexYear(String s) {
		String regex = "[0-9]{4}";
		if(s.matches(regex))
			return true;
		
		return false;
	}
	
	
}
