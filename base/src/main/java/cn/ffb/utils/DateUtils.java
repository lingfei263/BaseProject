package cn.ffb.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * @author lingfei 2017-5-9
 */
public class DateUtils {
    public final static DateFormat DATEFORMAT_HH_MM = new SimpleDateFormat("HH:mm",
            Locale.SIMPLIFIED_CHINESE);

    /**
     * 将时间格式化为HH:SS形式的
     */
    public static String getFormatTime(int hourOfDay, int minute) {
        StringBuffer sb = new StringBuffer();
        if (hourOfDay < 10) {
            sb.append("0" + hourOfDay);
        } else {
            sb.append(hourOfDay);
        }
        sb.append(":");
        if (minute < 10) {
            sb.append("0" + minute);
        } else {
            sb.append(minute);
        }
        return sb.toString();
    }


    /**
     * 根据小时获取凌晨、上午、中午、下午、晚上
     */
    public static String getHourOfDayString(int hour) {
        StringBuffer sb = new StringBuffer();
        if (0 <= hour && hour <= 6) {
            sb.append("凌晨 ");
        } else if (hour < 11) {
            sb.append("上午 ");
        } else if (hour < 13) {
            sb.append("中午 ");
        } else if (hour < 18) {
            sb.append("下午 ");
        } else {
            sb.append("晚上 ");
        }
        return sb.toString();
    }

    /**
     * 格式化消息通知的日期
     */
    public static String getMessageSimpleDate(long time) {
        StringBuffer sb = new StringBuffer();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Calendar nowCalendar = Calendar.getInstance();
        int nowYear = nowCalendar.get(Calendar.YEAR);
        int year = calendar.get(Calendar.YEAR);
        int nowMonth = nowCalendar.get(Calendar.MONTH);
        int month = calendar.get(Calendar.MONTH);
        int nowDay = nowCalendar.get(Calendar.DAY_OF_MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        if (nowYear - year < 1) {
            if (nowMonth - month < 1) {
                if (nowDay - day < 1 && nowDay - day >= 0) {
                    sb.append("今天  ");
                } else if (nowDay - day < 2) {
                    sb.append("昨天  ");
                } else {
                    sb.append(new SimpleDateFormat("MM月dd日 ", Locale.SIMPLIFIED_CHINESE).format(time));
                }
            } else {
                int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
                if (nowDay + day - maxDay == 1) {
                    sb.append("昨天  ");
                } else {
                    sb.append(new SimpleDateFormat("MM月dd日 ", Locale.SIMPLIFIED_CHINESE).format(time));
                }
            }
        } else {
            sb.append(new SimpleDateFormat("yyyy年MM月dd日 ", Locale.SIMPLIFIED_CHINESE).format(time));
        }

        return sb.toString();

    }

    /**
     * 格式化消息通知的日期
     *
     * @param time
     * @return
     */
    public static String getMessageDate(long time) {
        StringBuffer sb = new StringBuffer();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        Calendar nowCalendar = Calendar.getInstance();
        int nowYear = nowCalendar.get(Calendar.YEAR);
        int year = calendar.get(Calendar.YEAR);
        int nowMonth = nowCalendar.get(Calendar.MONTH);
        int month = calendar.get(Calendar.MONTH);
        int nowDay = nowCalendar.get(Calendar.DAY_OF_MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (nowYear - year < 1) {
            if (nowMonth - month < 1) {
                if (nowDay - day < 1) {
                    sb.append(getHourOfDayString(hour));
                    sb.append(DATEFORMAT_HH_MM.format(time));
                } else if (nowDay - day < 2) {
                    sb.append("昨天  ");
                    sb.append(getHourOfDayString(hour));
                    sb.append(DATEFORMAT_HH_MM.format(time));
                } else {
                    sb.append(new SimpleDateFormat("MM-dd " + "HH:mm", Locale.SIMPLIFIED_CHINESE)
                            .format(time));
                }
            } else {
                sb.append(new SimpleDateFormat("MM-dd " + "HH:mm", Locale.SIMPLIFIED_CHINESE).format(time));
            }
        } else {
            sb.append(new SimpleDateFormat("yyyy-MM-dd " + "HH:mm", Locale.SIMPLIFIED_CHINESE)
                    .format(time));
        }

        return sb.toString();

    }
}
