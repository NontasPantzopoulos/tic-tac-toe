package main.tictactoe.utils;

import java.time.Instant;
import java.util.Date;

public class GeneralUtils {
	
	public static void log(String className,String log) {
		long timestamp = Instant.now().toEpochMilli();
		Date date =new Date(timestamp);
		System.out.println(String.valueOf(timestamp)+"-"+
		"-"+(1900+date.getYear())+"-"+(date.getMonth()+1)+"-"+
				date.getDate()+"--"+
				date.getHours()+":"+
				date.getMinutes()+":"+
				date.getSeconds()+"--"+className+"-"+log);
	}

}
