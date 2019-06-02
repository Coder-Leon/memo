package com.flywithxinxin.memo.util;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DateTimeUtil {
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static String formatDateTime(Date datetime) {
        SimpleDateFormat df = new SimpleDateFormat(DATETIME_FORMAT);
        df.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
        return df.format(datetime);
    }

    public static String formatDateTimeNew(Date datetime){
        Instant instant = datetime.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

}
