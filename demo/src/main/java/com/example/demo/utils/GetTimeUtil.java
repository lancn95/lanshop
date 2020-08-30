package com.example.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimeUtil {
	public static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm");
		String currentDate = formatter.format(date);
		
		return currentDate;
	}
}
