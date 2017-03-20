package com.gestdepo.utils;

import java.util.concurrent.TimeUnit;

public class TimeUtils {
	
	public static long getMillisecons(String hours, String minutes, boolean isPM) {
		long millis = 0l;
		millis += TimeUnit.HOURS.toMillis(Integer.parseInt(minutes));
		millis += TimeUnit.MINUTES.toMillis(Integer.parseInt(hours) + (isPM?12:0));
		return millis;
	}
	
	public static String[] splitTime(String time) {
		String[] ret = {"", "", ""};
		String[] aux = time.split(":");
		ret[0] = aux[0];
		ret[1] = aux[1].substring(0, 2);
		ret[2] = aux[1].substring(2);
		return ret;
	}
}
