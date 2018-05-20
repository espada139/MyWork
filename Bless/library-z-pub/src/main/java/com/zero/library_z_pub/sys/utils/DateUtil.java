package com.zero.library_z_pub.sys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by xiaocai on 2018/5/4.
 */

public class DateUtil {

    private static String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 此方法输入所要转换的时间输入例如（"2017-11-01 22:11:00"）返回时间戳
     * @param date_str
     * @return
     * @throws ParseException
     */
    public static long dateToStamp(String date_str) throws ParseException{

        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YMDHMS, Locale.CHINA);
        Date date = sdf.parse(date_str);

        return date.getTime();

    }

    /**
     * 将时间戳转换为时间
     * @param stamp
     * @return
     */
    public static String stampToDate(long stamp){

        String res;
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_YMDHMS, Locale.CHINA);
        Date date = new Date(stamp);
        res = sdf.format(date);

        return res;

    }

}
