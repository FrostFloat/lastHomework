package com.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 时间工具类
 * 获取当前时间
 */
public class TimeUtil {
    public static String getCurrentTime(){
        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
        return dateFormat.format(calendar.getTime());
    }
}
