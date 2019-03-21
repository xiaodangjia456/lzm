package com.source.root.tools.format;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil extends org.apache.poi.ss.usermodel.DateUtil {

	// private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	// private static SimpleDateFormat sdf1 = new
	// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// private static SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
	// private static SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
	// private static SimpleDateFormat sdf4 = new
	// SimpleDateFormat("yyyy/MM/dd");

	/**
	 * 鏃ユ湡yyyy-MM-dd杞崲鎴怱tring鍨�
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateToString = "";
		dateToString = sdf.format(date);
		return dateToString;
	}
	public static String dateToString2(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		String dateToString = "";
		dateToString = sdf.format(date);
		return dateToString;
	}

	/**
	 * 鏃ユ湡yyyy-MM-dd HH:mm:ss杞崲鎴怱tring鍨�
	 * 
	 * @param date
	 * @return
	 */
	public static String dateTimeToString(Date date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String DateTimeToString = "";
		DateTimeToString = sdf1.format(date);
		return DateTimeToString;
	}

	public static String dateTimeToString2(Date date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss-SSSS");
		String DateTimeToString = "";
		DateTimeToString = sdf1.format(date);
		return DateTimeToString;
	}

	/**
	 * 鏃ユ湡HH:mm:ss杞崲鎴怱tring鍨�
	 * 
	 * @param date
	 * @return
	 */
	public static String timeToString(Date date) {
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		String timeToString = "";
		timeToString = sdf2.format(date);
		return timeToString;
	}

	// ==============================杩斿洖Date================================//

	/**
	 * 瀛楃涓瞴yyy-MM-dd杞崲鎴怐ate鍨�
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date toDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date toDate = sdf.parse(date);
		return toDate;
	}

	public static Date toDate2(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date toDate = sdf.parse(date);
		return toDate;
	}

	/**
	 * 瀛楃涓瞴yyy-MM-dd HH:mm:ss杞崲鎴怐ate鍨�
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date toDateTime(String date) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date toDateTime = null;
		try {
			toDateTime = sdf1.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return toDateTime;
	}

	/**
	 * 瀛楃涓瞴yyy-MM-dd HH:mm:ss杞崲鎴怐ate鍨�
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date longToDate(String longTime) {
		long _longTime = Long.valueOf(longTime);
		Date date = new Date(_longTime);
		return date;
	}

	/**
	 * 骞撮緞璁＄畻
	 * 
	 * @param birthday
	 * @return
	 * @throws ParseException
	 */
	public static int toAge(String birthday) throws ParseException {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Date mydate = myFormatter.parse(birthday);
		long day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000) + 1;
		String year = new DecimalFormat("#").format(day / 365f);
		return Integer.valueOf((String) year);
	}

	/**
	 * 骞撮緞璁＄畻
	 * 
	 * @param birthday
	 * @return
	 * @throws ParseException
	 */
	public static long toDays(String start, String end) throws ParseException {
		SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date _end = myFormatter.parse(end);
		Date _start = myFormatter.parse(start);
		long day = (_end.getTime() - _start.getTime()) / (24 * 60 * 60 * 1000) + 1;
		return day;
	}

	/**
	 * 12灏忔椂鍒惰浆鎹负24灏忔椂鍒�
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	@SuppressWarnings("deprecation")
	public static Date stringToDate24(String date) throws ParseException {
		SimpleDateFormat myFormatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date date1 = myFormatter.parse(date);
		if (date.toLowerCase().endsWith("pm")) {
			if (date1.getHours() < 12) {
				date1.setHours((date1.getHours() + 12));
			}
		}
		return date1;
	}

	public static long dateToGetTime(String prama) throws ParseException {
		SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMdd");
		Date _prama = sdf3.parse(prama);
		return _prama.getTime();
	}

	/**
	 * addDay == Date+day
	 * 
	 * @Title: addDay
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param date
	 * @param @param day
	 * @param @return 设定文件
	 * @return Date 返回类型
	 * @throws
	 */
	public static Date addDay(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

	/**
	 * List<Date>==StartDate-->endDate
	 * 
	 * @Title: potatoIllDate
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param startDate
	 * @param @param endDate
	 * @param @return
	 * @param @throws ParseException 设定文件
	 * @return List<Date> 返回类型
	 * @throws
	 */
	public static List<Date> potatoIllDate(String startDate, String endDate) throws ParseException {
		List<Date> listDate = new ArrayList<Date>();
		Date end_Date = toDate(endDate);
		Date now_Date = toDate(startDate);
		listDate.add(now_Date);
		do {
			now_Date = addDay(now_Date, 1);
			listDate.add(now_Date);
		} while (now_Date.getTime() < end_Date.getTime());
		return listDate;
	}

	public static int day_parsec(Date bigDate, Date smallDate) {
		long temp = bigDate.getTime() - smallDate.getTime(); // 相差毫秒数
		int day = (int) (temp / 1000 / 3600 / 24); // 相差小时数 1000mm*3600m
		return day;
	}

	public static float hour_parsec(Date bigDate, Date smallDate) {
		long temp = bigDate.getTime() - smallDate.getTime(); // 相差毫秒数
		long hours = temp / 1000 / 3600; // 相差小时数 1000mm*3600m
		long mins = (temp % (1000 * 3600)) / 1000 / 60;
		float result = Float.valueOf(hours) + ((Float.valueOf(String.valueOf(mins))) / 60);
		DecimalFormat df = new DecimalFormat("#.##");
		return Float.valueOf(df.format(result));
	}

	public static double minute_parsec(Date bigDate, Date smallDate) {
		double temp = bigDate.getTime() - smallDate.getTime(); // 相差毫秒数
		double second = temp / 1000d / 60d; // 分钟数 1000mm*60m
		return second;
	}

	public static void main(String[] args) throws ParseException {
		Date d = addDay(new Date(), 30);
		System.out.println(dateTimeToString(d));

		int d1 = day_parsec(new Date(), d);
		System.out.println(d1);
	}

}
